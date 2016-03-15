package com.controller;

import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    ModelFillingController modelFillingController;

    @Autowired
    UserService userService;

    @RequestMapping("/MainPage")
    public String ShowMainPage(Model model){
        modelFillingController.FillingModelUser(model);
        return "MainPage";
    }


}
