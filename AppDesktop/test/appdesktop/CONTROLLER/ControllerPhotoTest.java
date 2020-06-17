/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;

import appdesktop.CONTROLLER.DAO.MySQLUserDAO;
import appdesktop.CONTROLLER.DAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisa
 */
public class ControllerPhotoTest {
    
    public ControllerPhotoTest() {
    }
 
    //Class to be tested
    private ControllerPhoto ctrlPhoto;
    
    //Dependencies
    private UserDAO sqlUser;
    
    @Before
    public void setUp() {
        ctrlPhoto = new ControllerPhoto();
        sqlUser = mock(MySQLUserDAO.class);
        ctrlPhoto.setDAO(sqlUser);   
    }
    
    /**
     * Test of getPhotoToApprove method, of class ControllerPhoto.
     */
    @Test
    public void testApproveUserPhotoHappyPathScenario() {
      
      when(sqlUser.updateUserPh("luisaespo@gmail.com")).thenReturn("operation ends successfully");
      
      String actualResponse = ctrlPhoto.approveUserPh("luisaespo@gmail.com");
      
      assertEquals("operation ends successfully",actualResponse);
        
    }
    
    @Test
    public void testApproveUserPhotoEmailNull() {
      
      when(sqlUser.updateUserPh(null)).thenReturn("something went wrong");
      
      String actualResponse = ctrlPhoto.approveUserPh(null);
      
      assertEquals("something went wrong",actualResponse);
        
    }
    
    @Test
    public void testApproveUserPhotoEmailEmpty() {
    
      
      when(sqlUser.updateUserPh("")).thenReturn("something went wrong");
      
      String actualResponse = ctrlPhoto.approveUserPh("");
      
      assertEquals("something went wrong",actualResponse);
        
    }
    
}
