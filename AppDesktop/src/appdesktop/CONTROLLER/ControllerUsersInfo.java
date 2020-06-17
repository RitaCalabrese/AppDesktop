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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.IndexOutOfBoundsException;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 *
 * @author Rita
 */
public class ControllerUsersInfo implements ControllerConfig {
    
    UserInfoView view;
    DefaultListModel model;
    List<UserModel> results = new ArrayList<>();
    List<UserModel> resultsDes = new ArrayList<>();
    
   
    @Override
    public DefaultListModel initControllerUserInfo(EventHandler handler,UserInfoView view){
      this.view = view;
      handler.addActionOneListener(new DestinationListener());
      handler.addMouseClickListener(new ListUsersListener());
      handler.addRefreshListener(new RefreshListener());
      handler.addAnotherMouseClickListener(new FilteredListener());
      handler.addAscendingOrderListener(new AscendingOrderListener());
      handler.addCheckOrderListener(new OrderRevCheckListener());
      handler.addCheckOrderTwoListener(new OrderRatingCheckListener());
      handler.addCheckOrderThreeListener(new OrderBDayCheckListener());
      handler.addDescendingOrderListener(new DescendingOrderListener());
      
      model = new DefaultListModel();
      results = (ArrayList<UserModel>)getUsers();
      if(results != null)
          refreshUsersList();
      return model;
    }
   
    
    @Override
    public DefaultListModel initControllerUserInfo(UserInfoView view) {
      model = new DefaultListModel();
      results = (ArrayList<UserModel>)getUserRev();
      if(results != null)
          refreshUsersList();
      return model;    
    }
 
 
   
    @Override
    public void refreshUsersList(){
    model.removeAllElements();
    results.stream().forEach((u) -> {
      model.addElement(u.getEmail());
    });
    }
    
    
    
    public List<UserModel> getUsers(){
        UserDAO SQLuser = new MySQLUserDAO();
        return (ArrayList<UserModel>) SQLuser.getAllUsers();
    }
    
    public List<UserModel> getUsersByEmail(String email){
            UserDAO SQLuser = new MySQLUserDAO();
            return (ArrayList<UserModel>) SQLuser.getUsersByEmail(email);
    }
    
    public List<String> getDestinations(String dest){
     UserDAO SQLuser = new MySQLUserDAO();
     return SQLuser.getFavoriteDestinationsByName(dest);
     }
      
    public List<UserModel> getUserRev(){
        UserDAO SQLuser = new MySQLUserDAO();
       return SQLuser.getUserWithReviewsToApprove();
        
    }

