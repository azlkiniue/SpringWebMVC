/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.program.controllers;

/**
 *
 * @author student
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.program.services.FoodManager;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    FoodManager manager;
    
    @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
    public String delete(@RequestParam("id")int id) {        
        manager.deleteFoodData(id);
        return "home"; //redirect to index
    }

}
