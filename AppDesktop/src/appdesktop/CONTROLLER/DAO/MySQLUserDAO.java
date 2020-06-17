/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER.DAO;

import appdesktop.CONTROLLER.DataBaseController;
import appdesktop.UsersView;
import appdesktop.MODEL.UserModel;
import appdesktop.MODEL.UserPhotoModel;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rita
 */
public class MySQLUserDAO implements UserDAO {

    byte[] imageBytes;
    
    @Override
    public List<UserModel> getUsersByEmail(String email) {
        List<UserModel> results= new ArrayList<>();
        Connection conn = DataBaseController.ConnectDB();
         try {
              
             String sql = "select Name,Surname,Birthday,Nickname,Email,FileImage,PhotoApproved,AmountWrittenReviews,AVGUserRating from User where Email = ?";
             PreparedStatement pst=conn.prepareStatement(sql);
             pst.setString(1, email);
             ResultSet rs= pst.executeQuery(sql);
             Blob imageBlob  = rs.getBlob("Image");
              if(imageBlob != null){
                 imageBytes = imageBlob.getBytes(1,(int)imageBlob.length());
             
                 results.add(new UserModel(rs.getString("Name"),rs.getString("Surname"),new Date(rs.getDate("Birthday").getTime()),rs.getString("NickName"),rs.getString("Email"),imageBytes,rs.getBoolean("PhotoApproved"),rs.getInt("AmountWrittenReviews"),rs.getFloat("AVGUserRating")));
                 }else{
                            results.add(new UserModel(rs.getString("Name"),rs.getString("Surname"),new Date(rs.getDate("Birthday").getTime()),rs.getString("NickName"),rs.getString("Email"),rs.getInt("AmountWrittenReviews"),rs.getFloat("AVGUserRating")));

                 }   
               
             } catch (SQLException ex) {
                Logger.getLogger(UsersView.class.getName()).log(Level.SEVERE, null, ex);
            }
         DataBaseController.disconnectDB();
         return results;
    }

    @Override
    public List<UserModel> getAllUsers() {
      List<UserModel> results= new ArrayList<>();
        Connection conn = DataBaseController.ConnectDB();
         try {
              
             String sql = "select Name,Surname,Birthday,Nickname,Email,FileImage,PhotoApproved,AmountWrittenReviews,AVGUserRating from User";
             PreparedStatement pst=conn.prepareStatement(sql);
             ResultSet rs= pst.executeQuery(sql);
             
             while(rs.next()){
                 Blob imageBlob  = rs.getBlob("FileImage");
                 if(imageBlob != null){
                 imageBytes = imageBlob.getBytes(1,(int)imageBlob.length());
             
                 results.add(new UserModel(rs.getString("Name"),rs.getString("Surname"),new Date(rs.getDate("Birthday").getTime()),rs.getString("NickName"),rs.getString("Email"),imageBytes,rs.getBoolean("PhotoApproved"),rs.getInt("AmountWrittenReviews"),rs.getFloat("AVGUserRating")));
                 }else{
                            results.add(new UserModel(rs.getString("Name"),rs.getString("Surname"),new Date(rs.getDate("Birthday").getTime()),rs.getString("NickName"),rs.getString("Email"),rs.getInt("AmountWrittenReviews"),rs.getFloat("AVGUserRating")));

                 }   
               }
             } catch (SQLException ex) {
                Logger.getLogger(UsersView.class.getName()).log(Level.SEVERE, null, ex);
             }
         DataBaseController.disconnectDB();
         return results;
    }

    @Override
    public List<String> getFavoriteDestinationsByName(String destination) {
         Connection conn = DataBaseController.ConnectDB();
        
         List<String> results = new ArrayList<>();
         try {
              
      
             PreparedStatement pst=conn.prepareStatement("select distinct fa.UserEmail from favouriteaccommodation as fa join accommodation as a on fa.accommodationName = a.Name where a.City = ?");
             pst.setString(1,destination);
             ResultSet rs= pst.executeQuery();
             
             while(rs.next()){
                 results.add(rs.getString(1));
               }
             } catch (SQLException ex) {
                Logger.getLogger(UsersView.class.getName()).log(Level.SEVERE, null, ex);
             }
         DataBaseController.disconnectDB();
         return results;
    }

    @Override
    public List<UserModel> getUserWithReviewsToApprove() {
  Connection conn = DataBaseController.ConnectDB();
        List<UserModel> results= new ArrayList<>();
        try {
              
      
             PreparedStatement pst=conn.prepareStatement("select distinct  u.name, u.surname, u.email from user as u  join review as r on u.email = r.userEmail where r.Approved='0'");
            
             ResultSet rs= pst.executeQuery();
             
             while(rs.next()){
                 results.add(new UserModel(rs.getString(1), rs.getString(2), rs.getString(3)));
               }
             } catch (SQLException ex) {
                Logger.getLogger(UsersView.class.getName()).log(Level.SEVERE, null, ex);
             }
         DataBaseController.disconnectDB();
         return results;
        
    }

    @Override
    public UserPhotoModel getUserPhotoToApprove(String email) {
        UserPhotoModel result = null;
        Connection conn = DataBaseController.ConnectDB();
        try {
              
      
            PreparedStatement pst=conn.prepareStatement("select u.fileImage from user as u where email = ?");
            pst.setString(1, email);
             ResultSet rs= pst.executeQuery();
             
             while(rs.next()){
                 Blob imageBlob = rs.getBlob(1);
                 byte[] imageBytes = imageBlob.getBytes(1,(int) imageBlob.length());
                 result = new UserPhotoModel(imageBytes);
               }
             } catch (SQLException ex) {
                Logger.getLogger(UsersView.class.getName()).log(Level.SEVERE, null, ex);
             }
        DataBaseController.disconnectDB();
         return result;    }

    @Override
    public List<UserModel> getUserPh() {
   List<UserModel> results= new ArrayList<>();
        Connection conn = DataBaseController.ConnectDB();
        try {
              
      
             PreparedStatement pst=conn.prepareStatement("select email from user where PhotoApproved='0' and FileImage IS NOT NULL");
            
             ResultSet rs= pst.executeQuery();
             
             while(rs.next()){
                 
                 results.add(new UserModel(rs.getString(1)));
               }
             } catch (SQLException ex) {
                Logger.getLogger(UsersView.class.getName()).log(Level.SEVERE, null, ex);
             }
        DataBaseController.disconnectDB();
         return results;       }

    @Override
    public String updateUserPh(String email) {
        String response = "something went wrong";
        Connection conn=DataBaseController.ConnectDB();
        try {
            PreparedStatement pst=conn.prepareStatement("update user set  PhotoApproved='1' where email = ?");
            pst.setString(1,email);
            int count = pst.executeUpdate();
            if(count >0){
            response = "operation ends succesfully";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBaseController.disconnectDB();
       return response;    }

    @Override
    public String deleteUserPh(String email) {
        String response = "something went wrong";
        Connection conn=DataBaseController.ConnectDB();
        try {
            PreparedStatement pst=conn.prepareStatement("update user set FileImage = NULL and PhotoApproved = 0 where email = ?");
            pst.setString(1,email);
            int count = pst.executeUpdate();
            if(count >0){
            response = "operation ends succesfully";
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBaseController.disconnectDB();
       return response;    }

}