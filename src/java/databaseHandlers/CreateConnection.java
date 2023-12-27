package databaseHandlers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quantap
 */
import java.sql.DriverManager;
import java.sql.Connection;
//import org.apache.commons.dbcp2.BasicDataSource;


public class CreateConnection {
    String sql_url, sql_db_user, sql_password, data_base;
    public CreateConnection(){
        sql_url = "jdbc:mysql://localhost:3306/";
        sql_db_user = "netUser";
        sql_password = "";
        data_base = "tutorial_db";
    }
    public CreateConnection(String url, String user, String password, String data_base){
        this.sql_url = url;
        this.sql_db_user = user;
        this.sql_password = password;
        this.data_base = data_base;
    }
    public String getUrl(){
        return this.sql_url;
    }
    public String getUser(){
        return this.sql_db_user;
    }
    public String getPassword(){
        return this.sql_password;
    }
    public String getDatabase(){
        return this.data_base;
    }
    public Connection establishConnection(){
        try{
            Connection con = DriverManager.getConnection(getUrl() + getDatabase(), getUser(), getPassword());
            return con;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
