package importantUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quantap
 */

//The class didn't act as it was intended . Need modification to handle the request and need to consider additional conditions

import java.util.regex.*;

//This class will be used by different user input acceptors as a way of processing user input
public class UserInputValidate {
    //This method returns the validity of email;
    //false represents invalid email and true represents valid email;
    public static boolean validEmail(String email){
        String validEmailP = "[a-zA-Z0-9]+[@]{1}[a-z]+[.]{1}[a-z]{2,3}";
        return Pattern.matches(validEmailP, email);
    }
    //it works in the same was as validEmai
    public static boolean validName(String name){
        String validNameP = "[A-Z]{0,1}[a-z]+[\\s]?[A-Z]{0,1}[a-z]+";
        return Pattern.matches(validNameP,name);
    }
    //This method return the strength of a password
    //0 for invalid password
    //1 for weak password and {}
    //2 for strong password;
    //-1 for invalid input : this includes empty password
    public static int validPassword(String password){
        int res = -1;
        String cap = "[A-Z]{1,}", small="[a-z]{1,}", nums = "[0-9]{1,}", symbols = "[^a-zA-Z0-9]{1,}";
        if(Pattern.matches(cap, password) && Pattern.matches(small, password) && Pattern.matches(nums, password) && Pattern.matches(symbols, password)) res= 2;
        else if(Pattern.matches(small, password) && Pattern.matches(cap, password)) res= 1;
        else if(Pattern.matches(small, password)) res= 0;
        return res;
    }
}
