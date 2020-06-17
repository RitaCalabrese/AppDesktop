/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;


import appdesktop.MODEL.UserModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luisa
 */
public class ControllerUsersInfoTest {
    
    public ControllerUsersInfoTest() {
    }
    
   //Class to be tested
    private ControllerUsersInfo ctrlUserInfo;
    
    private List<UserModel> actualResults;
    
    @Before
    public void setUp() {
        ctrlUserInfo = new ControllerUsersInfo();
        actualResults = new ArrayList<>();
    }
    
    /**
     * Test of orderByReviewsDesc method, of class ControllerUsersInfo.
     */
    @Test
    public void testOrderByReviewsDescPositiveDifferentValues() {
        
        actualResults.add(new UserModel("pippo","esposito",3));
        actualResults.add(new UserModel("francesco","rossi",7));
        actualResults.add(new UserModel("mario","bianchi",1));
        int[] actualRes = new int[3];
        
        ctrlUserInfo.orderByReviewsDesc(actualResults);
        
        actualRes[0]=  actualResults.get(0).getAmountWrittenReviews();
        actualRes[1]=  actualResults.get(1).getAmountWrittenReviews();
        actualRes[2]=  actualResults.get(2).getAmountWrittenReviews();
        assertEquals(7,actualRes[0]);
        assertEquals(3,actualRes[1]);
        assertEquals(1,actualRes[2]);
    }

    @Test
    public void testOrderByReviewsDescPositiveSameValues() {
        
        actualResults.add(new UserModel("pippo","esposito",2));
        actualResults.add(new UserModel("francesco","rossi",2));
        actualResults.add(new UserModel("mario","bianchi",2));
        int[] actualRes = new int[3];
        
        ctrlUserInfo.orderByReviewsDesc(actualResults);
       
        actualRes[0]=  actualResults.get(0).getAmountWrittenReviews();
        actualRes[1]=  actualResults.get(1).getAmountWrittenReviews();
        actualRes[2]=  actualResults.get(2).getAmountWrittenReviews();
        
        assertEquals(2,actualRes[0]);
        assertEquals(2,actualRes[1]);
        assertEquals(2,actualRes[2]);
    }
   
    @Test(expected = IndexOutOfBoundsException.class)
    public void testOrderByReviewsDescEmptyValue() {
        
        ctrlUserInfo.orderByReviewsDesc(actualResults);
    }
    
    @Test
    public void testOrderByRatingDescPositiveDifferentValues(){
        
        actualResults.add(new UserModel("pippo","esposito",2.3F));
        actualResults.add(new UserModel("francesco","rossi",4.1F));
        actualResults.add(new UserModel("mario","bianchi",1.8F));
        float[] actualRes = new float[3];
        
        ctrlUserInfo.orderByRatingDesc(actualResults);
        
        actualRes[0]=  actualResults.get(0).getAverageUserRating();
        actualRes[1]=  actualResults.get(1).getAverageUserRating();
        actualRes[2]=  actualResults.get(2).getAverageUserRating();
        
        assertEquals(4.1F,actualRes[0],0.0F);
        assertEquals(2.3F,actualRes[1],0.0F);
        assertEquals(1.8F,actualRes[2],0.0F);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testOrderByRatingDescEmptyValue() {
        
        ctrlUserInfo.orderByRatingDesc(actualResults);
    }
    
    @Test
    public void testOrderByBDayDescDifferentDates() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        actualResults.add(new UserModel("pippo","esposito",  dateFormat.parse("14-03-1993")));
        actualResults.add(new UserModel("francesco","rossi", dateFormat.parse("07-08-1998")));
        actualResults.add(new UserModel("mario","bianchi", dateFormat.parse("29-09-1980")));
   
        ctrlUserInfo.orderByBDayDesc(actualResults);
 
        assertEquals(dateFormat.parse("07-08-1998"),actualResults.get(0).getBirthday());
        assertEquals(dateFormat.parse("14-03-1993"),actualResults.get(1).getBirthday());
        assertEquals(dateFormat.parse("29-09-1980"),actualResults.get(2).getBirthday());
    }
    
