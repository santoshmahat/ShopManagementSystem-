/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.entity.Item;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarita
 */
public interface ItemDAO {
    int insert(Item item) throws SQLException,ClassNotFoundException;
    int update (Item item,int id) throws SQLException,ClassNotFoundException;
    int delete (Item item,int id) throws SQLException,ClassNotFoundException;
    List<Item> getAll() throws SQLException,ClassNotFoundException;
    Item getById(int id) throws SQLException,ClassNotFoundException;
}
