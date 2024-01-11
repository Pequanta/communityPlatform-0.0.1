package databaseHandlers;

import dataContainers.ResourceInfo;
import java.sql.Connection;
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
public class DataBaseResourcesQueries {
    Statement statementInst;
    ResultSet resultCont;
    public Connection con;
    public DataBaseResourcesQueries(Connection con) throws SQLException{
        this.con = con;
        statementInst = con.createStatement();
        System.out.println("Connected");
        
    }
    public boolean addResources(ResourceInfo resource){
        int rows = 0;
        String values =  resource.getTitle()  + "', '" + resource.getLink();
        
            String addResourceStatement ="INSERT INTO resources VALUES (0, '" + values+"')";
        System.out.println(addResourceStatement);
        try{
           rows = statementInst.executeUpdate(addResourceStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows == 1;
    }
    public boolean checkResource(String linkToCheck){
        String checkResourceLinkExistStatement = "SELECT * FROM publication_table WHERE UPPER(resource_link) LIKE '%" + linkToCheck.toUpperCase()+"%'";
        try{
            resultCont = statementInst.executeQuery(checkResourceLinkExistStatement);
            return resultCont.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<String> allResources(){
        String getAllPublications = "SELECT * FROM resources";
        ArrayList<String> resourcesFound = new ArrayList<>();
        try{
            resultCont = statementInst.executeQuery(getAllPublications);
            while(resultCont.next()){
                resourcesFound.add(resultCont.getInt("resource_id") +" , " + resultCont.getString("resource_title")+ " , " + resultCont.getString("resource_link"));
                
            }
            return resourcesFound;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ResourceInfo resourceInfo(String link){
        String resourceInfoStatement = "SELECT * FROM publication_table WHERE UPPER(resource_link) = '" + link.toUpperCase()+"'";
        try{
            resultCont = statementInst.executeQuery(resourceInfoStatement);
            if(resultCont.next()){
                return new ResourceInfo(resultCont.getString("resource_title"),
                        resultCont.getString("resource_link"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean removeResource(ResourceInfo resource){
        int rows = 0;
        String removeResourceStatement = "DELETE FROM resources WHERE UPPER(resource_link) = '" + resource.getLink().toUpperCase()+"'";
        try{
            rows = statementInst.executeUpdate(removeResourceStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
//    public static void main(String[] args){
//        try{
//            CreateConnection conInfo = new CreateConnection();
//            Connection con = DriverManager.getConnection(conInfo.getUrl() + conInfo.getDatabase() , conInfo.getUser(), conInfo.getPassword());
//            DataBasePublicationQueries inst = new DataBasePublicationQueries(con);
//            Publication pub = new Publication("Penielyohannes6@gmail.com", "Quantum Computing is a branch of Quantum Mechanics", "11:30", "Quantum Computing");
//            Publication pub2 = new Publication("Someone6@gmail.com", "Though it is not practically economical in its study , Quantum Computing is a branch of Quantum Mechanics", "11:30", "Practicallity of Quantum Computing");
//            Publication pub3 = new Publication("Someone6@gmail.com", "We can Use Quantum Computing to implement algorithms that are cost in nature", "11:30", "Time complex Algorithms");
//            Publication pub4 = new Publication("Penielyohannes6@gmail.com", "Physics is study of nature", "11:30", "Physics");
//            Publication pub5 = new Publication("Someone@gmail.com", "Study what ever u want!", "11:30", "Study Choice");
//            System.out.println(inst.addPublication(pub));
//            System.out.println(inst.addPublication(pub2));
//            System.out.println(inst.addPublication(pub3));
//            System.out.println(inst.addPublication(pub4));
//            System.out.println(inst.addPublication(pub5));
//            ArrayList<String> cont = inst.allPublications();
//            for(int i = 0;i < cont.size();i++){
//                System.out.println(cont.get(i));
//            }
//    //        inst.removePublication(pub2);
//            cont = inst.allPublications();
//            for(int i = 0;i < cont.size();i++){
//                System.out.println(cont.get(i));
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//    }
}