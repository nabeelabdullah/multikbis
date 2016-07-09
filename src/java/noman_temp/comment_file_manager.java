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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhtar
 */
public class comment_file_manager {
    static comment_file_manager cfm;
  
    private  String path;//"D:\\MultiKBIS.com";//"/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com";//
    
    comment_file_manager()
    {
        utility ut=utility.objectCreator();
        path=ut.utility_reader("path");
    
    }
   
     public static comment_file_manager  objectCreater()
    {
        if(cfm==null)
            cfm=new comment_file_manager();
    return cfm;
    }
     
    
     
 public String comment_reader(String u_id,String p_id,String c_id)
 {
     file_manager fm=file_manager.objectCreater();
     
     String comment_txt_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"USER_COMMENT"+File.separator+c_id+File.separator+"COMMENT"+File.separator+"comment.text";
     String res=fm.file_reader(comment_txt_path, -1);
     
     return res;
 }
 
 
 public boolean comment_writer(String u_id,String p_id,String c_id,String content)
 {
     file_manager fm=file_manager.objectCreater();
     
     String comment_txt_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"USER_COMMENT"+File.separator+c_id+File.separator+"COMMENT"+File.separator+"comment.text";
     boolean done=fm.String_copy_IntoFlle(comment_txt_path,content);
 
     return done;
 }
   
 
 public void comment_creater(String user_id,String post_id,String comment_id)
 {
        try {
            String comment_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"USER_COMMENT"+File.separator+comment_id+File.separator+"COMMENT";
            String comment_like_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"USER_COMMENT"+File.separator+comment_id+File.separator+"LIKE";
            String comment_attach_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"USER_COMMENT"+File.separator+comment_id+File.separator+"ATTACH";
            File f1=new File(comment_folder);
            File f2=new File(comment_attach_folder);
            File f3=new File(comment_like_folder);
            f1.mkdirs();
            f2.mkdirs();
            f3.mkdirs();
            File f4=new File(comment_folder+File.separator+"comment.text");
            File f5=new File(comment_like_folder+File.separator+"like.text");
            f4.createNewFile();
            f5.createNewFile();
            System.out.println("hiiiiiiiii");
        } catch (IOException ex) {
            Logger.getLogger(comment_file_manager.class.getName()).log(Level.SEVERE, null, ex);
        }

 }
     
 
 
// public static void main(String akhtar[])
//{
//   comment_file_manager cfm=comment_file_manager.objectCreater();
//    //fm.post_creater("UI0000000008", "PI150105aaaaaaaaalu");
//    //cfm.comment_writer("UI0000000008", "PI150107aaaaaaaaae","PI150105aaaaaaaaal123","hi noman accha hai?");
//   cfm.comment_creater("UI0000000009", "PI150112aaaaaaaaab","CII150105aaaaaaaaal123");
//}
//     
}
