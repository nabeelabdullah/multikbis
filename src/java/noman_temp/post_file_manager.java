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

/**
 *
 * @author akhtar
 */
public class post_file_manager extends file_manager{
    static post_file_manager pfm;
    private  String Path;
    
  private   post_file_manager()
    {
     utility ut=utility.objectCreator();
     Path=ut.utility_reader("path");
     //System.err.println(path);
    }
  
     public static post_file_manager objectCreater()
    {
        if(pfm==null)
            pfm=new post_file_manager();
        return pfm;
    }
     
     
     
    public boolean new_post_copy(String u_id,String p_id,String content)
    {
        String post_txt_path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"POST"+File.separator+"post.text";
        file_manager fm=new file_manager();
        boolean b=fm.String_copy_IntoFlle(post_txt_path,content);
    return b;
    }
    
    
    
    
    public String post_reader(String u_id,String p_id)
    {
        String post_txt_path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"POST"+File.separator+"post.text";
        file_manager fm=file_manager.objectCreater();
        String result=fm.file_reader(post_txt_path,350);
    return result;
    }
    
    public String full_post_reader(String u_id,String p_id)
    {
        String post_txt_path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"POST"+File.separator+"post.text";
        file_manager fm=file_manager.objectCreater();
        String result=fm.file_reader(post_txt_path,-1);
    return result;
    }
    
   
    
    public String attachPath(String u_id,String p_id)
    {
        String attach_path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"ATTACH";
        return attach_path;
    
    }
public String returnAttachPath(String u_id,String p_id,String param)
    {
        String path=null;
        if(param.equals("1"))
        path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"ATTACH"+File.separator+"first";
        else
        {
            if(param.equals("2"))
                path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"ATTACH"+File.separator+"second";
        }
            return path;
    
    }
    
    public String return_profile_img_path(String u_id)
    {
    String profile_img_path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"profile";//File.separator+"small.jpg";
    return profile_img_path;
    }
    
    
    public boolean delete_post(String u_id,String p_id)
    {
        boolean b=false;
    String post_txt_path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id;
    b=recursiveDelete(new File(post_txt_path));
       return b;
    }
    
// public String folderCopy(String inputpath,String outputpath) //un used
// {
//        FileInputStream fis = null;
//        FileOutputStream fos=null;
//        BufferedInputStream bis=null;
//        FileReader fr=null;
//        FileWriter fw=null;
//        int c;
//        
//        try {
////            fis = new FileInputStream(inputpath);
////            fos=new FileOutputStream(outputpath);
////            bis=new BufferedInputStream(fis);
//            fr=new FileReader(inputpath);
//            fw=new FileWriter(outputpath);
//            while ((c=fr.read())!=-1)
//            {
//             fw.write(c);
//            }
//            
//            } catch (FileNotFoundException ex) {}catch(IOException io){}
//         finally {
//                    try {
//                        fis.close();
//                        fos.close();
//                        bis.close();
//                        
//                        fr.close();
//                        fw.close();
//                        } catch (IOException ex) {}
//                  }
//        return  null;
// }
// 
    
   
     
    public boolean recursiveDelete(File file) {
        //to end the recursive loop
        if (!file.exists())
            return false ;
         
        //if directory, go inside and call recursively
        if (file.isDirectory()) 
        {
            for (File f :file.listFiles())
            {
                //call recursively
                recursiveDelete(f);
            }
        }
        //call delete to delete files and empty directory
        file.delete();
        return true;
        ////system.out.println("Deleted file/folder: "+file.getAbsolutePath());
    }
 public boolean fileDelete(String u_id,String p_id, String name) 
 {
        boolean status=false;
        String path=Path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_POST"+File.separator+p_id+File.separator+"ATTACH";
        File f2=null;
        File f3=new File(path+File.separator+"first");
        
        if(name.equals("1"))
        {
            name="first";
        f2=new File(path+File.separator+"second");
        }
        else 
        {
            name="second";
        f2=new File(path+File.separator+"first");
        }
        File f1=new File(path+File.separator+name);
      
        if (!f1.exists())
        {
            System.err.println("exist not ");
            status=false;
        }
        else
        {
         f1.delete();
         f2.renameTo(f3);
        status=true;
        }
        return status;
    }

//    
/*public static void main(String akhtar[])
{
    post_file_manager pfm=post_file_manager.objectCreater();
//    pfm.folderCopy("D:\\Multikbis.com\\temp\\UI0000000017\\130503.mp4", "D:\\Multikbis.com\\MEMBER\\UI0000000017\\USER_POST\\PI150629aaaaaaaaaw\\ATTACH");
//    //system.out.println(pfm.delete_post("UI0000000008", "PI150125aaaaaaaaaa"));
//    pfm.new_post_copy("UI0000000008",  "PI150105aaaaaaaaalu","hiiiiiiii noman how r y?");
//    //system.out.println(list[i].substring(0,v));
    pfm.fileDelete("UI0000000017","PI150702aaaaaaaaaa","2");
}
* */

    
}
