/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.entity.Client;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarita
 */
public interface ClientDAO {
    
    int insertClient(Client client) throws SQLException,ClassNotFoundException;
    List<Client> getAll() throws SQLException,ClassNotFoundException;
    Client getById(int id) throws SQLException,ClassNotFoundException;
    int updateClient(Client client,int id) throws SQLException,ClassNotFoundException;
    int deleteClient(Client client,int id) throws SQLException,ClassNotFoundException;
    
}
