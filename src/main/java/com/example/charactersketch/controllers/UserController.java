package com.example.charactersketch.controllers;

import com.example.charactersketch.models.User;
import com.example.charactersketch.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model){

        model.addAttribute(new User());
        model.addAttribute("title", "Create an Account");

        return "signup";
    }

    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String processSignupForm(@ModelAttribute @Valid User newUser, Errors errors, Model model,
                                    HttpServletRequest request, HttpServletResponse response){

        if (errors.hasErrors()){
            model.addAttribute("title", "Create an Account");
            return "signup";
        }

        userDao.save(newUser);
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", newUser);
        model.addAttribute("title", "My Projects");

        return "redirect:/profile";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String displayLoginForm(Model model){

        model.addAttribute(new User());
        model.addAttribute("title", "Log In");

        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute @Valid User returningUser, Errors errors, Model model,
                                   HttpServletRequest request, HttpServletResponse response){

        if (errors.hasErrors()){
            model.addAttribute("title", "Log In");
            return "signup";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", returningUser);
        model.addAttribute("title", "My Projects");

        return "redirect:/profile";
    }

    @RequestMapping(value="profile", method = RequestMethod.GET)
    public String displayProfile(Model model){
        model.addAttribute("title", "My Projects");
        return "profile";
    }
}
