/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.CONTROLLER.DAO;

import appdesktop.MODEL.UserModel;
import appdesktop.MODEL.UserPhotoModel;
import java.util.List;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public interface UserDAO {
    
    /**
     *
     * @param email
     * @return
     */
    public List<UserModel> getUsersByEmail(String email);
    public List<UserModel> getAllUsers();
    public List<String> getFavoriteDestinationsByName(String destination);
    public List<UserModel> getUserWithReviewsToApprove();
    public UserPhotoModel getUserPhotoToApprove(String email);
    public List<UserModel> getUserPh();
    public String updateUserPh(String email);
    public String deleteUserPh(String email);
}