    @Test
    public void testOrderByBDayDescSameDays() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        actualResults.add(new UserModel("pippo","esposito", dateFormat.parse("14-03-1993")));
        actualResults.add(new UserModel("francesco","rossi",dateFormat.parse("14-08-1998")));
        actualResults.add(new UserModel("mario","bianchi",dateFormat.parse("14-09-1980")));
   
        ctrlUserInfo.orderByBDayDesc(actualResults);
        
        assertEquals(dateFormat.parse("14-08-1998"),actualResults.get(0).getBirthday());
        assertEquals(dateFormat.parse("14-03-1993"),actualResults.get(1).getBirthday());
        assertEquals(dateFormat.parse("14-09-1980"),actualResults.get(2).getBirthday());
    }
    
    @Test
    public void testOrderByBDayDescSameMonths() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        actualResults.add(new UserModel("pippo","esposito", dateFormat.parse("14-03-1993")));
        actualResults.add(new UserModel("francesco","rossi",dateFormat.parse("07-03-1998")));
        actualResults.add(new UserModel("mario","bianchi", dateFormat.parse("29-03-1980")));
      
        ctrlUserInfo.orderByBDayDesc(actualResults);

        assertEquals(dateFormat.parse("07-03-1998"),actualResults.get(0).getBirthday());
        assertEquals(dateFormat.parse("14-03-1993"),actualResults.get(1).getBirthday());
        assertEquals(dateFormat.parse("29-03-1980"),actualResults.get(2).getBirthday());
    }
    
    @Test
    public void testOrderByBDayDescSameYears() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        actualResults.add(new UserModel("pippo","esposito", dateFormat.parse("14-03-1993")));
        actualResults.add(new UserModel("francesco","rossi",dateFormat.parse("07-08-1993")));
        actualResults.add(new UserModel("mario","bianchi",dateFormat.parse("29-09-1993")));
 
        ctrlUserInfo.orderByBDayDesc(actualResults);

        assertEquals(dateFormat.parse("29-09-1993"),actualResults.get(0).getBirthday());
        assertEquals(dateFormat.parse("07-08-1993"),actualResults.get(1).getBirthday());
        assertEquals(dateFormat.parse("14-03-1993"),actualResults.get(2).getBirthday());
    }
    
     @Test
    public void testOrderByBDayDescSameYearsAndSameMonths() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        actualResults.add(new UserModel("pippo","esposito",  dateFormat.parse("14-03-1993")));
        actualResults.add(new UserModel("francesco","rossi",dateFormat.parse("07-03-1993")));
        actualResults.add(new UserModel("mario","bianchi",dateFormat.parse("29-03-1993")));
      
        ctrlUserInfo.orderByBDayDesc(actualResults);
        
        assertEquals(dateFormat.parse("29-03-1993"),actualResults.get(0).getBirthday());
        assertEquals(dateFormat.parse("14-03-1993"),actualResults.get(1).getBirthday());
        assertEquals(dateFormat.parse("07-03-1993"),actualResults.get(2).getBirthday());
    }
    
     @Test
    public void testOrderByBDayDescSameYearsAndSameDays() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        actualResults.add(new UserModel("pippo","esposito", dateFormat.parse("14-03-1993")));
        actualResults.add(new UserModel("francesco","rossi",dateFormat.parse("14-08-1993")));
        actualResults.add(new UserModel("mario","bianchi",dateFormat.parse("14-09-1993")));
     
        ctrlUserInfo.orderByBDayDesc(actualResults);

        assertEquals(dateFormat.parse("14-09-1993"),actualResults.get(0).getBirthday());
        assertEquals(dateFormat.parse("14-08-1993"),actualResults.get(1).getBirthday());
        assertEquals(dateFormat.parse("14-03-1993"),actualResults.get(2).getBirthday());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testOrderByBDayDescEmptyValue() {
        
        ctrlUserInfo.orderByBDayDesc(actualResults);
    }
}
