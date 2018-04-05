package com.example.charactersketch.controllers;

import com.example.charactersketch.models.Person;
import com.example.charactersketch.models.Project;
import com.example.charactersketch.models.User;
import com.example.charactersketch.models.data.PersonDao;
import com.example.charactersketch.models.data.ProjectDao;
import com.example.charactersketch.models.data.UserDao;
import com.example.charactersketch.helpers.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    //allows user to create a new project
    @RequestMapping(value="newproject", method = RequestMethod.GET)
    public String displayProjectPage(Model model, HttpSession session){

        //require user to be logged in
        if (Helpers.userNotLoggedIn(session)){
            return "redirect:/login";
        }

        model.addAttribute(new Project());
        model.addAttribute("title", "Create a New Project");

        return "project/newproject";
    }

    //allows user to save their project
    @RequestMapping(value="newproject", method = RequestMethod.POST)
    public String processProjectPage(@ModelAttribute @Valid Project newProject, Errors errors, Model model,
                                     HttpSession session){

        if (errors.hasErrors()){
            model.addAttribute(new Project());
            model.addAttribute("title", "Create a New Project");
            return "project/newproject";
        }

        User currentUser = (User) session.getAttribute("loggedInUser");
        newProject.setCreator(currentUser);

        //save the project to the DB
        projectDao.save(newProject);

        //need to include the project ID in the URL
        return "redirect:/profile";
    }

    //allows users to view an existing project
    @RequestMapping(value="view/{projectId}", method=RequestMethod.GET)
    public String viewProject(Model model, @PathVariable("projectId") int projectId, HttpSession session){

        System.out.println(projectId);
        //if user is not in session, redirect to login
        if (Helpers.userNotLoggedIn(session)){
            return "redirect:/login";
        }

        //get the project to view
        Project projectToView = projectDao.findOne(projectId);

        if (!(Helpers.isCorrectUser(session, projectToView))){
            return "redirect:/login";
        }

        model.addAttribute("title", projectToView.getTitle());
        model.addAttribute("project", projectToView);

        return "project/view";
    }

}
