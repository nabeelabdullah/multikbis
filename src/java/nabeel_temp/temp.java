/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package folder;

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author akhtar
 */
public class temp {
    public static void main( String[] args )
    {temp t=new temp();
            t.run();
    }
    
    void run()
    {
        try {
            DBclass db=DBclass.objectCreater();
   Connection con=db.getConnection();
   Statement set=con.createStatement();
            String aa="select * from test.temp;";
            ResultSet st =db.toRead(aa,set);
            st.next();
            
            System.out.println(st.getString("name"));
            set.close();
        } catch (SQLException ex) {
           
        }
        
    }
}
