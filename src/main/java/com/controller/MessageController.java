package com.controller;

import com.entity.Messages;
import com.entity.User;
import com.servise.FrendsService;
import com.servise.MessageService;
import com.servise.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    FrendsService frendsService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;


    @RequestMapping("/message")
    public String ShowMessage(){
        return "Message";
    }

    @RequestMapping("getAllUserForMessegerPage.json")
    public @ResponseBody Iterable<User> getAllUserForMessegerPage(Principal principal){
        return frendsService.getFrends(principal,1,1,1);
    }

    @ModelAttribute("newMessege")
    public Messages newMessege(){
        return new Messages();
    }


    @RequestMapping("getDialog-Resived-{idUser}")
    public @ResponseBody List<Messages> getMessegForUserId(Principal principal, @PathVariable("idUser") int idUserResived){
        List<Messages> list = new ArrayList<Messages>();
        Hibernate.initialize(messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived));
        return messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived);
    }

    @RequestMapping(value = "MessegerUpdate{resiverUser}-{textMesseg}.json")
    public @ResponseBody Iterable<Messages> sendMessegerAndUpdate(@PathVariable("resiverUser") int resiverUser, Principal principal,@PathVariable("textMesseg") String textMesseg){
        Messages messages = new Messages();
        messages.setUserSentMessager(userService.findById(Integer.parseInt(principal.getName())));
        messages.setUserReceivedMessages(userService.findById(resiverUser));
        messages.setMessager(textMesseg);
        messages.setStatys(1);
        messageService.save(messages);
        return messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()), resiverUser);
    }

}
