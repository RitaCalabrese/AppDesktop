/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;

import appdesktop.UserInfoView;
import appdesktop.CONTROLLER.DAO.MySQLUserDAO;
import appdesktop.CONTROLLER.DAO.UserDAO;
import appdesktop.EventHandler;
import appdesktop.MODEL.UserModel;
import appdesktop.MODEL.UserPhotoModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author luisa
 */
public class ControllerPhoto implements ControllerConfig {

    DefaultListModel model;
    List<UserModel> results = new ArrayList<>();
    UserInfoView view;
    EventHandler handler;
    String email;
    
    UserDAO sqlUser;
    
    @Override
    public DefaultListModel initControllerUserInfo(EventHandler handler,UserInfoView view) {
       
       this.view = view;
       this.handler = handler;
       handler.addMouseClickListener(new UserPhClickListener());
       handler.addButtonApprovedListener(new PhotoApprovedListener());
       handler.addButtonDeleteListener(new PhotoDeletedListener());
        
       model = new DefaultListModel();
       results = (ArrayList<UserModel>)getUserPh();
       if(results != null)
          refreshUsersList();
       return model;     
    }
    
      public UserPhotoModel getPhotoToApprove(String email){
      
        if(sqlUser == null){
           sqlUser = new MySQLUserDAO();
        }
        return sqlUser.getUserPhotoToApprove(email);
      }
      
    public List<UserModel> getUserPh(){
      UserDAO SQLuser = new MySQLUserDAO();
      return SQLuser.getUserPh();
      }
    
    public String approveUserPh(String email){
        if(sqlUser == null)
        sqlUser = new MySQLUserDAO();
        
      return sqlUser.updateUserPh(email);
    }
    
    public String deleteUserPh(String email){
        UserDAO SQLuser = new MySQLUserDAO();
      return SQLuser.deleteUserPh(email);
    }

    @Override
    public void refreshUsersList() {
      model.removeAllElements();
      results.stream().forEach((u) -> {
        model.addElement(u.getEmail());
    });    
    }

    @Override
    public DefaultListModel initControllerUserInfo(UserInfoView view) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return null;
    }

    @Override
    public void initController(EventHandler handler, UserInfoView view) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class PhotoDeletedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String response = deleteUserPh(email);
            if(response.equals("operation ends succesfully")){ 
               results = getUserPh();   
               model.removeAllElements();
               
               refreshUsersList();
               view.setListByFlag(model,true);
        }else{
                view.showMsgError();
            }
      }

       
        }

    private  class PhotoApprovedListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
            String response = approveUserPh(email);
            if(response.equals("operation ends successfully")){ 
               results = getUserPh();   
               model.removeAllElements();
               
               refreshUsersList();
               view.setListByFlag(model,true);
        }else{
                view.showMsgError();
            }
      }
        
    }

     public void setDAO(UserDAO sqlUser){
        this.sqlUser = sqlUser;
        }
    
    private  class UserPhClickListener implements MouseListener {

       
        @Override
        public void mouseClicked(MouseEvent e) {
            email = view.getSelectedUser();
            UserPhotoModel photo = getPhotoToApprove(email);
            view.setObjBySelectedValue(photo);
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
}