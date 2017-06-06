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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.program.services.FoodManager;

@Controller
public class IndexController {

    @Autowired
    FoodManager manager;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("foodModel", manager.getAllFoodData());
        return "index";
    }

}
