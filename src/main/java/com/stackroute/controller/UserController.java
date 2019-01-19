package com.stackroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    CrudOperation operation = new CrudOperation();
    @RequestMapping("/")
    public String greeting()
    {
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap map, @RequestParam("userName") String username,@RequestParam ("userPassword") String password ){
        operation.insertCustomer(username,password);
        map.addAttribute("user",""+username);
        return "login";
    }
}
