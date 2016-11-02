/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entitys;

/**
 *
 * @author jorge
 */
public class AccountLight {
    private String tel;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;
    private String email;
    private int languaje_id;
    private boolean notifyEmail;
    private boolean notityFlag;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLanguaje_id() {
        return languaje_id;
    }

    public void setLanguaje_id(int languaje_id) {
        this.languaje_id = languaje_id;
    }

    public boolean isNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(boolean notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public boolean isNotityFlag() {
        return notityFlag;
    }

    public void setNotityFlag(boolean notityFlag) {
        this.notityFlag = notityFlag;
    }
    
}
