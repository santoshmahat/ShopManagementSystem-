/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.impl;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.BookmarkerDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.Bookmarker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sarita
 */
@Repository(value ="bookmarkerDAO")
public class BookmarkerDAOImpl implements BookmarkerDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Bookmarker bookmarker) throws ClassNotFoundException, SQLException {
        
        String sql="INSERT INTO tbl_bookmarkers(first_name,last_name,email,contact_no,message) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{bookmarker.getFirstName(),bookmarker.getLastName(),bookmarker.getEmail(),bookmarker.getContactNO(),bookmarker.getMessage()});
        
    }

    @Override
    public List<Bookmarker> getAll() throws ClassNotFoundException, SQLException {
      String sql="SELECT * FROM tbl_bookmarkers"; 
      return jdbcTemplate.query(sql, new RowMapper<Bookmarker>() {

          @Override
          public Bookmarker mapRow(ResultSet rs, int i) throws SQLException {
              
              Bookmarker b=new Bookmarker();
              b.setId(rs.getInt("bookmarker_id"));
              b.setFirstName(rs.getString("first_name"));
              b.setLastName(rs.getString("last_name"));
              b.setEmail(rs.getString("email"));
              b.setContactNO(rs.getInt("contact_no"));
              b.setMessage(rs.getString("message"));
              b.setAddedDate(rs.getTimestamp("added_date"));
              return b;
              
          }
          
      });
    }

    @Override
    public int countRow() throws ClassNotFoundException, SQLException {
        String sql="SELECT COUNT(*) FROM tbl_bookmarkers";
        return jdbcTemplate.queryForObject(sql, null, Integer.class);
    }

    @Override
    public Bookmarker getById(int id) throws ClassNotFoundException, SQLException {
         String sql="SELECT * FROM tbl_bookmarkers where bookmarker_id=? "; 
      return jdbcTemplate.queryForObject(sql,new Object[]{id},new RowMapper<Bookmarker>() {

          @Override
          public Bookmarker mapRow(ResultSet rs, int i) throws SQLException {
              
              
              Bookmarker b=new Bookmarker();
              b.setFirstName(rs.getString("first_name"));
              b.setLastName(rs.getString("last_name"));
              b.setEmail(rs.getString("email"));
              b.setContactNO(rs.getInt("contact_no"));
              b.setMessage(rs.getString("message"));
              b.setAddedDate(rs.getTimestamp("added_date"));
              return b;
    }
      });
              }
}

