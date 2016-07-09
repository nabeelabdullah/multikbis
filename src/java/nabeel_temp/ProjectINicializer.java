package nabeel_temp;


import java.util.Timer;
import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zishan
 */
public class ProjectINicializer implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       Timer time = new Timer();
       takeBcakUP tc = new takeBcakUP();
       time.schedule(tc, 5000, 86400000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
