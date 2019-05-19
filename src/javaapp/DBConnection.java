/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Easy
 */
public class DBConnection {
    private Connection DBConnection;
    public Connection connect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Success");            
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Driver not found" + cnfe);
        }        
        String url="jdbc:mysql://192.168.1.172:3306/wbeducar_java";        
        try{
          DBConnection=DriverManager.getConnection(url,"apps_db","apps_db");
          System.out.println("Database Connected");
        }
        catch(SQLException se){
          System.out.println("Database Not Found");  
        }
        return DBConnection;
        
 
        
        
    }
    
}
