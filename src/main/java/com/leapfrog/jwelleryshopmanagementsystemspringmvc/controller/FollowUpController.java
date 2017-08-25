/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.controller;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.BookmarkerDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.EnrolledUserDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.Bookmarker;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.EnrolledUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author sarita
 */
@Controller

@RequestMapping(value = "/follow-up")
public class FollowUpController {

    @Autowired
    BookmarkerDAO bookmarkerDAO;
    
    @Autowired
    EnrolledUserDAO enrolledUserDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String rowCount(ModelMap modelMap) {
        try {
            modelMap.addAttribute("bookmarkerRows", bookmarkerDAO.countRow());
            modelMap.addAttribute("enrolledUserRows",enrolledUserDAO.countRow());
        } catch (ClassNotFoundException | SQLException cs) {

        }

        return "analysis/index";
    }
    
    

    @RequestMapping(value = "/bookmark", method = RequestMethod.GET)
    public String boomarks(ModelMap modelMap) {
        try {

            modelMap.addAttribute("bookmarkers", bookmarkerDAO.getAll());
        } catch (ClassNotFoundException | SQLException cs) {
        }

        return "analysis/bookmark";
    }

    @RequestMapping(value = "/getJSON", method = RequestMethod.GET)
    public void getJSON(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        try {

            modelMap.addAttribute("bookmarkers", bookmarkerDAO.getAll());
            int id = Integer.parseInt(request.getParameter("bookmarker_id"));
            Bookmarker bookmarker = bookmarkerDAO.getById(id);
            
           
            
            JSONObject json = new JSONObject();
            json.put("firstName", bookmarker.getFirstName());
            json.put("lastName", bookmarker.getLastName());
            json.put("email", bookmarker.getEmail());
            json.put("contactNumber", bookmarker.getContactNO());

            response.setContentType("json");
            PrintWriter out = response.getWriter();

            out.println(json);

           // modelMap.addAttribute("getById",bookmarkerDAO.getById(id));
        } catch (ClassNotFoundException | SQLException | IOException | NumberFormatException csi) {
        }

        
    }
    
     @RequestMapping(value = "/enrolled", method = RequestMethod.GET)
    public String enrolled(ModelMap modelMap) {
        try {

            modelMap.addAttribute("bookmarkers", bookmarkerDAO.getAll());
            modelMap.addAttribute("enrolledUsers",enrolledUserDAO.getAll());
        } catch (ClassNotFoundException | SQLException cs) {
        }

        return "analysis/enrolled_user";
    }
    
    
     @RequestMapping(value = "/enrolled/add", method = RequestMethod.POST)
    public String insertEnrolledUser(EnrolledUser enrolledUser) {
        try {

            enrolledUserDAO.insert(enrolledUser);
        } catch (ClassNotFoundException | SQLException cs) {
        }

        return "redirect:/follow-up/enrolled";
    }
    
    
}
