/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import appdesktop.CONTROLLER.ControllerAdmin;
import appdesktop.MODEL.AdministratorModel;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView login = new LoginView();
        login.setVisible(true);
    }
}
