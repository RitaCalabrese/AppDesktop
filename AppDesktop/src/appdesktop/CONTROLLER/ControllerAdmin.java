/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;

import appdesktop.CONTROLLER.DAO.AdministratorDAO;
import appdesktop.CONTROLLER.DAO.MySQLAdministratorDAO;
import appdesktop.LoginView;
import appdesktop.MODEL.AdministratorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class ControllerAdmin {
    
    LoginView view;
    AdministratorDAO sqlAdmin;
    
    public void initController(LoginView view){
        this.view = view;
        view.addBtnLoginListener((EventListener) new ButtonLoginListener());
        view.addKeyPressedListener(new KeyPressedListener());
    }
     private class KeyPressedListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent evt) {
            if(view != null){
               String[] credentials = view.getAdminInput();
               AdministratorModel admin = getCredentials(credentials[0], credentials[1]);
               if(credentials[0].equals("")){
                  JOptionPane.showMessageDialog(null," Inserisci nome ");
               }else
                 if(evt.getKeyCode()==com.sun.glass.events.KeyEvent.VK_ENTER){
                    view.signInAdmin(admin);
               }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
   
  
    private class ButtonLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             if(view != null){
                String[] credentials = view.getAdminInput();
                AdministratorModel admin = getCredentials(credentials[0], credentials[1]);
                if(credentials[0].equals("")){
                   JOptionPane.showMessageDialog(null," Inserisci nome ");
             }else{
                view.signInAdmin(admin);
             }
        }
    }
   }
    public void setDAO(AdministratorDAO sqlAdmin){
        this.sqlAdmin = sqlAdmin;
    }
    
    public AdministratorModel getCredentials(String nome,String pass){
        
        if(sqlAdmin == null){
           sqlAdmin= new MySQLAdministratorDAO();
        }
         return sqlAdmin.getCredentials(nome, pass);
    }
}
