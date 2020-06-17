/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop.MODEL;

import java.util.Date;



/**
 *
 * @author Rita
 */
public class UserModel {

    String name;
    String surname;
    Date birthday;
    String nickname;
    String email;
    byte[] image;
    boolean photoApproved;
    Integer amountWrittenReviews;
    Float averageUserRating;
    String[] favoriteDestinations; 

    public UserModel(String email) {
        this.email = email;
    }
    
    
    public UserModel(String name, String surname, Date birthday, String nickname, String email, byte[] image, boolean photoApproved, Integer amountWrittenReviews, Float averageUserRating) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.nickname = nickname;
        this.email = email;
        this.image = image;
        this.photoApproved = photoApproved;
        this.amountWrittenReviews = amountWrittenReviews;
        this.averageUserRating = averageUserRating;
    }

    public UserModel(String name, String surname, Date birthday, String nickname, String email, Integer amountWrittenReviews, Float averageUserRating) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.nickname = nickname;
        this.email = email;
        this.amountWrittenReviews = amountWrittenReviews;
        this.averageUserRating = averageUserRating;
    }

    public UserModel(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public UserModel(String name,String surname,Integer amountWrittenReviews){
        this.name = name;
        this.surname = surname;
        this.amountWrittenReviews = amountWrittenReviews;
    }

    public UserModel(String name, String surname, Float averageUserRating) {
        this.name = name;
        this.surname = surname;
        this.averageUserRating = averageUserRating;
    }

    public UserModel(String name, String surname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isPhotoApproved() {
        return photoApproved;
    }

    public void setPhotoApproved(boolean photoApproved) {
        this.photoApproved = photoApproved;
    }

    public Integer getAmountWrittenReviews() {
        return amountWrittenReviews;
    }

    public String[] getFavoriteDestinations() {
        return favoriteDestinations;
    }

    public void setFavoriteDestinations(String[] favoriteDestinations) {
        this.favoriteDestinations = favoriteDestinations;
    }

    public void setAmountWrittenReviews(Integer amountWrittenReviews) {
        this.amountWrittenReviews = amountWrittenReviews;
    }

    public Float getAverageUserRating() {
        return averageUserRating;
    }

    public void setAverageUserRating(Float averageUserRating) {
        this.averageUserRating = averageUserRating;
    }
    
    
            }
