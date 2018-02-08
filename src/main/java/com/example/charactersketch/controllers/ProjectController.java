package com.example.charactersketch.controllers;

import com.example.charactersketch.models.Person;
import com.example.charactersketch.models.Project;
import com.example.charactersketch.models.User;
import com.example.charactersketch.models.data.PersonDao;
import com.example.charactersketch.models.data.ProjectDao;
import com.example.charactersketch.models.data.UserDao;
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

@Controller
public class ProjectController {
    @Autowired
    ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    //allows user to create a new project
    @RequestMapping(value="project/newproject", method = RequestMethod.GET)
    public String displayProjectPage(Model model, HttpSession session){

        //require user to be logged in
        if (session.getAttribute("loggedInUser") == null){
            return "redirect:/login";
        }

        model.addAttribute(new Project());
        model.addAttribute("title", "Create a New Project");

        return "project/newproject";
    }

    //allows user to save their project
    @RequestMapping(value="project/newproject", method = RequestMethod.POST)
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
    @RequestMapping(value="project/view/{projectId}", method=RequestMethod.GET)
    public String viewProject(Model model, @PathVariable int projectId, HttpSession session){

        //if user is not in session, redirect to login
        if (session.getAttribute("loggedInUser") == null){
            return "redirect:/login";
        }
        //ensure that the user is logged in

        Project projectToView = projectDao.findOne(projectId);
        model.addAttribute("title", projectToView.getTitle());
        model.addAttribute("project", projectToView);

        return "project/view";
    }

    //allows users to add a character to a project
    @RequestMapping(value="project/newChar/{projectId}", method=RequestMethod.GET)
    public String viewAddCharacter(Model model, @PathVariable int projectId){

        model.addAttribute(new Person());
        model.addAttribute("title", "Add a New Character");

        return "project/newChar";
    }

    @RequestMapping(value="project/newChar/{projectId}", method=RequestMethod.POST)
    public String processAddCharacter(@ModelAttribute @Valid Person person, Errors errors, Model model,
                                      @PathVariable int projectId){

        if (errors.hasErrors()){
            model.addAttribute(new Person());
            model.addAttribute("title", "Add a New Character");
            return "project/newChar/{projectId}";
        }

        personDao.save(person);
        return "project/view/{projectId}";
    }
}
