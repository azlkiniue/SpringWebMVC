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
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import com.program.services.FoodManager;
import com.program.models.FileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/formUpload")
public class UploadController {

    @Autowired
    FoodManager manager;
    @Autowired
    ServletContext context; 

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView formUpload() {
        return new ModelAndView("formUpload", "command", new FileModel());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitUpload(@Validated FileModel file, ModelMap model) throws IOException {
        MultipartFile multipartFile = file.getFile();
        String uploadPath = context.getRealPath("").replace("\\build\\", "\\") + File.separator + "file" + File.separator;
        //Now do something with file...
        FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath + file.getFile().getOriginalFilename()));
        String fileName = multipartFile.getOriginalFilename();
        manager.updateFoodPicture(fileName, file.getId());
        return "home"; //redirect to index
    }

}
