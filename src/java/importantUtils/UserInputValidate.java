package importantUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quantap
 */

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
        String invalidPassword = "[a-z]+";
        String weakPassword = "[a-zA-Z0-9]+";
        String strongPassword = "[[a-zA-z0-9]{1,}[^a-zA-Z0-9]{1,}]+";
        int res = -1;
        if(Pattern.matches(strongPassword, password)) res= 2;
        else if(Pattern.matches(weakPassword, password)) res= 1;
        else if(Pattern.matches(invalidPassword, password)) res= 0;
        else res = 3;
        return res;
    }
}
