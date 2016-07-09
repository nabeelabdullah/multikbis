package nabeel_temp;

import com.website.mail.SendMail;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import noman_temp.utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zishan
 */
public class takeBcakUP extends TimerTask {

    @Override
    public void run() {
        System.out.println("start");
        try {
            //  String cmd = "mysqldump -u " + "adminurbx1f4" + " " + "-p fUyd2eNbeNmU" + " " + "multikbis" + " -r backup.sql";
            String path = utility.objectCreator().utility_reader("path") + File.separator + "backup" + File.separator + "backup.sql";
            String cmd = "mysqldump -h 127.7.135.2 -P 3306 -u adminaNYnnZn --password=g8rxQLUS6ngL multikbis > " + path;
            System.out.println("cmd   " + cmd);
            System.out.println(System.getProperties());
            Process runtimeProcess = Runtime.getRuntime().exec(cmd);
            InputStream inpit = runtimeProcess.getInputStream();
            int i;
            System.out.print("error Stream is   ");
           
            while ((i = inpit.read()) != -1) {
                System.out.print((char) i);
            }
            
              inpit = runtimeProcess.getErrorStream();
          String m="";
            System.out.println("error Stream is   ");
            while ((i = inpit.read()) != -1) {
                m=m+(char)i;
            }
            System.out.println("error is"+m);
            
            
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup taken successfully");
                SendMail sm = new SendMail();

                sm.sendmail("backup.sql", path, "info.multikbis@gmail.com", "Multikbis Back UP", "Back UP " + Calendar.getInstance().getTime());
            } else {
                System.out.println("Could not take mysql backup");
            }
        } catch (IOException ex) {
            Logger.getLogger(takeBcakUP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(takeBcakUP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
