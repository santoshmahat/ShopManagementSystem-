/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.impl;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao.ClientDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.entity.Client;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sarita
 */
@Repository(value = "clientDAO")
public class ClientDAOImpl implements ClientDAO{
@Autowired
JdbcTemplate jdbcTemplate;

   

    @Override
    public List<Client> getAll() throws SQLException, ClassNotFoundException {
        String sql="SELECT c.*,i.price,i.name,i.added_date as 'item_added' FROM tbl_clients c JOIN tbl_items i on c.item_id=i.item_id";
        return jdbcTemplate.query(sql, new RowMapper<Client>() {

            @Override
            public Client mapRow(ResultSet rs, int i) throws SQLException {
              Client client=new Client();
              client.setId(rs.getInt("client_id"));
              client.setFirstName(rs.getString("first_name"));
              client.setLastName(rs.getString("last_name"));
              client.setEmail(rs.getString("email"));
              client.setContactNo(rs.getInt("contact_no"));
              client.setAddress(rs.getString("address"));
              client.setMessage(rs.getString("message"));
              client.setAddDate(rs.getTimestamp("added_date"));
              client.setStatus(rs.getBoolean("status"));
              Item item=new Item();
              item.setName(rs.getString("name"));
              item.setPrice(rs.getInt("price"));
              item.setAddedDate(rs.getTimestamp("item_added"));
              client.setItem(item);
              return  client;
              
            }
        });
    }

    @Override
    public int insertClient(Client client) throws SQLException, ClassNotFoundException {
       String sql="INSERT INTO tbl_clients(item_id,first_name,last_name,email,contact_no,address,message,status)VALUES(?,?,?,?,?,?,?,?)";
       return jdbcTemplate.update(sql, new Object[] {client.getItem().getId(),client.getFirstName(),client.getLastName(),client.getEmail(),client.getContactNo(),client.getAddress(),client.getMessage(),client.isStatus()});
    }

    @Override
    public Client getById(int id) throws SQLException, ClassNotFoundException {
        String string="SELECT c.*,i.price,i.name,i.added_date as 'item_added' FROM tbl_clients c JOIN tbl_items i on c.item_id=i.item_id where client_id=?";
        return jdbcTemplate.queryForObject(string, new Object[]{id}, new RowMapper<Client>() {

            @Override
            public Client mapRow(ResultSet rs, int i) throws SQLException {
                Client client=new Client();
                 client.setId(rs.getInt("client_id"));
              client.setFirstName(rs.getString("first_name"));
              client.setLastName(rs.getString("last_name"));
              client.setEmail(rs.getString("email"));
              client.setContactNo(rs.getInt("contact_no"));
              client.setAddress(rs.getString("address"));
              client.setMessage(rs.getString("message"));
              client.setStatus(rs.getBoolean("status"));
              client.setAddDate(rs.getTimestamp("added_date"));
              Item item=new Item();
              item.setName(rs.getString("name"));
              item.setPrice(rs.getInt("price"));
              item.setAddedDate(rs.getTimestamp("item_added"));
              client.setItem(item);
              return  client;
                
            }
        });
    
}

    @Override
    public int updateClient(Client client,int id) throws SQLException, ClassNotFoundException {
        String sql="UPDATE tbl_clients set item_id=?,first_name=?,last_name=?,email=?,contact_no=?,address=?,message=?,status=? WHERE client_id=?";
        return jdbcTemplate.update(sql, new Object[]{client.getItem().getId(),client.getFirstName(),client.getLastName(),client.getEmail(),client.getContactNo(),client.getAddress(),client.getMessage(),client.isStatus(),id});
    }

    @Override
    public int deleteClient(Client client, int id) throws SQLException, ClassNotFoundException {
        String sql="Delete FROM tbl_clients WHERE client_id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }
    
    
    
}