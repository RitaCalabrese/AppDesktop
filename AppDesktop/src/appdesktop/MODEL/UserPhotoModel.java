/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.MODEL;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class UserPhotoModel {
    byte[]fileImage;
   

    public UserPhotoModel(byte[] fileImage) {
        this.fileImage = fileImage;
        
    }

    public byte[] getFileImage() {
        return fileImage;
    }

    public void setFileImage(byte[] fileImage) {
        this.fileImage = fileImage;
    }

   
    
    
}
