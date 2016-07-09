/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabeel_temp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import noman_temp.utility;

/**
 *
 * @author NABEEL
 */
public class DefaoulImageCreater {
//    public static  void main(String as[])
//    {
////        DefaoulImageCreater d=new DefaoulImageCreater();
////        d.defaultImageCreater("female", "UI0000000002");
//    }

    public void defaultImageCreater(String gender, String M_id) {
        utility ut=utility.objectCreator();
        String path=ut.utility_reader("path");
        String m=path+File.separator+"MEMBER"+File.separator+M_id+File.separator+"profile";
        File f=new File(m);
        f.mkdirs();
        m=m+File.separator+"profile.jpg";
      
        
        FileInputStream fin = null;
        
        FileOutputStream fout = null;
         String dp=null;
         if(gender.equals("male"))
             dp=path+File.separator+"default"+File.separator+"male.jpg";
         if(gender.equals("female"))
             dp=path+File.separator+"default"+File.separator+"female.jpg";
        try {
            File f1 = new File(m);
            File f2=new File(dp);
            fin = new FileInputStream(f2);
            fout=new FileOutputStream(f1);
            
          int i=0;
          while((i=fin.read())!=-1){
          fout.write(i);
          }
        } catch (FileNotFoundException ex) {
          
        }
        catch(IOException ex){}
        finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(DefaoulImageCreater.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
