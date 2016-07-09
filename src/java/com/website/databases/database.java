package com.website.databases;

import java.io.Serializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.Session;

public class database extends database_temp{
         
    static database_temp dt1=null;
    
    
    public static database_temp dbObject1() {
        if(dt1==null){
        dt1=new database_temp();
       
        }
         dt1.myconnection();
       return dt1;
            
    }
    

}

