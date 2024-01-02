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
    public DataBaseDiscussionQueries(Connection con) throws SQLException{
        this.con = con;
        statementInst = con.createStatement();
        System.out.println("Connected");
        
    }
    public Connection getConnection(){
        return this.con;
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
    public static void main(String[] args){
        try{
            CreateConnection createInst = new CreateConnection();
            Connection con = DriverManager.getConnection(createInst.getUrl() + createInst.getDatabase(), createInst.getUser(), createInst.getPassword());
            DataBaseDiscussionQueries inst = new DataBaseDiscussionQueries(con);
            System.out.println(inst.allMessages());
            System.out.println(inst.clearChat());
            System.out.println(inst.allMessages());
            
        }catch(Exception e){
            
        }
        
    }
}