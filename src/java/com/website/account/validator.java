package com.website.account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
// *
 * @author akhtar
 */

import com.website.databases.DBclass;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validator{
ResultSet rs;
DBclass db;
Connection con;
Statement set;
    
    
    
    
  static validator vn=null;
    public static validator objectCreator()
    {
    if(vn==null)
        vn=new validator();
    return vn;
    }
  
    

   
public int firstnameValidator(String first) {
         int i=0;
     if(first.equals(""))
     {
         i=10;
     }
     else
     {
                for(int k=0;k<first.length();k++)
                {
                   
                    char t=first.charAt(k);
                      if(t>64 && t<91 || t>96&&t<123)
                      {
                          i=1;
                         
                      }
                      else
                      {
                          i=0;
                          break;
                      }
                }
        
     }
     
     return i;
    }

  public int lastnameValidator(String last) 
    {
         int i=0;
     if(last.equals(""))
     {
         i=10;
     }
     else
     {
                for(int k=0;k<last.length();k++)
                {
                   
                    char t=last.charAt(k);
                      if(t>64 && t<91 || t>96&&t<123)
                      {
                          i=1;
                       
                      }
                      else
                      {
                           
                          i=0;
                          break;
                      }
                }
        
     }
     
     return i;
    }
  
    

  public  int emailValidator(String email) {
        int i=30;
        String getemail=null;
        
        if(email.equals(""))
        {
           
            i=10;   //email is null
        }
        
        else
        {
                email=email.trim();
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(email);
                boolean matchFound = m.matches();
                if (matchFound)
                {

                    try{
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set = con.createStatement();
                           String quary = "select EMAIL from user_login where EMAIL='"+email+"';";
                           rs = db.toRead(quary,set);

                                   if(rs.isBeforeFirst())
                                   {
                                    i = 0;    //present
                                   }
                                   else
                                   {
                                     i = 1;   
                                   }
                       } catch (SQLException ex) {} 
                        finally {   
                            try {
                                con.close();
                                set.close();
                                rs.close();
                                 } catch (SQLException ex) {}
                                 }      

                       
                }
                
                else
                {
                    i=20;
                }//pattern not found
                
                
        }//end of else
        return i;
    }

   public int mobileValidator(String mob)
    {   int i;
        if(mob.equals(""))
        {i=10;
        }
        else{
            mob=mob.trim();
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(mob);
        boolean matchFound = m.matches();

        if (matchFound)
        {
            
            {i=1;}
        }
        else
        {i=10;}
    
        }
    
    return i;
    }
 
  
 //institute
 public int instituteValidator(String institute) 
 {
     int i=0;
     if(institute.equals(""))
     {
         i=10;
     }
     else
     {
                for(int k=0;k<institute.length();k++)
                {
                   
                    char t=institute.charAt(k);
                      if(t>64 && t<91 || t>96&&t<123 ||t==32)
                      {
                          i=1;
                          System.out.println("hi");
                      }
                      else
                      {
                           System.out.println("for");
                          i=0;
                          break;
                      }
                }
        
     }
     
     return i;
    }

    //pass
  public  int passwordValidator(String pass,String repass)
    {
        int i=10;
        if(pass==""||repass=="")
        {
        return 10;
        }
        else
        {
                if(pass.equals(repass))
                {
                  i=1;
                }
        }
       return i;
       
    }
 
  public  int dobValidator(String day,String month,String year)
    { 
        int i;
    day=day.trim();
    month=month.trim();
    year=year.trim();
        if(day.equals("day")||month.equals("month")||year.equals("year"))
        {
            i=10;
        }
        else
        {
            i=1;
        }
    return i;
    }
    //gender
    
 public   int genderValidator(String gender)
    {
        int i;
    gender=gender.trim();
        if(gender.equals(""))
        {
            i=10;
        }
    
        else{
            i=1;
            }
    return i;
    }
    
    
    
//    public static void main(String s[])
//    {
//    validator v=new validator();
//    System.out.println(v.lastnameValidator("nomanakhtar"));
//    }
//    
    
    
 //   public int lastnameValidator(String last) 
//    {
//        int i;
//    
//     if(last.equals(""))
//     {i=10;}
//     
//     else{
//     last=last.trim();
//     Pattern p = Pattern.compile("[^[a-z]*|^[A-Z]]*[a-z]*|[A-Z]*[a-zA-Z]*&");
//     Matcher m = p.matcher(last);
//      boolean matchFound = m.matches();
//        if (matchFound ) 
//         {i=1;}
//        else{i=0;}
//         }
//     
//     return i;
//}     
    
      //city

//public int citynameValidator(String city) {
//     int i;
//    
//     if(city.equals(""))
//     {i=10;}
//     
//     else{
//     city=city.trim();
//     Pattern p = Pattern.compile("[^[a-z]*|^[A-Z]]*/*[a-z]*|[A-Z]*/*[a-zA-Z]*&/*");
//     Matcher m = p.matcher(city);
//      boolean matchFound = m.matches();
//        if (matchFound ) 
//         {i=1;}
//        else{i=0;}
//         }
//     
//     return i;
//    }
//   
    
//    public String idgenrator(String dbid) {
//        String ss="aaaaaaaaac";
////        StringBuilder sb=new StringBuilder();
//        //System.out.println("split is"+str[0]+"\n"+str[1]);
//        
//        Calendar cal=Calendar.getInstance();
//        sb.append(cal.get(Calendar.DATE));
//        sb.append("-");
//        sb.append(cal.get(Calendar.MONTH));
//        sb.append("-");
//        sb.append(cal.get(Calendar.YEAR));
//        sb.append("/");
//        sb.append(cal.get(Calendar.HOUR));
//        sb.append(":");
//        sb.append(cal.get(Calendar.MINUTE));
//        sb.append(":");
//        sb.append(cal.get(Calendar.SECOND));
//        sb.append("//");
//        if(dbid==null)
//        {
//            sb.append("aaaaaaaaab");
//        }
//        else
//        {
//        String str[]=dbid.split("//");
//        String strr=str[1].toString();
//        String name = strr;
//        int ascii = 0, i;
//        int j = name.length() - 1;
//        char[] a = new char[name.length()];
//
//        for (i = 0; i < name.length(); i++) {
//
//            a[i] = name.charAt(i);
//        }
//        while (j > 0) {
//            ascii = name.toCharArray()[j];
//
//            if (ascii < 122) 
//            {
//                ascii = ascii + 1;
//                char c = (char) ascii;
//                a[j] = c;
//                break;
//            }
//            j--;
//        }
//        String b = new String(a);
//        sb.append(b);
//        }
 //       ss=sb.toString();
//        return ss;
//    } 
//    
    
    
}


    
    
    
    

