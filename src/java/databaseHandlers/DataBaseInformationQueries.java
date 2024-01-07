/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseHandlers;

/**
 *
 * @author quantap
 */

import dataContainers.UserInfo;
import java.sql.*;
import java.util.ArrayList;

public class DataBaseInformationQueries {
    Statement statementInst;
    ResultSet resultCont;
    public Connection con;
    public DataBaseInformationQueries(Connection con) throws SQLException{
        this.con = con;
        statementInst = con.createStatement();
        System.out.println("Connected");
        
    }
    public boolean addUser(UserInfo userData){
        int rows = 0;
        String values =  userData.getFname()  + "', '" +userData.getLname() + "', '" + userData.getEmail()  + "', '" + userData.getInstitute() + "', " + userData.getEducationLevel()+ ",'" + userData.getPassword();
        
        String addUserStatement ="INSERT INTO community_user VALUES (0, '" + values+"')";
        System.out.println(addUserStatement);
        try{
           rows = statementInst.executeUpdate(addUserStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows == 1;
    }
    public boolean checkUserExist(UserInfo userData){
        String checkUserExistStatement = "SELECT * FROM community_user WHERE UPPER(user_f_name) = '"+ userData.getFname().toUpperCase() + "' AND " + "UPPER(user_email) = '" + userData.getEmail().toUpperCase() + "'";
        try{
             resultCont = statementInst.executeQuery(checkUserExistStatement);
             
            return resultCont.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public UserInfo getUserInfoByEmail(String email){
        String userInfoStatement = "SELECT * FROM community_user WHERE UPPER(user_email) = '" + email.toUpperCase()+"'";
        try{
            resultCont = statementInst.executeQuery(userInfoStatement);
            if(resultCont.next()){
                return new UserInfo(resultCont.getString("user_f_name"),
                        resultCont.getString("user_l_name"),
                        resultCont.getString("user_institute"),
                        resultCont.getString("user_email"),
                        resultCont.getString("user_password"),
                        resultCont.getInt("user_education_level"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList allUsers(){
        String allUsersStatement = "SELECT * FROM community_user";
        ArrayList<String> usersC = new ArrayList<>();
        try{
            resultCont = statementInst.executeQuery(allUsersStatement);
            while(resultCont.next()){
                usersC.add(resultCont.getString("user_f_name") + " " + resultCont.getString("user_l_name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usersC;
    }
    public boolean removeUser(UserInfo userData){
        int rows = 0;
        String removeUserStatement = "DELETE FROM community_user WHERE user_email = '" + userData.getEmail()+"'";
        try{
            rows = statementInst.executeUpdate(removeUserStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
    public UserInfo getUserInfoById(int userId){
        String getUserInfoStatement = "SELECT * FROM community_user WHERE user_id = '" + userId + "'";
        try{
            resultCont = statementInst.executeQuery(getUserInfoStatement);
            if(resultCont.next()){
                return new UserInfo(resultCont.getString("user_f_name"),
                        resultCont.getString("user_l_name"),
                        resultCont.getString("user_institute"),
                        resultCont.getString("user_email"),
                        resultCont.getString("user_password"),
                        resultCont.getInt("user_education_level"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public UserInfo getUserId(String email){
        String getUserIdStatement = "SELECT * FROM community_user WHERE UPPER(user_email) = '" + email.toUpperCase() + "'";
        try{
            resultCont = statementInst.executeQuery(getUserIdStatement);
            if(resultCont.next()){
                return new UserInfo(resultCont.getString("user_f_name"),
                        resultCont.getString("user_l_name"),
                        resultCont.getString("user_institute"),
                        resultCont.getString("user_email"),
                        resultCont.getString("user_password"),
                        resultCont.getInt("user_education_level"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
        
    }
       
//    public static void main(String[] args){
//        try{
//            CreateConnection cInst = new CreateConnection();
//            Connection con = DriverManager.getConnection(cInst.getUrl() + cInst.getDatabase(), cInst.getUser(), cInst.getPassword());
//            DataBaseInformationQueries inst = new DataBaseInformationQueries(con);
//            System.out.println(inst.allUsers());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//    }
}
