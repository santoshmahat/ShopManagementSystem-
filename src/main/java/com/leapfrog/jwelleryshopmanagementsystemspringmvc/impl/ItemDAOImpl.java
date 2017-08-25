/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.impl;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao.ItemDAO;
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
@Repository(value = "itemDAO")
public class ItemDAOImpl implements ItemDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Item item) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO tbl_items(name,price)VALUES(?,?)";
        return jdbcTemplate.update(sql, new Object[]{item.getName(),item.getPrice()});
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
       String string = "SELECT * FROM tbl_items";
       return jdbcTemplate.query(string, new RowMapper<Item>() {

           @Override
           public Item mapRow(ResultSet rs, int i) throws SQLException {
               Item item=new Item();
               item.setId(rs.getInt("item_id"));
               item.setName(rs.getString("name"));
               item.setPrice(rs.getInt("price"));
               item.setAddedDate(rs.getDate("added_date"));
               return item;
           }
       });
    }

    @Override
    public int update(Item item, int id) throws SQLException, ClassNotFoundException {
        String sql="UPDATE tbl_items set name=?,price=? WHERE item_id=?";
        return jdbcTemplate.update(sql, new Object[]{item.getName(),item.getPrice(),id});
    }

    @Override
    public int delete(Item item, int id) throws SQLException, ClassNotFoundException {
       String sql="DELETE FROM tbl_items WHERE item_id=?";
       return jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public Item getById(int id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM tbl_items WHERE item_id=?";
        return  jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Item>() {

            @Override
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                Item item=new Item();
                item.setId(rs.getInt("item_id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getInt("price"));
                return item;
            }
        });
    }
    
   
    
}
