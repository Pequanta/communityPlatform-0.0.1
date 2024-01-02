package databaseHandlers;

import dataContainers.Publication;
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
public class DataBasePublicationQueries {
     Statement statementInst;
    ResultSet resultCont;
    public Connection con;
    public DataBasePublicationQueries(Connection con) throws SQLException{
        this.con = con;
        statementInst = con.createStatement();
        System.out.println("Connected");
        
    }
    public boolean addPublication(Publication publication){
        int rows = 0;
        String values =  publication.getPublicationTime()  + "', '" +publication.getPublicationText() + "', '" + publication.getPublicationTitle() + "','" + publication.getAuthorEmail();
        
            String addPublicationStatement ="INSERT INTO publication_table VALUES (0, '" + values+"')";
        System.out.println(addPublicationStatement);
        try{
           rows = statementInst.executeUpdate(addPublicationStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows == 1;
    }
    public ArrayList<String> checkPublicationExists(String publicationToCheck){
        String checkPublicationTitleExistStatement = "SELECT * FROM publication_table WHERE UPPER(publication_title) LIKE '%" + publicationToCheck.toUpperCase()+"%'";
        String checkPublicationTextExistStatment = "SELECT * FROM publication_table WHERE UPPER(publication_content) LIKE '%" + publicationToCheck.toUpperCase()+"%'";
        ArrayList<String> publicationsFound = new ArrayList<>();
        try{
            resultCont = statementInst.executeQuery(checkPublicationTitleExistStatement);
            while(resultCont.next()){
                publicationsFound.add(resultCont.getString("publication_title"));
            }
            resultCont = statementInst.executeQuery(checkPublicationTextExistStatment);
            while(resultCont.next()){
                publicationsFound.add(resultCont.getString("publication_content"));
            }
            return publicationsFound;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> allPublications(){
        String getAllPublications = "SELECT * FROM publication_table";
        ArrayList<String> publicationsFound = new ArrayList<>();
        try{
            resultCont = statementInst.executeQuery(getAllPublications);
            while(resultCont.next()){
                publicationsFound.add(resultCont.getInt("publication_id") + "," + resultCont.getString("publication_title"));
                
            }
            return publicationsFound;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Publication publicationInfo(int publication_id){
        String userInfoStatement = "SELECT * FROM publication_table WHERE publication_id = '" + publication_id+"'";
        try{
            resultCont = statementInst.executeQuery(userInfoStatement);
            if(resultCont.next()){
                return new Publication(resultCont.getString("user_email"),
                        resultCont.getString("publication_content"),
                        resultCont.getString("publication_time"),
                        resultCont.getString("publication_title"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean removePublication(Publication publication){
        int rows = 0;
        String removeUserStatement = "DELETE FROM publication_table WHERE UPPER(user_email) = '" + publication.getAuthorEmail().toUpperCase()+"' AND UPPER(publication_content) = '" + publication.getPublicationText().toUpperCase()+"'";
        try{
            rows = statementInst.executeUpdate(removeUserStatement);
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