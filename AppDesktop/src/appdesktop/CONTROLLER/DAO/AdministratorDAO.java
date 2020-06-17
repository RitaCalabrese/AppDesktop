/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER.DAO;

import appdesktop.MODEL.AdministratorModel;
import java.util.List;

/**
 *
 * @author Rita
 */
public interface AdministratorDAO {
    
   public AdministratorModel getCredentials(String nome,String password);
}
