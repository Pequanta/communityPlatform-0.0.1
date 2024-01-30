  package databaseHandlers;

import dataContainers.ChatInfo;
import java.sql.*;
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
    public DataBaseDiscussionQueries(Connection con) throws SQLException{
        this.con = con;
        statementInst = con.createStatement();
        System.out.println("Connected");
        
    }
    public Connection getConnection(){
        return this.con;
    }
    public boolean addChat(ChatInfo messageData, String userEmail){
        int rows = 0;
        
        String values =  messageData.getSentTime()  + "', '" +messageData.getMessageContent();
        String addChatStatement ="INSERT INTO message_table VALUES (0, '" + values+"'";
        String getId = "SELECT * FROM community_user WHERE UPPER(user_email) = '"+ userEmail.toUpperCase() + "'"; 
        int user_id = -1;
        
        
        try{
            resultCont = statementInst.executeQuery(getId);
            if(resultCont.next()) user_id = resultCont.getInt("user_id");
            System.out.println(addChatStatement + "," + user_id + ")");
           rows = statementInst.executeUpdate(addChatStatement + "," + user_id + ")");
           
           System.out.println("ADDed one chat");
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
            ResultSet userData;
            Statement userStat = con.createStatement();
            resultCont = statementInst.executeQuery(checkUserExistStatement);
            String user_name = "test";
            while(resultCont.next()){
                
                String getUser = "SELECT * FROM community_user WHERE user_id = "+ resultCont.getInt("user_id");
                System.out.println(resultCont.getInt("user_id"));
                String message = resultCont.getString("message_content");
                System.out.println(message);
                userData = userStat.executeQuery(getUser);
                if(userData.next()){
                    user_name = userData.getString("user_f_name");
                    System.out.println("Checked");
                    System.out.println(user_name);
                }
                messagesFound.add(user_name + "," + message);
            }
            return messagesFound;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ChatInfo messageInfo(int messageId){
        String userInfoStatement = "SELECT * FROM message_table message_id = " + messageId;
        try{
            resultCont = statementInst.executeQuery(userInfoStatement);
            if(resultCont.next()){
                return new ChatInfo(resultCont.getString("message_content"),
                        resultCont.getString("message_time"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean removeChat(ChatInfo messageData, String userEmail){
        int rows = 0;
        String getId = "SELECT * FROM community_user WHERE UPPER(user_email) = '"+ userEmail.toUpperCase() + "'";  
        int userId = -1;
        try{
            resultCont = statementInst.executeQuery(getId);
            userId = resultCont.getInt("user_id");
            String removeUserStatement = "DELETE FROM message_table WHERE user_id = " + userId +" AND UPPER(message_content) = '" + messageData.getMessageContent().toUpperCase()+"'";
            rows = statementInst.executeUpdate(removeUserStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
   
    
    //The following piece of should be removed in time of deployement;

    public boolean clearChat(){
        String clearChatStatement = "DELETE FROM message_table";
        int rows = 0;
        try{
            rows = statementInst.executeUpdate(clearChatStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
//
//    public static void main(String[] args){
//        try{
//            CreateConnection createInst = new CreateConnection();
//            Connection con = DriverManager.getConnection(createInst.getUrl() + createInst.getDatabase(), createInst.getUser(), createInst.getPassword());
//            DataBaseDiscussionQueries inst = new DataBaseDiscussionQueries(con);
//            
////            inst.addChat(new ChatInfo("hi there" , "11:30"), "PenielYohannes6@gmail.com");
////            inst.addChat(new ChatInfo("hallo" , "11:32"), "PenielYohannes@gmail.com");
////            inst.addChat(new ChatInfo("see ya" , "11:34"), "PenielYohannes0@gmail.com");
////            inst.addChat(new ChatInfo("hallo" , "11:32"), "PenielYohannes@gmail.com");
////            inst.addChat(new ChatInfo("hi there" , "11:30"), "PenielYohannes6@gmail.com");
////            inst.addChat(new ChatInfo("see ya" , "11:34"), "PenielYohannes0@gmail.com");
//            inst.allMessages();
//            inst.clearChat();
//            inst.allMessages();
////            System.out.println(inst.clearChat());
////            System.out.println(inst.allMessages());
//            
//        }catch(Exception e){
//            
//        }
//        
//    }
}