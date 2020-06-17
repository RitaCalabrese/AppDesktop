/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;

import appdesktop.UserInfoView;
import appdesktop.CONTROLLER.DAO.MySQLReviewDAO;
import appdesktop.CONTROLLER.DAO.MySQLUserDAO;
import appdesktop.CONTROLLER.DAO.ReviewDAO;
import appdesktop.CONTROLLER.DAO.UserDAO;
import appdesktop.EventHandler;
import appdesktop.MODEL.ReviewModel;
import appdesktop.MODEL.UserModel;
import appdesktop.ReviewsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class ControllerReview implements ControllerConfig{
    
    List<ReviewModel> result = new ArrayList<>();
    List<UserModel> users = new ArrayList<>();
    String email;
    String acm;
    DefaultListModel modelAcm = new DefaultListModel();
    UserInfoView view;
    
    ReviewDAO revSql;
    
    @Override
    public void initController(EventHandler handler,UserInfoView view){
        this.view = view;
        handler.addMouseClickListener(new ListUserRevListener());
        handler.addAnotherMouseClickListener(new ListAcmListener());
        handler.addButtonApprovedListener(new ApprovedListener());
        handler.addButtonDeleteListener(new DeleteListener());
    }
    
    public List<ReviewModel> getRevbyUser(String email){
        if(revSql == null)
           revSql = new MySQLReviewDAO();
        
       return revSql.getReviewsToApprove(email);
        
    }
    
    public String updateRev(String acmName,String email){
        ReviewDAO revSQL = new MySQLReviewDAO();
        return revSQL.updateReview(acmName,email);
        
    }
    
    public String deleteRev(String acmName,String email){
        ReviewDAO revSQL = new MySQLReviewDAO();
            return revSQL.deleteReview(acmName,email);

    }

    private void refreshListRev(DefaultListModel model){
        if(result != null){
            model.removeAllElements();
            for(ReviewModel r:result){
                model.addElement(r.getAccommodation());
            }
        }
    }

    
    @Override
    public DefaultListModel initControllerUserInfo(UserInfoView view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refreshUsersList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel initControllerUserInfo(EventHandler handler, UserInfoView view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public void setDAO(ReviewDAO revSql){
        this.revSql = revSql;
    }
    
    private  class ListAcmListener implements MouseListener {

        
        @Override
        public void mouseClicked(MouseEvent e) {
            acm = view.getSelectedValue();
            if(result!=null){
            for(ReviewModel r:result){
               if(r.getAccommodation().equals(acm)){
                   view.setObjBySelectedValue(r.getComment());
               }
            }
           }
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
    
    private  class ListUserRevListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JTextArea commentText = view.getJTextArea();
            commentText.setText("");
            email = view.getSelectedUser();
            
            result = getRevbyUser(email);
           
            refreshListRev(modelAcm);
            view.setListByFlag(modelAcm,false);
            
            
        }
        

        @Override
        public void mousePressed(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


    private class ApprovedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String response = updateRev(acm,email);
           JTextArea commentText = view.getJTextArea();
           
           if(response.equals("operation ends succesfully")){ 
               result = getRevbyUser(email);   
               modelAcm.removeAllElements();
               commentText.setText("");
               refreshListRev(modelAcm);
               view.setListByFlag(modelAcm,true);
           }else{
               view.showMsgError();
           }
        
    }
 }
    
    private class DeleteListener implements ActionListener {

        
        @Override
        public void actionPerformed(ActionEvent e) {
            String response = deleteRev(acm,email);
           JTextArea commentText = view.getJTextArea();
           
           if(response.equals("operation ends succesfully")){ 
               result = getRevbyUser(email);   
               modelAcm.removeAllElements();
               commentText.setText("");
               refreshListRev(modelAcm);
               view.setListByFlag(modelAcm,true);
           }
        }
    }
}