    @Override
    public void initController(EventHandler handler, UserInfoView view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
  
    public void orderByReviewsDesc(List<UserModel> results) throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
        Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return -1*(t.getAmountWrittenReviews().compareTo(t1.getAmountWrittenReviews()));
              }
             
          });
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public void orderByRatingDesc(List<UserModel> results) throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
       Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return -1*(t.getAverageUserRating().compareTo(t1.getAverageUserRating()));
              }
             
          }); 
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void orderByBDayDesc(List<UserModel> results) throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
         Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return -1*(t.getBirthday().compareTo(t1.getBirthday()));
              }
             
          });
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public void orderByNameDesc(List<UserModel> results)throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
        Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return -1*(t.getName().compareTo(t1.getName()));
              }
             
          });
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void orderByReviewsAsc(List<UserModel> results)throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
        Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return t.getAmountWrittenReviews().compareTo(t1.getAmountWrittenReviews());
              }
              
             
          });
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void orderByRatingAsc(List<UserModel> results)throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
        Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return t.getAverageUserRating().compareTo(t1.getAverageUserRating());
              }
             
          });
         }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void orderByBDayAsc(List<UserModel> results)throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
        Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return t.getBirthday().compareTo(t1.getBirthday());
              }
             
          });
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void orderByNameAsc(List<UserModel> results)throws IndexOutOfBoundsException{
        if(!results.isEmpty()){
        Collections.sort(results, new Comparator<UserModel>(){
              @Override
              public int compare(UserModel t, UserModel t1) {
                  return t.getName().compareTo(t1.getName());
              }
             
          });
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    private class DescendingOrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox orderRev = view.getCheckBox1();        
            JCheckBox orderRating = view.getCheckBox2();
            JCheckBox orderBDay = view.getCheckBox3();         
        
            if ( orderRev.isSelected()){
             if(results != null){
                orderByReviewsDesc(results);
                refreshUsersList();
                view.setListByFlag(model,true);
           }
         }else if ( orderRating.isSelected()){
          if(results != null){
            orderByRatingDesc(results);
            refreshUsersList();
            view.setListByFlag(model,true);
        }

      }else if ( orderBDay.isSelected()){
         if(results != null){
           orderByBDayDesc(results);
           refreshUsersList();
           view.setListByFlag(model,true);
         }   
      }  else  {        
           if(results != null){
           orderByNameDesc(results);
           refreshUsersList();
           view.setListByFlag(model,true);
           }
      }
    }
    }

    private  class OrderRevCheckListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox orderRev = view.getCheckBox1();        
            JCheckBox orderRating = view.getCheckBox2();
            JCheckBox orderBDay = view.getCheckBox3(); 
            if(orderRev.isSelected()){
                    orderRating.setSelected(false);
                    orderBDay.setSelected(false);
                    
            if(results != null){
              orderByReviewsDesc(results);
              refreshUsersList();        
              view.setListByFlag(model,true);
            }
            }
        }
    }

    private class OrderRatingCheckListener implements ActionListener {

       
        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox orderRev = view.getCheckBox1();        
            JCheckBox orderRating = view.getCheckBox2();
            JCheckBox orderBDay = view.getCheckBox3();        
            if(orderRating.isSelected()){
               orderRev.setSelected(false);
               orderBDay.setSelected(false);
     
            if(results != null){
              orderByRatingDesc(results);
          
              refreshUsersList();
              view.setListByFlag(model,true);
          }
       }
    }
  }
    
    private class OrderBDayCheckListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox orderRev = view.getCheckBox1();        
            JCheckBox orderRating = view.getCheckBox2();
            JCheckBox orderBDay = view.getCheckBox3();        
             if(orderBDay.isSelected()){
                    orderRating.setSelected(false);
                    orderRev.setSelected(false);
                    
               if(results != null){
                  orderByBDayDesc(results);
                  refreshUsersList();
                  view.setListByFlag(model,true);
         }
      }
   }
    }

    private class AscendingOrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox orderRev = view.getCheckBox1();        
            JCheckBox orderRating = view.getCheckBox2();
            JCheckBox orderBDay = view.getCheckBox3();
          
            if(orderRev.isSelected()){
               if(results != null){
                 orderByReviewsAsc(results);
                 refreshUsersList();
                 view.setListByFlag(model,true);
               }
            }else if( orderRating.isSelected()){
              if(results != null){
                 orderByRatingAsc(results);
                 refreshUsersList();
                 view.setListByFlag(model,true);
             }
           }else if ( orderBDay.isSelected()){
           if(results != null){
             orderByBDayAsc(results);
             refreshUsersList();
             view.setListByFlag(model,true);
           }
          }else{
             if(results != null){
              orderByNameAsc(results);
              refreshUsersList();
              view.setListByFlag(model,true);
         }
        }
       }
     }
    
    private class FilteredListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
        JList<String> jListFiltered = view.getjList();
         if(!jListFiltered.isSelectionEmpty()){
            String email =  jListFiltered.getSelectedValue();
            if(resultsDes !=null){
             for(UserModel u:resultsDes){
                 if(u.getEmail().equals(email)){
                     view.setSelectedUser(u);
                 }
             }
           }
         }
        }
         

        @Override
        public void mousePressed(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class RefreshListener implements ActionListener {

       

        @Override
        public void actionPerformed(ActionEvent e) {
            results = (ArrayList<UserModel>)getUsers();
             if(results != null){
             refreshUsersList();  
             view.setRefresh(model);
            }
        }
    }

    private class ListUsersListener implements MouseListener {

       
        @Override
        public void mouseClicked(MouseEvent e) {
         String email = view.getSelectedUser();
         if(results != null){
            for(UserModel u:results){
            if(u.getEmail().equals(email)){
               view.setSelectedUser(u);
            }
            }
         }
        }

        @Override
        public void mousePressed(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class DestinationListener implements ActionListener {

        
        @Override
        public void actionPerformed(ActionEvent e) {
        JPopupMenu jpopupMenu1 = view.getjPopupMenu();
        JPanel jPanel5 = view.getJPanel();
        JTextField InsertDestination = view.getJTextField();
        jpopupMenu1.show(InsertDestination, 0 , InsertDestination.getHeight());
        jPanel5.setVisible(false);
        DefaultListModel model = new DefaultListModel();
            
              String destination = InsertDestination.getText().trim();
              
              if(!destination.equals("")){
                   jPanel5.setVisible(true);
                   ArrayList<String> res = (ArrayList)getDestinations(destination);
                   jPanel5.setVisible(false);
                   if(results != null && res!=null){
                   for(String s:res){
                   for(UserModel u:results){
                     if(s.equals(u.getEmail())){
                       resultsDes.add(u);
                       model.removeAllElements();
                       model.addElement(u.getEmail());
                     }
                   }
                   }
                   view.setList(model);
               }
               }else{
                  if(destination.equals("")){
                          jpopupMenu1.setVisible(false);
                          
                }
              }
               
                 
              
        }
    }
}