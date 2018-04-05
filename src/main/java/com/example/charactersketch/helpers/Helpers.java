package com.example.charactersketch.helpers;

import javax.servlet.http.HttpSession;

public class Helpers {
    public static boolean userNotLoggedIn(HttpSession session){

        //check if there's a user in the session
        if(session.getAttribute("loggedInUser") == null){
            return true;
        }

        return false;
    }
}
