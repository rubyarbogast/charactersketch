package com.example.charactersketch.controllers;

import com.example.charactersketch.models.Project;
import com.example.charactersketch.models.User;
import com.example.charactersketch.models.data.ProjectDao;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    ProjectDao projectDao;

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

        Iterable<User> users = userDao.findAll();

        for (User user : users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                model.addAttribute("title", "Create an Account");
                model.addAttribute("message", "That username is already in use. " +
                        "Please choose something else.");
                return "signup";
            }
        }

        userDao.save(newUser);
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", newUser);
        response.encodeRedirectURL("/profile");
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
    public String processLoginForm(@ModelAttribute @Valid User returningUser, Model model,
                                   HttpServletRequest request, HttpServletResponse response){

        Iterable<User> users = userDao.findAll();

        for (User user : users) {
            if (user.getUsername().equals(returningUser.getUsername())) {
                if (user.getPassword().equals(returningUser.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", user);
                    model.addAttribute("title", "My Projects");
                    response.encodeRedirectURL("profile");
                    return "redirect:/profile";

                } else {
                    //return login page with password error
                    model.addAttribute("title", "Log In");
                    model.addAttribute("passwordMessage",
                            "Username and password not found. Please try again.");
                    return "login";
                }
            }
        }

        return "redirect:/profile";
    }

    @RequestMapping(value="profile", method = RequestMethod.GET)
    public String displayProfile(Model model, HttpSession session){

        //if there's no user logged in, redirect to login page
        if (session.getAttribute("loggedInUser") == null){
            return "redirect:/login";
        }

        //identify which user is logged in
        User currentUser = (User) session.getAttribute("loggedInUser");
        User user = userDao.findOne(currentUser.getId());

        List<Project> userProjects = new ArrayList<>();
        Iterable<Project> projects = projectDao.findAll();

        for (Project project : projects){
            if (project.getCreator() == user){
                userProjects.add(project);
            }
        }

        model.addAttribute("projects", userProjects);
        model.addAttribute("title", "My Projects");

        return "profile";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("loggedInUser");
        model.addAttribute("title", "Log Out");
        return "logout";
    }
}
