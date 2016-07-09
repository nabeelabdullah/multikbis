/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package noman_temp;

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhtar
 */
public class get_max_id {
    
   static get_max_id mx;
   public get_max_id(){} 
   public static  get_max_id Object_creator(){
    if(mx==null)
        mx=new get_max_id();
    return mx;
    
    }
  
    public String get_max_id_creator(String table,String id_name)
    {
        String id_is=null;
       try {
           DBclass db=DBclass.objectCreater();
                    Connection con=db.getConnection();
                    Statement set=con.createStatement();
           
           String query="select max("+id_name+") from "+table+";";
           ResultSet rs=db.toRead(query,set);
           try{
           rs.next();
           id_is=rs.getString("max("+id_name+")");
           //set.close();
           }
           catch(SQLException sq)
           {
           sq.printStackTrace();
          
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(get_max_id.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return id_is;
        }
        
        
        
    
    
    }
    
    
    
    
    
    

