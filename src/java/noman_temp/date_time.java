/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhtar
 */
public class date_time {
    static date_time dt;
   
    public static date_time Object_creator()
    {
        if(dt==null)
            dt=new date_time();
        return dt;
    }
    
    public String get_date()
    {
        String date_demo=null;
        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        date_demo=sdf.format(d).toUpperCase().replaceAll("-", "/");
        
    return date_demo;
    }
    
    public String get_time()
    {
        String time_demo=null;
        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss",Locale.US);
        time_demo=sdf.format(d).replaceAll("-", ":");
        return time_demo;
    }
    
    
    
    public  String get_day(String date)
    {
        String day="";
        try {
            SimpleDateFormat sm=new SimpleDateFormat("dd/MMM/yyyy");
            Date d=sm.parse(date);
            sm.applyPattern("EEEE");
            day=sm.format(d);
            //System.out.println("hiiiiiii="+day);
         
        } catch (ParseException ex) {
            Logger.getLogger(date_time.class.getName()).log(Level.SEVERE, null, ex);
        }
       
//         Calendar c=Calendar.getInstance();
//         c.set(2015, 2,20);
//         int y= c.get(Calendar.DAY_OF_WEEK);
//         System.out.println("hiiiiii="+y);
        
        
    return day;
    }
    
    
//    public static void main(String akhtar[])
//    {
//        date_time dt=new date_time();
//        dt.get_day("11/JAN/2015");
////    System.out.println(dt.get_date());
//    }
//    
    
    
    
    
    
    
}
