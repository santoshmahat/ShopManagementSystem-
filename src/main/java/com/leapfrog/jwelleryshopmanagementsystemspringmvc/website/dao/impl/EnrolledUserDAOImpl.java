/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.impl;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.EnrolledUserDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.Bookmarker;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.EnrolledUser;
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

@Repository(value = "enrolledUserDAO")
public class EnrolledUserDAOImpl implements EnrolledUserDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public int insert(EnrolledUser enrolledUser) throws SQLException, ClassNotFoundException {
        String sql="Insert INTO tbl_enrolleduser (bookmarker_id,first_name,last_name,email,contact_no,payment,status) VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[] {enrolledUser.getBookmarker().getId(),enrolledUser.getFirstName(),enrolledUser.getLastName(),enrolledUser.getEmail(),enrolledUser.getContactNO(),enrolledUser.isPayment(),enrolledUser.isStatus()});
    }

    @Override
    public List<EnrolledUser> getAll() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM tbl_enrolleduser";
        return jdbcTemplate.query(sql, new RowMapper<EnrolledUser>() {

            @Override
            public EnrolledUser mapRow(ResultSet rs, int i) throws SQLException {
                EnrolledUser enrolledUser=new EnrolledUser();
                enrolledUser.setFirstName(rs.getString("first_name"));
                enrolledUser.setLastName(rs.getString("last_name"));
                enrolledUser.setEmail(rs.getString("email"));
                enrolledUser.setContactNO(rs.getInt("contact_no"));
                enrolledUser.setPayment(rs.getBoolean("payment"));
                enrolledUser.setStatus(rs.getBoolean("status"));
                enrolledUser.setAddedDate(rs.getTimestamp("added_date"));
                Bookmarker bookmarker=new Bookmarker();
                bookmarker.setId(rs.getInt("bookmarker_id"));
                enrolledUser.setBookmarker(bookmarker);
                return enrolledUser;
            }
        });
    }

    @Override
    public EnrolledUser getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countRow() throws ClassNotFoundException, SQLException {
        String sql="SELECT COUNT(*) FROM tbl_enrolleduser";
        return jdbcTemplate.queryForObject(sql, null, Integer.class);
    }
    
}
