/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package noman_temp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import nabeel_temp.groupWork;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author akhtar
 */
public class file_handle {
    
    
public static void main(String ff[])
{
    file_handle h=objectCreater();
    
}
  
    private final String path="D:\\MultiKBIS.com";//"/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com";//
    static file_handle fh=null;
    public static file_handle objectCreater()
    {
        if(fh==null)
            fh=new file_handle();
        return fh;
    }
    
   public  String fileReplacerForDB(String path)
   {
    path= path.replaceAll(Matcher.quoteReplacement(File.separator),"---");
    return path;
   }
     
     
      
   public String fileReplacer(String path)
   {
    path= path.replaceAll("---",Matcher.quoteReplacement(File.separator));
    return path;
   }
   
   public void insert_intoFile(String path,String value)
    {
     File file=new File(path);
    
     FileInputStream fin;
     FileOutputStream fout;
        try {
      
            fin=new FileInputStream(file);
            
            int i;
            String m="";
            while ((i = fin.read()) != -1)
            {
                
                m = m + (new Character((char) i)).toString();
                
            }
          //  m = m.replace(m.substring(m.length()-1), "");
           
            m=m+" "+value;
            
            FileUtils.writeStringToFile(file, m);
            } 
              catch (FileNotFoundException ex) {}
              catch (IOException ex) {}
        
     
    }
    
   public void postfoldercreater(String user_id,String post_id)
{
    String m=  path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"user_post"+File.separator+post_id;
    System.out.println(m);
    File f=new File(m);
    f.mkdirs();
}
   public String postfolderpathcreater(String user_id,String post_id)
   {
       return  path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"user_post"+File.separator+post_id+File.separator+"post";
   
   }
   
   
   public String postattachpathcreater(String user_id,String post_id,String name)
   {
       return  path+File.separator+"MEMBER"+File.separator+user_id+File.separator+"user_post"+File.separator+post_id+File.separator+name;
   }
   
    public boolean copyIntoFlle(String f,String m)
   {
       boolean done=true;
       File file=new File(f);
       
        try {
            FileUtils.writeStringToFile(file, m);
        } catch (IOException ex) {
            done=false;
            Logger.getLogger(groupWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        return done;
   }
    
    public String contentInFile(String url)
      {  
          String content="";
          File f=new File(url);
         
        try {
            
            FileInputStream fin=new FileInputStream(f);
            int i;
            while((i=fin.read())!=-1)
            {
                content=content+(char)i;
               
            }
        } catch (FileNotFoundException ex) {
           
        }
        catch (IOException ex) {
           
        }
        
          
          return content;
      }
  
    public String contentInFile_post_decrease(String url)  // call on search jsp
      {  
          String content="";
          File f=new File(url);
         
        try {
            
            FileInputStream fin=new FileInputStream(f);
            int i;
            int j=0;
            while((i=fin.read())!=-1)
            {
                
                content=content+(char)i;
               if(content.length()>480)
               {
                   //System.out.println("***********************************************************************");
                   //content=content+".....";
                   
                   break;
               }
            }
        } catch (FileNotFoundException ex) {
           
        }
        catch (IOException ex) {
           
        }
        
          
          return content;
      }
  public String profilePicsPathCreater(String M_id)
{
    
    String m= path+File.separator+"MEMBER"+File.separator+M_id+File.separator+"profile"+File.separator+"profile.jpg";
    
   
    return m;
}
    
}
