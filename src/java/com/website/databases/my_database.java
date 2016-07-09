/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author akhtar
 */
 
 public interface my_database {
     
// public void akhtar();
 public database_temp my_dbObject();
 public void dbconnect();
 public ResultSet toRead(String Read,Statement st1);
 public boolean toWrite(String wrt, Statement st1) ;
 public int toUpdate(String upt, Statement st1);
 public int toDelete(String upt, Statement st1);
 public void closeConnection(Connection con , Statement st1);
 public Statement connectionCraete();

 }
