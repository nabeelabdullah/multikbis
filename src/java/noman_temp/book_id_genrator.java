/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package noman_temp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author akhtar
 */
public class book_id_genrator {
   static book_id_genrator bp;
   public  book_id_genrator(){}
    public  static book_id_genrator Object_creator(){
       bp=new book_id_genrator();
   return bp;
   }
     
    public String book_id_genrator()
    {
        get_max_id  mx=get_max_id.Object_creator();
        String dbid=mx.get_max_id_creator("book_info", "BOOK_ID");
        
        String ss;
        StringBuilder sb=new StringBuilder();
        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        String p=sdf.format(d);
        String b[]=new String[3];
        b=p.split("-");
        sb.append("BI");
        sb.append(b[0]);
        sb.append(b[1]);
        sb.append(b[2]);
        System.out.println(sb);
        
        if(dbid==null)
        {
        
        sb.append("aaaaaaaaaa");
        }
        else
        {   
  
         
            String strr=dbid;
            strr=strr.substring(8, 18);
            String name = strr;
            System.out.println("name i="+name);
            int ascii = 0, i;
            
            int j = name.length() - 1;
            System.out.println(j);
            char[] a = new char[name.length()];

            for (i = 0; i < name.length(); i++) {

                a[i] = name.charAt(i);
            }
            while (j > 0) {
                ascii = name.toCharArray()[j];

                if (ascii < 122) 
                {
                    ascii = ascii + 1;
                    char c = (char) ascii;
                    a[j] = c;
                    break;
                }
                j--;
            }
            String w = new String(a);
            sb.append(w);
        }
        ss=sb.toString();
            return ss;
        
    }
    
    
  
    
    
    
    
    
    
    
    
}
