/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataContainers;

/**
 *
 * @author quantap
 */
public class UserInfo {
    private String fname, lname, institute, email, password;
    private int educationLevel;
    public UserInfo(){
        fname = "Test";
        lname = "Test";
        institute = "Test";
        email = "Test";
        password = "Test";
        educationLevel = 0;
        
    }
    public UserInfo(String fname, String lname, String institute, String email, String password, int educationLevel){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.institute = institute;
        this.password = password;
        this.educationLevel = educationLevel;
    }
    public String getLname(){
        return lname;
    }
    public String getFname(){
        return fname;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public int getEducationLevel(){
        return educationLevel;
    }
    public String getInstitute(){
        return institute;
    }
    public boolean setLname(String newLname){
        if(newLname != null){
           this.lname = newLname;
           return true;
       }
       return false;
    }
    public boolean setFname(String newFname){
        if(newFname != null){
           this.fname = newFname;
           return true;
       }
       return false;
    }
    public boolean setEmail(String newEmail){
        if(newEmail != null){
           this.email = newEmail;
           return true;
       }
       return false;
    }
    public boolean setPassword(String newPassword){
       if(newPassword != null){
           this.password = newPassword;
           return true;
       }
       return false;
    }
    public boolean setEducationLevel(int newEducationLevel){
        this.educationLevel = newEducationLevel;
        return true;
    }
    public boolean setInstitute(String newInstitute){
        if(newInstitute != null){
           this.password = newInstitute;
           return true;
       }
       return false;
    }
    
    
}
