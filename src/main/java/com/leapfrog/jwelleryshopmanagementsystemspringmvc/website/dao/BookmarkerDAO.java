/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.Bookmarker;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarita
 */
public interface BookmarkerDAO {
    
    public int insert(Bookmarker bookmarker) throws ClassNotFoundException,SQLException;
    public List<Bookmarker> getAll() throws ClassNotFoundException,SQLException;
    public int countRow() throws ClassNotFoundException,SQLException;
    public Bookmarker getById(int id) throws ClassNotFoundException,SQLException;
}
