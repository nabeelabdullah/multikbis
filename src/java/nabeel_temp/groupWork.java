/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabeel_temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import org.apache.commons.io.FileUtils;

public class groupWork {
    int dayy,monthh,yearr;
    static groupWork gw=null;
   public static groupWork objectCreater()
    {
        if(gw==null)
        {
            gw=new groupWork();
        }
        return gw;
    }
    
    private groupWork(){}

    public static void main(String m[]) {
    //    try 
        {
            int i = 12;
            
            groupWork g = new groupWork();
            g.filelocation();
        
   }
    }
    {
    }

    public boolean is_Exist(String file_path, String value) {
        boolean is_exit = false;
        File file = new File(file_path);
        if(file.exists()){
            
        System.out.println(file);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
  
        } catch (FileNotFoundException ex) {
              
            ex.printStackTrace();
              
        }

        try {
            String m = "";
            int i;
            while ((i = fin.read()) != -1) {
               
                if ((char) i != ' ') {
                    m = m + (new Character((char) i)).toString();
                } else {

                    if (m.equals(value)) {

                        is_exit = true;
                        break;
                    }
                   m = "";
                }
            }
            if(is_exit==false){
                // m = m.replace(m.substring(m.length()-1), "");  /*<- windows me comment but linux me no comment */
            
            if(m.equals(value))
            {
                is_exit = true;
            }
            }
            fin.close();
        } catch (IOException ex) {
            System.out.println(ex);

        }
        }
        return is_exit;
        
    }
    
    public void insert_intoFile(String path,String value)
    {
     File file=new File(path);
     FileInputStream fin;
    
        try {
            fin=new FileInputStream(file);
        
            int i;
            String m="";
            while ((i = fin.read()) != -1)
            {
                
                m = m + (new Character((char) i)).toString();
                
            }
            m = m.replace(m.substring(m.length()-1), "");
           
            m=m+" "+value;
            
            FileUtils.writeStringToFile(file, m);
            fin.close();
           
            } 
              catch (FileNotFoundException ex) {}
              catch (IOException ex) {}
        
     
    }
    int date_differnce(int olddate,int newdate)
    {
       
        return 0;
    }
    
   public boolean checkr(List<String> li,String id )
    {
        boolean find=false;

   for(String s:li)
   {
       if(s.equals(id))
       find=true;
   }
     return find;
    
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
            fin.close();
        } catch (FileNotFoundException ex) {
           
        }
        catch (IOException ex) {
           
        }
        
          
          return content;
      }
   public   void daybefore(int day,int month,int year)
      {   int daybefor=3;
          int oday,omonth,oyear;
          if(day>daybefor)
          {
              oday=day-daybefor;
              omonth=month;
              oyear=year;
          }
          else if(month>1)
          {
              int x=dayinmonth(month-1);
              oday=x+day-daybefor;
              omonth=month-1;
              oyear=year;
          }
          else
          {
              oday=day+31-daybefor;
              omonth=month%12;
              oyear=year-1;
          }
          dayy=oday;
          monthh=omonth;
          yearr=oyear;
         // return oday+" "+omonth+" "+oyear;
      }
   int dayinmonth(int m)
   { int day=0;
      if((m==1)||(m==3)||(m==5)||(m==7)||(m==8)||(m==10)||(m==12))
      {
          day=31;
      }
      else if(m==2)
          day=28;
      else 
          day=30;
      return day;
   }
   public int day()
   {
       return dayy;
   }
   public int month()
   {
       return monthh;
   }
   public int year()
   {
       return yearr;
   }
   
   public String fileReplacer(String path)
   {
    path= path.replaceAll("---",Matcher.quoteReplacement(File.separator));
    return path;
   }
   public String fileReplacerForDB(String path)
   {
    path= path.replaceAll(Matcher.quoteReplacement(File.separator),"---");
    return path;
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
   public void fileDelete(String url)
   {
       File f=new File(url);
       boolean delete = f.delete();
   }
   
   void filelocation()
   {
      System.out.println();
   }
   }
  

