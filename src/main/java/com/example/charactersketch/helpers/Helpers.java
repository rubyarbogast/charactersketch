package com.example.charactersketch.helpers;

import com.example.charactersketch.models.Project;
import com.example.charactersketch.models.User;
import com.example.charactersketch.models.data.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class Helpers {

    public static boolean userNotLoggedIn(HttpSession session){

        //check if there's a user in the session
        if(session.getAttribute("loggedInUser") == null){
            return true;
        }

        return false;
    }

    public static boolean isCorrectUser(HttpSession session, Project projectToView){

        //check to see if a user is logged in
        if(userNotLoggedIn(session)){
            return false;
        }

        //get the ID of the current user and the ID of the user who created the project they're attempting to view
        User currentUser = (User) session.getAttribute("loggedInUser");
        User projectCreator = projectToView.getCreator();

        //return true if the current user is the project creator
        if(currentUser.getId() == projectCreator.getId()){
            return true;
        } else {
            return false;
        }
    }
}
