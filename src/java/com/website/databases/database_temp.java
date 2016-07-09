/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import noman_temp.utility;

/**
 *z
 * @author akhtar
 */
public class database_temp implements my_database{
    
    String url,user_name,pass;  
    private static  Statement st = null;
    static database_temp db = null;
    static Connection con=null;
    
    public database_temp()
    {
            utility ut=utility.objectCreator();
            url=ut.utility_reader("db_url");
            user_name=ut.utility_reader("db_user_name");
            pass=ut.utility_reader("db_pass");
   
    }
    
    
    public database_temp my_dbObject() {
               
        if (db == null) {
            db = new database_temp();
        }

        return db;
    }
   public void myconnection()
   {
        try {
            if((con==null)||(con.isClosed()))
            {
                dbconnect();
            }
        } catch (SQLException ex) {
            dbconnect();
        
        }
   }
    
     public void dbconnect(){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver1");
            try {
                 con = DriverManager.getConnection(url,user_name,pass);
                 st = con.createStatement();

            } catch (SQLException abc) {
            }
        } catch (ClassNotFoundException exp) {
        }
       // return st1;
    }

    public ResultSet toRead(String Read, Statement st1) {
        ResultSet result = null;
        try {
            result = st.executeQuery(Read);
            st.clearBatch();

        } catch (SQLException abc) {
            abc.printStackTrace();
        }
        return result;
    }

    public boolean toWrite(String wrt, Statement st1) {
        boolean b = false;
        try {

            b = st.execute(wrt);
            st.clearBatch();
        } catch (SQLException abc) {
            abc.printStackTrace();
        }
        return b;
    }

    public int toUpdate(String upt, Statement st1) {
        int u = 0;
        try {

            u = st.executeUpdate(upt);
            st.clearBatch();
        } catch (SQLException abc) {
        }
        return u;
    }

    public int toDelete(String upt, Statement st1) {
        int m = 0;
        try {
            m = st.executeUpdate(upt);
            st.clearBatch();
        } catch (SQLException abc) {
        }
        return m;
    }
    public void closeConnection(Connection con ,Statement st1)
    {
    
    }
    public Statement connectionCraete()
    {
        return null;
    }
   
    
    
    
    
//    public static void main(String[] args) {
//        database_temp dt=new database_temp();
//        
//    }
//  
//    
    
    
    
    
    
    
}
