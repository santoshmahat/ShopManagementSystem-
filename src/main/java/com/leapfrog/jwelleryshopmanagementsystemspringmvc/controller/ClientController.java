/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.controller;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao.ClientDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao.ItemDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.entity.Client;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author sarita
 */
@Controller
@RequestMapping(value = {"/client","/client/add"})
public class ClientController {

    @Autowired
    ItemDAO itemdao;

    @Autowired
    ClientDAO clientDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        try {
            modelMap.addAttribute("items", itemdao.getAll());

        } catch (ClassNotFoundException | SQLException e) {

        }

        return "/clients/add_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public String save(Client client) {
        try {

            int result = clientDAO.insertClient(client);

        } catch (ClassNotFoundException | SQLException e) {

        }
        return "redirect:/client";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String show(ModelMap modelMap) {
        try {
            modelMap.addAttribute("clients", clientDAO.getAll());
            
        } catch (SQLException | ClassNotFoundException sc) {

        }

        return "clients/index";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Client client,ModelMap modelMap,@RequestParam("cid")int id) {
      
        try{
            modelMap.addAttribute("items", itemdao.getAll());
           modelMap.addAttribute("clients", clientDAO.getById(id)) ;
            
       }catch(SQLException | ClassNotFoundException sc ){
            
        }
        
        
        return "clients/edit_client";
    }
    
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Client client,@RequestParam("cid") int id){
        try{
            clientDAO.updateClient(client, id);
        }catch(SQLException | ClassNotFoundException se){
        }
        
        return "redirect:/client/index";
    }
    
    
     @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(Client client,@RequestParam("cid") int id){
        try{
            clientDAO.deleteClient(client, id);
        }catch(SQLException | ClassNotFoundException se){
        }
        
        return "redirect:/client/index";
    }
    
}
