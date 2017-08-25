/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jwelleryshopmanagementsystemspringmvc.controller;

import com.leapfrog.jwelleryshopmanagementsystemspringmvc.dao.ItemDAO;
import com.leapfrog.jwelleryshopmanagementsystemspringmvc.entity.Item;
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
@RequestMapping(value = {"/item"})
public class ItemController {

    @Autowired
    ItemDAO itemDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "/items/add_item";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public String save(Item item) {

        try {

            int result = itemDAO.insert(item);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/item/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String show(ModelMap modelMap) {
        try {
            modelMap.addAttribute("items", itemDAO.getAll());
        } catch (SQLException | ClassNotFoundException sc) {

        }
        return "/items/index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("iid") int id, ModelMap modelMap) {
        try {
            modelMap.addAttribute("items", itemDAO.getById(id));
        } catch (SQLException | ClassNotFoundException sc) {

        }
        return "/items/edit_item";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Item item, @RequestParam("iid") int id) {
        try {
            int result = itemDAO.update(item, id);
        } catch (SQLException | ClassNotFoundException sc) {

        }
        return "redirect:/item/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Item item, @RequestParam("iid") int id) {
        try {
            int result = itemDAO.delete(item, id);
        } catch (SQLException | ClassNotFoundException sc) {

        }
        return "redirect:/item/index";
    }
}
