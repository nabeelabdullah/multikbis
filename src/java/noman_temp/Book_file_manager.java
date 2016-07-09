/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhtar
 */
public class Book_file_manager {
    
    private String path;
    static Book_file_manager bfm=null;
    
    
    
    public static Book_file_manager objectCreater()
    {
        if(bfm==null)
            bfm=new Book_file_manager();
        return bfm;
    }

    public Book_file_manager() {
    utility ut=utility.objectCreator();
    path=ut.utility_reader("path");
        
    }
    
  public  boolean book_creator(String u_id,String b_id)
    {
        boolean done=false;
        final  String user_book_folder=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_BOOK";
        final  String user_book_attach=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_BOOK"+File.separator+b_id+File.separator+"ATTACH";
        
        File f1=new File(user_book_folder);
        File f2=new File(user_book_attach);
        if(!f1.exists())
        {
        f1.mkdirs();
        done=true;
        }
        if(!f2.exists())
        {
           f2.mkdirs(); 
           done=true;
        }
            
           return done;
    }
    
    public String return_book_attach(String u_id,String b_id)
    {
        final  String user_book_attach=path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"USER_BOOK"+File.separator+b_id+File.separator+"ATTACH"+File.separator;
        
        return user_book_attach;
    
    }
    
    public boolean book_image_copy(String target)
    {    
        boolean b=false;
        BufferedOutputStream bo=null;
        BufferedInputStream bi=null;
        FileOutputStream fos=null;
        FileInputStream fis=null;
        String p=target;
        try{
        for(int j=0;j<4;j++)
        {       
                fis=new FileInputStream(path+File.separator+"default/book.jpg");
                bi=new BufferedInputStream(fis,1024);
                fos=new FileOutputStream(p+j);
                bo=new BufferedOutputStream(fos,1024);
                int i;
                while((i=bi.read())!=-1)
                {
                bo.write(i);
                }
                bo.flush();
                bo.close();
                bi.close();
                fos.close();
                fis.close();
              
        }
        b=true;
        
        }catch(IOException io){ io.printStackTrace();}
        finally{
            try {
                fis.close();
                fos.close();
                bi.close();
                bo.close();
            } catch (IOException ex) {
                Logger.getLogger(Book_file_manager.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
        
        return b;
    }
    
    
//    public static  void main(String akhtar[])
//    {
//    Book_file_manager bfm=Book_file_manager.objectCreater();
//    bfm.book_image_copy("D:");
//    }
}
