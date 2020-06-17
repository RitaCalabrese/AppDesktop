/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER;

import appdesktop.UserInfoView;
import appdesktop.EventHandler;
import javax.swing.DefaultListModel;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public interface ControllerConfig {
    
    public DefaultListModel initControllerUserInfo(EventHandler handler,UserInfoView view);
    public void initController(EventHandler handler,UserInfoView view);
    public DefaultListModel initControllerUserInfo(UserInfoView view);
    public void refreshUsersList();
}
