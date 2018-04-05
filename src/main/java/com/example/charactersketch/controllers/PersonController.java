package com.example.charactersketch.controllers;

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
    public String viewAddCharacter(Model model, @PathVariable int projectId){

        //TODO: ensure user is project creator

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
    public String viewCharacter(Model model, @PathVariable int personId){

        //TODO: make sure user is logged in and the character is one they created

        //use the path variable and PersonDao to find the character the user wants to view
        Person personToView = personDao.findOne(personId);

        //pass the character to the view
        model.addAttribute("title", "Character Sketch");
        model.addAttribute("person", personToView);

        return "character/viewchar";
    }

}
