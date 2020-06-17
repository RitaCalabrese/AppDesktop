
package appdesktop.CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBaseController {
    
     static Connection conn = null;
        
    public static Connection ConnectDB(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_giramondo", "admin","ninfadora97");
            /*JOptionPane.showMessageDialog(null,"Connected");*/
            return conn;
        }catch(ClassNotFoundException | SQLException e){
             JOptionPane.showMessageDialog(null,"Not Connected");
             return null;
        }
    
    }
        public static void disconnectDB(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e + "\nErrore disconnessione DB");
        }
    }
}





