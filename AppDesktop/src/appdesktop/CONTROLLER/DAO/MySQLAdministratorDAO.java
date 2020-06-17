/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER.DAO;

import appdesktop.CONTROLLER.DataBaseController;
import appdesktop.LoginView;
import appdesktop.MODEL.AdministratorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rita
 */
public class MySQLAdministratorDAO implements AdministratorDAO {

    @Override
    public AdministratorModel getCredentials(String nome, String password) {
     Connection conn = DataBaseController.ConnectDB();
        AdministratorModel admin = null;
        try{
           
           PreparedStatement pst =conn.prepareStatement("select* from administrator where username =? and password=? ");
           pst.setString(1, nome);
           pst.setString(2, password);
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
           admin = new AdministratorModel(rs.getString("username"),rs.getString("cognome"),new Date(rs.getDate("data_di_nascita").getTime()));
           }
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBaseController.disconnectDB();
        return admin;
        
    }
}
