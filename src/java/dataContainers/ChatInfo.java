package dataContainers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quantap
 */
public class ChatInfo {
    private String userEmail, messageContent, sentTime;
    public ChatInfo(){
        this.userEmail = "Test";
        this.messageContent = "Test";
        this.sentTime = "Test";
    }
    public ChatInfo(String userEmail, String messageContent, String sentTime){
        this.userEmail = userEmail;
        this.messageContent = messageContent;
        this.sentTime = sentTime;
    }
    public String getUserEmail(){
        return this.userEmail;
    }
    public String getMessageContent(){
        return this.messageContent;
    }
    public String getSentTime(){
        return this.sentTime;
    }
    public boolean setUserEmail(String newEmail){
        if(newEmail != null){
           this.userEmail = newEmail;
           return true;
       }
       return false;
    }
    public boolean setMessageContent(String newMessage){
        if(newMessage != null){
           this.messageContent = newMessage;
           return true;
       }
       return false;
    }
}
