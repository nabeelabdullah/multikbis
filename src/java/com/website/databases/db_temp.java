package com.website.databases;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import noman_temp.utility;

/**
 *
 * @author akhtar
 */
public class db_temp {

    private static  Statement st = null;
    static db_temp db = null;
    static Connection con=null;
    private String url,user_name,pass;
    
    public static db_temp objectCreater1()
    {
    if(db==null)
        db=new db_temp();
    return db;
    }
    
    
   private db_temp(){
         utility ut=utility.objectCreator();
        try {
            url = ut.utility_reader("db_url");//"jdbc:mysql://localhost:3306/mkbis_iu_dbms";//"jdbc:mysql://127.9.41.130:3306/mkbis_iu_dbms";//
            user_name= ut.utility_reader("db_user_name");
            pass = ut.utility_reader("db_pass");
            Class.forName("com.mysql.jdbc.Driver123");
            try {
                 con = DriverManager.getConnection(url,user_name,pass);//"admintTyuhNE", "ir-HN-szz_H2");
                st = con.createStatement();

            } catch (SQLException abc) {
            }
        } catch (ClassNotFoundException exp) {
        }
       // return st1;
    }

    public ResultSet toRead(String Read) {
        ResultSet result = null;
        try {
            result = st.executeQuery(Read);
            st.clearBatch();

        } catch (SQLException abc) {
            abc.printStackTrace();
        }
        return result;
    } 

}
