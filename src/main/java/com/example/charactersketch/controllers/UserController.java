package com.example.charactersketch.controllers;

import com.example.charactersketch.models.User;
import com.example.charactersketch.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model){
        model.addAttribute(new User());

        return "signup";
    }

    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String processSignupForm(@ModelAttribute User newUser){
        userDao.save(newUser);

        return "profile";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String displayLoginForm(Model model){
        model.addAttribute(new User());

        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute User user){

        return "profile";
    }
}
