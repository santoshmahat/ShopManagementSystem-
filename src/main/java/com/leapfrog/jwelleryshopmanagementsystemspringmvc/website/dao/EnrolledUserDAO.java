/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.EnrolledUser;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarita
 */
public interface EnrolledUserDAO {
    
    public int insert(EnrolledUser enrolledUser) throws SQLException,ClassNotFoundException;
    public List<EnrolledUser> getAll() throws SQLException,ClassNotFoundException;
    public EnrolledUser getById(int id) throws SQLException,ClassNotFoundException;
    public int countRow() throws ClassNotFoundException,SQLException;
}
