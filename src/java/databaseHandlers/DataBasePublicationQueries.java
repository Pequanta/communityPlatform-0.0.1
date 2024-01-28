package databaseHandlers;

import dataContainers.Publication;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;

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
    public boolean addPublication(Publication publication, String authorEmail){
        int rows = 0, userId = -1;
        String getId = "SELECT * FROM community_user WHERE UPPER(user_email) = '" + authorEmail.toUpperCase() + "'";
        
        
        try{
            resultCont = statementInst.executeQuery(getId);
            
            if(resultCont.next()) userId = resultCont.getInt("user_id");
            String values =  publication.getPublicationTime()  + "', '" +publication.getPublicationText() + "', '" + publication.getPublicationTitle() + "' , ";
            String addPublicationStatement ="INSERT INTO publication_table VALUES (0, '" + values+ userId + ")";
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
            ResultSet contSet;
            Statement contStat = con.createStatement();
            resultCont = statementInst.executeQuery(getAllPublications);
            while(resultCont.next()){
                String getAuthorId = "SELECT * FROM community_user WHERE user_id = " + resultCont.getInt("user_id");
                contSet = contStat.executeQuery(getAuthorId);
                contSet.next();
                publicationsFound.add(contSet.getString("user_email") + "," + contSet.getString("user_f_name") + " " + contSet.getString("user_l_name") + "," + resultCont.getInt("publication_id") + "," + resultCont.getString("publication_title"));
                
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
                return new Publication(resultCont.getString("publication_content"),
                        resultCont.getString("publication_time"),
                        resultCont.getString("publication_title"));
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean removePublication(Publication publication, String authorEmail){
        int rows = 0, userId = -1;
        String getId = "SELECT * FROM community_user WHERE UPPER(user_email) = '" + authorEmail.toUpperCase() + "'";
        
        try{
            resultCont = statementInst.executeQuery(getId);
            if(resultCont.next()) userId = resultCont.getInt("user_id");
            String removeUserStatement = "DELETE FROM publication_table user_id = '" + 
                    userId+"' AND UPPER(publication_content) = '" + publication.getPublicationText().toUpperCase()+"'";
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
//            System.out.println(inst.addPublication(new Publication("What is going on here!", "11:30", "nothing"), "penielyohannes6@gmail.com"));
//            ArrayList cont = inst.allPublications();
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