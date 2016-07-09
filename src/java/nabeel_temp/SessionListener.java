/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabeel_temp;

import com.website.databases.DBclass;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author zishan
 */
public class SessionListener implements Serializable, HttpSessionBindingListener {
    
    String user_id = "";

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        user_id = event.getSession().getAttribute("user_id").toString();
        System.out.println("log in");
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        
        DBclass db;
        Connection con = null;
        Statement set = null;
        try {
            db = DBclass.objectCreater();
            con = db.getConnection();
            set = con.createStatement();
            String up = "update on_off set status='0' where user_id='" + user_id + "';";
            System.out.println("log out->>   " + up);
            db.toWrite(up, set);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (set != null) {
                    set.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
