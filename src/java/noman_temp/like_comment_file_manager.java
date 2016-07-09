/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author akhtar
 */
public class like_comment_file_manager {
     static like_comment_file_manager lcfm;
    private  String path;//="D:\\MultiKBIS.com";//"/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com";//
    
    like_comment_file_manager()
    {
     utility ut=utility.objectCreator();
     path=ut.utility_reader("path");
//        System.err.println(path);
    }
   
     public static like_comment_file_manager objectCreater()
    {
        if(lcfm==null)
            lcfm=new like_comment_file_manager();
    return lcfm;
    }
    
     
    public boolean like_comment_setter(String u_id,String p_id,String c_id,String user_id)
    {
    file_manager fm=file_manager.objectCreater();
    String like_comment_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"USER_COMMENT"+File.separator+c_id+File.separator+"LIKE"+File.separator+"like.text";
    user_id=user_id+"$";
    boolean b=fm.file_appender(like_comment_path, user_id);
    return b;
    }
    

    
    
    
    
    
    public boolean like_comment_validater(String u_id,String p_id,String c_id,String user_id)
     {
         
         String matter=new String();
         String like_comment_path=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"USER_COMMENT"+File.separator+c_id+File.separator+"LIKE"+File.separator+"like.text";
         user_id=user_id+"$";
         FileReader fr=null;
         boolean tj=false;
         try{
                fr=new FileReader(like_comment_path);
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
                        System.out.println("yes");
                        break;
                        }
                    matter="";
                    }
                    
                    
                }
//                if(tj==false)
//                {
//                 System.out.println("nnnnnnnnaaaaaaaaaahhhhiiiiiii mila");
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
    
    
    
    
    
//        
//     public static void main(String akhtar[])
//{
//   like_comment_file_manager lfm=like_comment_file_manager.objectCreater();
//    System.out.println(lfm.like_comment_validater("UI0000000008", "PI150113aaaaaaaaaa","CI150113aaaaaaaaab","UI0000000008"));
//    //fm.String_copy_IntoFlle("D:\\a.text", "k00000000000");
//}
    
    
    
    
}
