/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import com.website.databases.database;
import com.website.databases.my_database;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author akhtar
 */
public class like_post_file_manager {
    static like_post_file_manager pfm;
    private  String path;//="D:\\MultiKBIS.com";//"/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com";//
    
    like_post_file_manager()
    {
     utility ut=utility.objectCreator();
     path=ut.utility_reader("path");
//        System.err.println(path);
    }
   
     public static like_post_file_manager objectCreater()
    {
        if(pfm==null)
            pfm=new like_post_file_manager();
    return pfm;
    }
     
    
    
    
    
    
    
     public boolean like_setter(String u_id,String p_id,String user_id,String user_name)
    {
    boolean b2=false;
    file_manager fm=file_manager.objectCreater();
    String like_txt_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"LIKE"+File.separator+"like.text";
    String user_txt_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"LIKE"+File.separator+"user.text";
    user_id=user_id+"$";
    user_name=user_name+",";
    boolean b1=fm.file_appender(like_txt_path, user_id);
    if(b1)
        {
            b2=fm.file_appender(user_txt_path, user_name);
            
        }
    return b2;
    }
     
     
     public boolean like_validater(String u_id,String p_id,String user_id)
     {
         
         String matter=new String();
         String like_txt_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"LIKE"+File.separator+"like.text";
         user_id=user_id+"$";
         FileReader fr=null;
         boolean tj=false;
         try{
                fr=new FileReader(like_txt_path);
                char k;
                int l;
                while((l=fr.read())!=-1)
                {
                    k=(char)l;
                    matter=matter+k;
                    if(k=='$')
                    {
                    
                        int h=user_id.compareToIgnoreCase(matter);
                        if(h==0)
                        {
                          tj=true;
                       // System.out.println("milla");
                        break;
                        }
                    matter="";
                    }
                    
                    
                }
//                if(tj==false)
//                {
//                 System.out.println("nahi mila");
//                }
//                
                
                
            }catch(IOException io){io.printStackTrace();} 
      
         finally{
                    try {
                         fr.close();
                        } catch (Exception e) { e.printStackTrace();}
                  
                }
     return tj;
     }
     
     public  String get_postlike_user_name(String u_id,String p_id)
     {
         String user_txt_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"LIKE"+File.separator+"user.text";
         file_manager fm=file_manager.objectCreater();
         String matter=fm.file_reader(user_txt_path,-1);
          
          return matter;
     }
     
     
     
// public static void main(String akhtar[])
//{
//like_post_file_manager lfm=like_post_file_manager.objectCreater();
//String h=lfm.get_postlike_user_name("UI0000000008","PI150117aaaaaaaaaa");
//System.out.println(h);
////fm.String_copy_IntoFlle("D:\\a.text", "k00000000000");
//}
     
     
     
     
     
     
}
