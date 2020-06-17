
package appdesktop.CONTROLLER;

import appdesktop.CONTROLLER.DAO.AdministratorDAO;
import appdesktop.CONTROLLER.DAO.MySQLAdministratorDAO;
import appdesktop.MODEL.AdministratorModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisa
 */
public class ControllerAdminTest {
    
    public ControllerAdminTest() {
    }
    
    //Class to be tested
    private ControllerAdmin controllerAdmin;
    
    //Dependencies
    private AdministratorDAO sqlAdmin;
    
    AdministratorModel actualAdmin;
    
    @Before
    public void setUp() {
        controllerAdmin = new ControllerAdmin();
        sqlAdmin = mock(MySQLAdministratorDAO.class);
        controllerAdmin.setDAO(sqlAdmin);
        
        actualAdmin = new AdministratorModel();
    }

    /**
     * Test of getCredentials method, of class ControllerAdmin.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetCredentialsHappyPathScenario() throws ParseException {
        
        actualAdmin.setName("Rita");
        actualAdmin.setSurname("Calabrese");
        actualAdmin.setBirthday(new SimpleDateFormat("dd-mm-yyyy").parse("14-06-1993"));
        
        when(sqlAdmin.getCredentials("Rita", "pass")).thenReturn(actualAdmin);
        
        controllerAdmin.getCredentials("Rita", "pass");
        
        String actualName = actualAdmin.getName();
        String actualSurname = actualAdmin.getSurname();
        Date actualBDay = actualAdmin.getBirthday();
        
        assertEquals("Rita Calabrese 14-06-1993",actualName + " " + actualSurname + " " + new SimpleDateFormat("dd-mm-yyyy").format(actualBDay));
    }
    
    @Test
    public void testGetCredentialsAdminNotPresentInDb(){
        
        when(sqlAdmin.getCredentials("", "pass")).thenReturn(actualAdmin);
        
        AdministratorModel expectedAdmin = controllerAdmin.getCredentials("", "pass");
        assertEquals(expectedAdmin.getName(),actualAdmin.getName());
    }
    @Test
    public void testGetCredentialsAdminIsNull(){
        
        when(sqlAdmin.getCredentials(null, "pass")).thenReturn(actualAdmin);
        
        AdministratorModel expectedAdmin = controllerAdmin.getCredentials(null, "pass");
        assertEquals(expectedAdmin.getName(),actualAdmin.getName());
    }
    
      @Test
    public void testGetCredentialsPasswordNotPresentInDb(){
        
        when(sqlAdmin.getCredentials("Rita", "")).thenReturn(actualAdmin);
        
        AdministratorModel expectedAdmin = controllerAdmin.getCredentials("Rita", "");
        assertEquals(expectedAdmin.getName(),actualAdmin.getName());
    }
    @Test
    public void testGetCredentialsPasswordIsNull(){
        
        when(sqlAdmin.getCredentials("Rita", null)).thenReturn(actualAdmin);
        
        AdministratorModel expectedAdmin = controllerAdmin.getCredentials("Rita", null);
        assertEquals(expectedAdmin.getName(),actualAdmin.getName());
    }
}
