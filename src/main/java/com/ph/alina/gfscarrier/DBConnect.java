/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ph.alina.gfscarrier;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/GFSCarrier_development";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   Connection connection = null;
   Statement statement = null;
   public void connect(){
       
    try{   
       Class.forName(JDBC_DRIVER);
       
       connection = DriverManager
		.getConnection(DB_URL,USER, PASS);
       
       statement = connection.createStatement(); 
       
    }catch(Exception e){
        e.printStackTrace();
    }

 
   }
   
   
    public boolean insertAccessToken(String accesstoken, String msisdn){
        
       try {
           
           if(statement != null){
                String insertScript = "INSERT INTO ACCESS_TOKEN VALUES ('" + accesstoken + "','" + msisdn + "')";
                statement.execute(insertScript);
           }
           return true;
       } catch (SQLException ex) {
           Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       }
   }
   
   public void closeConnection(){
       
       try {
           connection.close();
       } catch (SQLException ex) {
           Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   
}
   
  


