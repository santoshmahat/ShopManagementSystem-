/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity;

import java.util.Date;

/**
 *
 * @author sarita
 */
public class EnrolledUser {
   private int enrolledUserId;
   private String firstName;
   private String lastName;
   private String email;
   private int contactNO;
   private boolean payment;
   public boolean status;
   private Date addedDate;
   private Bookmarker bookmarker;

    public EnrolledUser() {
    }

   

   
  

    public int getEnrolledUserId() {
        return enrolledUserId;
    }

    public void setEnrolledUserId(int enrolledUserId) {
        this.enrolledUserId = enrolledUserId;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    
    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Bookmarker getBookmarker() {
        return bookmarker;
    }

    public void setBookmarker(Bookmarker bookmarker) {
        this.bookmarker = bookmarker;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNO() {
        return contactNO;
    }

    public void setContactNO(int contactNO) {
        this.contactNO = contactNO;
    }

   
   
    
   
    
    
   
}
