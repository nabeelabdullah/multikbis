/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author akhtar
 */
public class file_manager {
    private String path;
    static file_manager fm=null;
    boolean done=true;
    
    
    public static file_manager objectCreater()
    {
        if(fm==null)
            fm=new file_manager();
        return fm;
    }

    public file_manager() {
    utility ut=utility.objectCreator();
    path=ut.utility_reader("path");
        System.err.println(path);
    }
    
    public String temp_path(){
        String temp=path+File.separator+"temp";
        File f=new File(temp);
        //system.out.println(f);
        //system.out.println("1");
        if(!f.exists())
        {
             //system.out.println("2");
             f.mkdirs();
            //system.out.println("3");
        }
    return temp;
    }
    
    
    
public void post_creater(String user_id,String post_id)
{
    final  String user_post_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST";
    final  String post_id_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id;
    final  String post_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"POST";
    final  String attach_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"ATTACH";
    final  String like_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"LIKE";
    final  String comment_folder=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator+"USER_COMMENT";
    
    final  String txt=path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"USER_POST"+File.separator+post_id+File.separator;
    File f1=new File(user_post_folder);
    File f2=new File(post_id_folder);
    File f3=new File(post_folder);
    File f4=new File(attach_folder);
    File f5=new File(like_folder);
    File f6=new File(comment_folder);
    
    
    if(!(f1.isDirectory()))
    {   
        
        f1.mkdirs();
        //system.out.println("user_post nahi folder haiiiiiiiiiiiiii");  
    
    }
       
        f2.mkdirs();
        f3.mkdirs();
        f4.mkdirs();
        f5.mkdirs();
        f6.mkdirs();
        File f7=new File(txt+"POST"+File.separator+"post.text");
        File f8=new File(txt+"LIKE"+File.separator+"like.text");
        File f9=new File(txt+"LIKE"+File.separator+"user.text");
        
                try {
                    f7.createNewFile();
                    f8.createNewFile();
                    f9.createNewFile();
                    file_manager fm=file_manager.objectCreater();
                    fm.String_copy_IntoFlle(txt+"LIKE"+File.separator+"like.text",user_id+"$");
                    
                    } catch (IOException ex) {
                    Logger.getLogger(file_manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
        //system.out.println("user post folder bana diya hai");
    
     
}
 
//this method remove the existing data from the file
 public boolean String_copy_IntoFlle(String file_path,String content)
   {
       File file=new File(file_path);
        try {
            FileUtils.writeStringToFile(file, content);
        } catch (IOException ex) {
            done=false;
            Logger.getLogger(file_manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return done;
   }
 
 String file_reader(String path,long content_lenth)
 {
         String content="";
         FileReader fr=null; 
         if(content_lenth==-1)
         {
         content_lenth=50000000;
         }
        try {
                fr=new FileReader(path);
                int i;
                while((i=fr.read())!=-1)
                {
                    content=content+(char)i;
                   if(content.length()>content_lenth)
                   {
                       break;
                   }
                }
                
            } catch (FileNotFoundException ex) {ex.printStackTrace();}
          catch (IOException ex) {ex.printStackTrace();}
      finally{
             try {
                 fr.close();
             } catch (IOException ex) {
                 Logger.getLogger(file_manager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
 return content;
 }
    
 public boolean file_appender(String _path,String content)
 {
     FileWriter fr=null;
        try {
            fr = new FileWriter(_path, true);
            fr.write(content);
            done=true;
       
            } catch (IOException ex) {
                                        done=false;
                                        Logger.getLogger(file_manager.class.getName()).log(Level.SEVERE, null, ex);
                                     } 
                   finally {
                            try {
                                 fr.close();
                                }
                                catch (IOException ex) 
                                {
                                Logger.getLogger(file_manager.class.getName()).log(Level.SEVERE, null, ex);
                                }
                           }
 return  done;
 }
    
// public String folderCopy(String inputpath,String outputpath)
// {
//        FileInputStream fis = null;
//        FileOutputStream fos=null;
//        BufferedInputStream bis=null;
//        int c;
//        
//        try {
//            fis = new FileInputStream(inputpath);
//            fos=new FileOutputStream(outputpath);
//            bis=new BufferedInputStream(fis);
//            while ((c=(char)bis.read())!=-1)
//            {
//             fos.write(c);
//            }
//            
//        } catch (FileNotFoundException ex) {}catch(IOException io){}
//         finally {
//                    try {
//                        fis.close();
//                        fos.close();
//                        bis.close();
//                        } catch (IOException ex) {}
//                  }
//        return  null;
// }
 

//public static void main(String akhtar[])
//{
////    file_manager fm=file_manager.objectCreater();
////   // fm.post_creater("UI0000000008", "PI150105aaaaaaaaaa");
////    //fm.String_copy_IntoFlle("D:\\a.text", "k00000000000");
////    fm.folderCopy("D:\\MultiKBIS.com\\temp\\UI0000000017\\149425","D:\\MultiKBIS.com\\temp\\a");
////    //system.out.println(fm.temp_path());
//}
}
