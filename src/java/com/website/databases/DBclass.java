package com.website.databases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import noman_temp.utility;
import org.apache.commons.dbcp.BasicDataSource;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NABEEL
 */
public class DBclass {

    private static BasicDataSource connectionPool;
    static DBclass db = null;
    static boolean oneTime = true;
    String user_name=null,pass=null,url=null;

    public static DBclass objectCreater() {
        if (db == null) {
            db = new DBclass();
           
            db.createConnection();
        }

        return db;
    }

    private DBclass() {
            utility ut=utility.objectCreator();
            url=ut.utility_reader("db_url");
            user_name=ut.utility_reader("db_user_name");
            pass=ut.utility_reader("db_pass");
    }

    private void createConnection() {
        if (oneTime) {
            String dbUrl =url;
            connectionPool = new BasicDataSource();
            connectionPool.setUsername(user_name);
            connectionPool.setPassword(pass);
            connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
            connectionPool.setUrl(dbUrl);
            connectionPool.setMaxIdle(10);
            connectionPool.setMinIdle(6);
            connectionPool.setTestOnBorrow(true);
            connectionPool.setRemoveAbandoned(true);
            connectionPool.setRemoveAbandonedTimeout(10);
            connectionPool.setValidationQuery("select 1;");
            connectionPool.setInitialSize(10);
            oneTime = false;
            System.out.println("connection created");

        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();

        } catch (SQLException ex) {

        }
        return connection;
    }

    public ResultSet toRead(String Read, Statement st) {
        ResultSet result = null;
        try {
            result = st.executeQuery(Read);
            st.clearBatch();

        } catch (SQLException abc) {
            System.out.println(abc);
            abc.printStackTrace();
        }
        return result;
    }

    public boolean toWrite(String wrt, Statement st) {
        boolean b = false;
        try {

            b = st.execute(wrt);
            st.clearBatch();
        } catch (SQLException abc) {
            abc.printStackTrace();
        }
        return b;
    }

    public int toUpdate(String upt, Statement st) {
        int u = 0;
        try {

            u = st.executeUpdate(upt);
            st.clearBatch();
        } catch (SQLException abc) {
        }
        return u;
    }

    public int toDelete(String upt, Statement st) {
        int m = 0;
        try {
            m = st.executeUpdate(upt);
            st.clearBatch();
        } catch (SQLException abc) {
        }
        return m;
    }

}
