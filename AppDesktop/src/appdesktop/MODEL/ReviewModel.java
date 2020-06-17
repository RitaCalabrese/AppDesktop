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
public class ReviewModel {
    
    String accommodation;
    String comment;

    public ReviewModel(String accommodation, String comment) {
       this.accommodation= accommodation;
        this.comment = comment;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }
    

   

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
