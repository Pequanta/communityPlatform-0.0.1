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


public class DataBaseInformationQueries {
    Statement statementInst;
    ResultSet resultCont;
    public Connection con;
    public DataBaseInformationQueries(){
        CreateConnection conInfo = new CreateConnection(); 
        try{
            con = DriverManager.getConnection(conInfo.getUrl() + conInfo.getDatabase(),  conInfo.getUser(), conInfo.getPassword());
            statementInst = con.createStatement();
            System.out.println("Connected");
        }catch(SQLException e){
        }
        
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
    public UserInfo userInfo(String email){
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
//    public static void main(String[] args){
//        DataBaseInformationQueries inst = new DataBaseInformationQueries();
//        //UserInfo userInst = new UserInfo("Walelign", "Tagesse","AAiT", "walelign@gmail.com", "asdf", 1);
//        UserInfo userInst1 = new UserInfo("Peniel", "Peniel","AAiT", "Penielyohannes6@gmail.com", "asdf", 0);
//        //System.out.println(inst.addUser(userInst1));
//        //System.out.println(inst.userInfo(userInst1.getEmail()).getPassword());
//        System.out.println(inst.userInfo("Penielyohannes6@gmail.com").getEmail());
//        System.out.println(inst.userInfo("Penielyohannes6@gmail.com").getFname());
//        System.out.println(inst.checkUserExist((userInst1)));
//        //System.out.println(inst.removeUser(userInst1));
//        
//        
//    }
    
}
