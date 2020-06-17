/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;

import appdesktop.CONTROLLER.DAO.MySQLReviewDAO;
import appdesktop.CONTROLLER.DAO.ReviewDAO;
import appdesktop.MODEL.ReviewModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisa
 */
public class ControllerReviewTest {
    
    public ControllerReviewTest() {
    }
 
    //Class to be tested
    ControllerReview ctrlRev;
    
    //Dependencies
    ReviewDAO reviewSql;
    
    List<ReviewModel> expectedResults;
    
    @Before
    public void setUp() {
        ctrlRev = new ControllerReview();
        reviewSql = mock(MySQLReviewDAO.class);
        ctrlRev.setDAO(reviewSql);
        expectedResults = new ArrayList<>();
    }

    /**
     * Test of getRevbyUser method, of class ControllerReview.
     */
    @Test
    public void testGetRevbyUserHappyPathScenario() {
        
        expectedResults.add(new ReviewModel("B&B Margherita","è stata un'esperienza fantastica"));
        expectedResults.add(new ReviewModel("Hotel Experiece","non ci ritorneremo per nulla a mondo"));
        
        when(reviewSql.getReviewsToApprove("luisaespo@gmail.com")).thenReturn(expectedResults);
        
        List<ReviewModel> actualResults = ctrlRev.getRevbyUser("luisaespo@gmail.com");
        
        assertArrayEquals(expectedResults.toArray(),actualResults.toArray());
        
    }
    
    @Test
    public void testGetRevbyUserEmptyEmail() {

        when(reviewSql.getReviewsToApprove("")).thenReturn(expectedResults);
        
        List<ReviewModel> actualResults = ctrlRev.getRevbyUser("");
        
        assertArrayEquals(expectedResults.toArray(),actualResults.toArray());
        
    }
    
     @Test
    public void testGetRevbyUserNullEmail() {
        
        when(reviewSql.getReviewsToApprove(null)).thenReturn(expectedResults);
        
        List<ReviewModel> actualResults = ctrlRev.getRevbyUser(null);
        
        assertArrayEquals(expectedResults.toArray(),actualResults.toArray());
        
    }

}
