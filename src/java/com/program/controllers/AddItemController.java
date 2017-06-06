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
import com.program.models.FoodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.program.services.FoodManager;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/formAdd")
public class AddItemController {

    @Autowired
    FoodManager manager;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView formAdd() {
        return new ModelAndView("formAdd", "command", new FoodModel());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String submitAdd(@ModelAttribute FoodModel foodModel){
        manager.addFoodData(foodModel);
        return "home"; //redirect to index
    }
    
}
