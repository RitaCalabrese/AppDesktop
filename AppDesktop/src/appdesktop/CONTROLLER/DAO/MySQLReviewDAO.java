/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER.DAO;

import appdesktop.CONTROLLER.DataBaseController;
import appdesktop.MODEL.ReviewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class MySQLReviewDAO implements ReviewDAO{

    @Override
    public List<ReviewModel> getReviewsToApprove(String userEmail) {
            Connection conn=DataBaseController.ConnectDB();
            List<ReviewModel> result =new ArrayList<>();
        try {
            PreparedStatement pst=conn.prepareStatement("Select distinct AccommodationName, Comment from review where Approved='0' and  userEmail=?");
            pst.setString(1, userEmail);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              result.add(new ReviewModel(rs.getString(1),rs.getString(2)));
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(MySQLReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBaseController.disconnectDB();
        return result;
    }

    @Override
    public String updateReview(String acmName,String email) {
        String response = "something went wrong";
        Connection conn=DataBaseController.ConnectDB();
        try {
            PreparedStatement pst=conn.prepareStatement("update review set  approved='1' where accommodationName = ? and userEmail = ?");
            pst.setString(1, acmName);
            pst.setString(2,email);
            int count = pst.executeUpdate();
            if(count >0){
            response = "operation ends succesfully";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBaseController.disconnectDB();
       return response;
    }

    @Override
    public String deleteReview(String acmName,String email) {
    String response = "something went wrong";
        Connection conn=DataBaseController.ConnectDB();
        try {
            PreparedStatement pst=conn.prepareStatement("delete from review where accommodationName = ? and userEmail = ?");
            pst.setString(1, acmName);
            pst.setString(2,email);
            int count = pst.executeUpdate();
            if(count >0){
            response = "operation ends succesfully";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBaseController.disconnectDB();
       return response;
    }
    
}
