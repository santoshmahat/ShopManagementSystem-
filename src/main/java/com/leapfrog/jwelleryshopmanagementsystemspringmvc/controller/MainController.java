/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.controller;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao.ItemDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.dao.BookmarkerDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.website.entity.Bookmarker;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author sarita
 */
@Controller
@RequestMapping(value = {"/",})
public class MainController {

    @Autowired
    ItemDAO itemDAO;
    
    @Autowired
    BookmarkerDAO bookmarkerDAO;
     
   
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        
        return "main/index";
    }
    
    
    
     @RequestMapping(value = "/admin/services" ,method = RequestMethod.GET)
    public String about(){
        
        return "main/services";
    }
    
     @RequestMapping(value = "/logout" ,method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
       request.getSession(false).invalidate();
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "main/bookmark",method = RequestMethod.GET)
    public String bookmark(){
       return "main/bookmark";
    }
    
    @RequestMapping(value = "main/bookmark/add",method = RequestMethod.POST)
    public String bookmarkSave(Bookmarker bookmarker){
        try{
        bookmarkerDAO.insert(bookmarker);
    }catch(ClassNotFoundException | SQLException cs){
        
    }
   return "redirect:/"; 
} 
}