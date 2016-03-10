package com.controller;

import com.entity.User;
import com.repository.UserRepository;
import com.servise.CountryService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String Show(){
        return "StartingPage";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser (@RequestParam String lastName, @RequestParam String firstName, @RequestParam String password, @RequestParam String emailUser){
        userService.addUser(lastName,firstName,password,emailUser);
        return "redirect:/";
    }

}