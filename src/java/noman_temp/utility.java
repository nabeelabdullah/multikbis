/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author akhtar
 */
public class utility {

    static utility ut;

    //   File f=new File("/home/zishan/Music/data/MultiKBIS.com/ATTRIBUTE.txt");
   // private final String path = "/var/lib/openshift/5641bb2c7628e1242d0000b6/app-root/data/MultiKBIS.com/ATTRIBUTE.txt";//"/home/zishan/Music/data/MultiKBIS.com/ATTRIBUTE.txt";//
     private final String path = "/home/zishan/Music/data/MultiKBIS.com/ATTRIBUTE.txt";
    public static utility objectCreator() {
        if (ut == null) {
            ut = new utility();
        }
        return ut;
    }

    public String utility_reader(String matter) {
        matter = matter + "=";
        matter = "{" + matter;
        String temp = new String("");
        String res = new String("");
        int i, k;
        char z;
        FileReader fr;
        try {
            fr = new FileReader(path);
            while ((i = fr.read()) != -1) {
                z = (char) i;
                temp = temp + z;
                temp = temp.trim();

                if (z == '=') {
                    k = matter.compareToIgnoreCase(temp);
                    if (k == 0) {
                        while ((i = fr.read()) != '}') {

                            res = res + (char) i;
                        }
                        break;
                    } else {
                        temp = "";
                        while ((i = fr.read()) != '}') {
                        }
                    }
                }

            }
            fr.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;

    }

//    
//public static void main(String akhtar[])
//{
//    utility ut=utility.objectCreator();
//    System.err.println(ut.utility_reader("db_url"));
//    System.err.println(ut.utility_reader("db_user_name"));
//    System.err.println(ut.utility_reader("db_pass"));
//}
}
