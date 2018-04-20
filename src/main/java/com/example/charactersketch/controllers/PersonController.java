package com.example.charactersketch.controllers;

import com.example.charactersketch.helpers.Helpers;
import com.example.charactersketch.models.Person;
import com.example.charactersketch.models.Project;
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
import java.util.List;

@Controller
@RequestMapping("character")
public class PersonController {

    @Autowired
    ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    //allows users to add a character to a project
    @RequestMapping(value="newchar/{projectId}", method= RequestMethod.GET)
    public String viewAddCharacter(Model model, @PathVariable("projectId") int projectId, HttpSession session){

        //ensure user is logged in
        if (Helpers.userNotLoggedIn(session)){
            return "redirect:/login";
        }

        //ensure current user created this project
        Project projectToView = projectDao.findOne(projectId);
        if (!(Helpers.isProjectCreator(session, projectToView))){
            return "redirect:/login";
        }

        model.addAttribute(new Person());
        model.addAttribute("title", "Add a New Character");

        return "character/newChar";
    }

    @RequestMapping(value="newchar/{projectId}", method=RequestMethod.POST)
    public String processAddCharacter(@ModelAttribute @Valid Person person, Errors errors, Model model,
                                      @PathVariable int projectId){

        if (errors.hasErrors()){
            model.addAttribute(new Person());
            model.addAttribute("title", "Add a New Character");
            return "character/newChar/{projectId}";
        }

        Project projectToEdit = projectDao.findOne(projectId);

        //save the new character
        person.setProject(projectToEdit);
        personDao.save(person);

        //get a list of the current characters and add the new character to the list
        List<Person> projectCharacters = projectToEdit.getPersons();
        projectCharacters.add(person);

        //save the updated list
        projectToEdit.setPersons(projectCharacters);
        projectDao.save(projectToEdit);

        return "redirect:/project/view/{projectId}";
    }

    //allows users to view an existing character
    @RequestMapping(value="viewchar/{personId}", method=RequestMethod.GET)
    public String viewCharacter(Model model, @PathVariable int personId, HttpSession session){

        if (Helpers.userNotLoggedIn(session)){
            return "redirect:/login";
        }

        //ensure current user created this project
        //find the ID of the project the character belongs to
        Person personToView = personDao.findOne(personId);
        Project project = personToView.getProject();

        if (!(Helpers.isProjectCreator(session, project))){
            return "redirect:/login";
        }

        //pass the character to the view
        model.addAttribute("title", "Character Sketch");
        model.addAttribute("person", personToView);

        return "character/viewchar";
    }

}
