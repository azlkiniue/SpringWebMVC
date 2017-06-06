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
import java.util.Map;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/formUpdate")
public class UpdateItemController {

    @Autowired
    FoodManager manager;
    
    @RequestMapping(method = RequestMethod.GET)
    public String formUpdate(@RequestParam("id")int id, Model model) {
        model.addAttribute("foodModel", manager.getFoodData(id));
        return "formUpdate";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String submitAdd(@Valid FoodModel foodModel,Map model){
        foodModel = (FoodModel) model.get("foodModel");
        manager.updateFoodData(foodModel);
        return "home"; //redirect to index
    }
    
}
