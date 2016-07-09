/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabeel_temp;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import noman_temp.utility;

public class PathCreater {

    utility ut = utility.objectCreator();
    private final String path = ut.utility_reader("path");
    static PathCreater pc = null;

    public static PathCreater objectCreater() {
        if (pc == null) {
            pc = new PathCreater();
        }
        return pc;
    }

    private PathCreater() {
    }

    public String questionPathCreater(String g_id, String q_id) {

        return path + File.separator + "group" + File.separator + g_id + File.separator + "Question" + File.separator + q_id;
    }

    public String answerPathCreater(String g_id, String a_id) {

        return path + File.separator + "group" + File.separator + g_id + File.separator + "Answer" + File.separator + a_id;
    }

    public boolean preresume(String id) {
        String m = path + File.separator + "MEMBER" + File.separator + id + File.separator + "resume" + File.separator + "resume.pdf";
        File f = new File(m);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String resumepathcreater(String id) {
        String m = "";
        try {
            m = path + File.separator + "MEMBER" + File.separator + id + File.separator + "resume";//+File.separator+"resume.pdf";
            File file = new File(m);
            if (!file.exists()) {
                file.mkdirs();
            }
            m = m + File.separator + "resume.pdf";
            file = new File(m);
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException ex) {
            Logger.getLogger(PathCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    public String profilePicsPathCreater(String M_id) {

        String m = path + File.separator + "MEMBER" + File.separator + M_id + File.separator + "profile" + File.separator + "profile.jpg";
        File file=new File(m);
        if(!file.exists())
            m=path+File.separator+"default/default.jpg";
        return m;
    }

    public String requestPathCreater(String g_id, String r_id) {

        return path + File.separator + "group" + File.separator + g_id + File.separator + "Request" + File.separator + r_id;
    }

    public String forfileupload(String M_id) {
        String m = path + File.separator + "MEMBER" + File.separator + M_id + File.separator + "profile";//+File.separator;
        File f = new File(m);
        f.mkdirs();
        m = m + File.separator;
        return m;
    }

    public void userfoldercreater(String M_id) {
        String m = path + File.separator + "MEMBER" + File.separator + M_id;
        File f = new File(m);
        f.mkdirs();
    }

    public String forMailpathcreater(String M_id) {
        String m = path + File.separator + "MEMBER" + File.separator + M_id + File.separator + "formail";//+File.separator;
        File f = new File(m);
        if (!f.exists()) {
            f.mkdirs();
        }
        m = m + File.separator;
        return m;

    }

}
