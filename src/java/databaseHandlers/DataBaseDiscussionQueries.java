package databaseHandlers;

import dataContainers.ChatInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quantap
 */
public class DataBaseDiscussionQueries {
     Statement statementInst;
    ResultSet resultCont;
    public Connection con;
    public DataBaseDiscussionQueries(){
        CreateConnection conInfo = new CreateConnection(); 
        try{
            con = DriverManager.getConnection(conInfo.getUrl() + conInfo.getDatabase(),  conInfo.getUser(), conInfo.getPassword());
            statementInst = con.createStatement();
            System.out.println("Connected");
        }catch(SQLException e){
        }
        
    }
    public boolean addChat(ChatInfo messageData){
        int rows = 0;
        String values =  messageData.getSentTime()  + "', '" +messageData.getMessageContent() + "', '" + messageData.getUserEmail();
        
            String addChatStatement ="INSERT INTO message_table VALUES (0, '" + values+"')";
        System.out.println(addChatStatement);
        try{
           rows = statementInst.executeUpdate(addChatStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows == 1;
    }
    public ArrayList<String> checkMessageExists(String messageToCheck){
        String checkUserExistStatement = "SELECT * FROM message_table WHERE UPPER(message_content) LIKE '%" + messageToCheck.toUpperCase()+"%'";
        ArrayList<String> messagesFound = new ArrayList<>();
        try{
            resultCont = statementInst.executeQuery(checkUserExistStatement);
            while(resultCont.next()){
                messagesFound.add(resultCont.getString("message_content"));
            }
            return messagesFound;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> allMessages(){
        String checkUserExistStatement = "SELECT * FROM message_table";
        ArrayList<String> messagesFound = new ArrayList<>();
        try{
            resultCont = statementInst.executeQuery(checkUserExistStatement);
            while(resultCont.next()){
                messagesFound.add(resultCont.getString("message_content"));
            }
            return messagesFound;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ChatInfo messageInfo(String messageContent){
        String userInfoStatement = "SELECT * FROM message_table WHERE UPPER(message_content) = '" + messageContent.toUpperCase()+"'";
        try{
            resultCont = statementInst.executeQuery(userInfoStatement);
            if(resultCont.next()){
                return new ChatInfo(resultCont.getString("user_email"),
                        resultCont.getString("message_content"),
                        resultCont.getString("message_time"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean removeChat(ChatInfo messageData){
        int rows = 0;
        String removeUserStatement = "DELETE FROM message_table WHERE UPPER(user_email) = '" + messageData.getUserEmail().toUpperCase()+"' AND UPPER(message_content) = '" + messageData.getMessageContent().toUpperCase()+"'";
        try{
            rows = statementInst.executeUpdate(removeUserStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
//    public static void main(String[] args){
//        DataBaseDiscussionQueries inst = new DataBaseDiscussionQueries();
//        ChatInfo chat = new ChatInfo("Penielyohannes6@gmail.com", "Hello there, How are you?", "11:30");
//        ChatInfo chat2 = new ChatInfo("Someone@gmail.com", "fine , how are u?", "11:31");
//        ChatInfo chat3 = new ChatInfo("Penielyohannes6@gmail.com", "good!, whats up", "11:33");
//        ChatInfo chat4 = new ChatInfo("Someone@gmail.com", "Not much!", "11:34");
//        ChatInfo chat5 = new ChatInfo("Someone@gmail.com", "Not much! whats up with u?", "11:34");
////        System.out.println(inst.addChat(chat));
////        System.out.println(inst.addChat(chat2));
////        System.out.println(inst.addChat(chat3));
////        System.out.println(inst.addChat(chat4));
////        System.out.println(inst.addChat(chat3));
////        System.out.println(inst.addChat(chat5));
//        System.out.println(inst.messageInfo(chat4.getMessageContent()).getUserEmail());
//        System.out.println(inst.allMessages());
//    }
}