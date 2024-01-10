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
    private String messageContent, sentTime;
    public ChatInfo(){
        this.messageContent = "Test";
        this.sentTime = "Test";
    }
    public ChatInfo(String messageContent, String sentTime){
        this.messageContent = messageContent;
        this.sentTime = sentTime;
    }
    public String getMessageContent(){
        return this.messageContent;
    }
    public String getSentTime(){
        return this.sentTime;
    }
    public boolean setMessageContent(String newMessage){
        if(newMessage != null){
           this.messageContent = newMessage;
           return true;
       }
       return false;
    }
}
