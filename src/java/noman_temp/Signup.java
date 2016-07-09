/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import com.website.account.validator;
import com.website.databases.DBclass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import nabeel_temp.DefaoulImageCreater;
import nabeel_temp.PathCreater;
import nabeel_temp.encription;
import nabeel_temp.work;

/**
 *
 * @author akhtar
 */
public class Signup {
    static Signup sn=null;
    Connection con;
    Statement set;
    
    
    public static Signup objectCreator()
    {
    if(sn==null)
        sn=new Signup();
    return sn;
    }
    
    public String signupAuthentication(String fname,String lname,String email,String mobile,String inst,String city,String pass,String repass,String day,String month,String year,String gender)
    {
        String ret="not ok";
         try { 
                    DBclass db=DBclass.objectCreater();
                    con=db.getConnection();
                    set=con.createStatement();
                    work w = work.objectCreater();
                    validator wb = new validator();
                    img_creator cr=img_creator.objectCreater();
                    PathCreater pc = PathCreater.objectCreater();
                    DefaoulImageCreater df=new DefaoulImageCreater();
        
                    
                    String user_id="";
                    String start = "('";
                    String end = "');";
                    String next = "','";
        
                    int name3 = wb.emailValidator(email);
          
                    if (name3 == 0) 
                    {
                        ret="mailexist";   
                    } 
                    
                    else 
                    {
                    
                        if (name3 == 1) 
                        {  
                            int name1 = wb.firstnameValidator(fname);
                            System.out.println("nomanfirst"+name1);
                            int name2 = wb.lastnameValidator(lname);
                            System.out.println("nomansecond"+name2);
                            int name4 = wb.mobileValidator(mobile);
                            System.out.println("nomanmob"+name4);
                            int name5 = wb.instituteValidator(inst);
                            int name7 =wb.passwordValidator(pass, repass);
                            System.out.println("nomanpass"+name7);
                            int name8 = wb.dobValidator(day, month, year);
                            System.out.println("nomandob"+name8);
                            int name9 = wb.genderValidator(gender);
                            System.out.println("nomangen"+name9);

                            encription en = encription.createObject();
                            pass = en.Password(pass);
                            if (name1 == 1 && name2 == 1 && name3 == 1 && name4 == 1 && name5 == 1 &&  name7 == 1 && name8 == 1 && name9 == 1) 
                            {
                                                    String query = "select * from user_id_holder";
                                                    ResultSet st = db.toRead(query,set);
                                                        st.next();
                                                        String old = st.getString("max_id");
                                                        user_id = w.id_creater(old);
                                                        query = "update user_id_holder set max_id='" + user_id + "'";
                                                        db.toUpdate(query, set);


                                                String query1 = "insert into record value" + start + user_id + next + fname + next + lname + next + email + next + mobile + next + inst + next + city + next + pass + next + day + next + month + next + year + next + gender + end;
                                                db.toWrite(query1,set);
                                                String query2 = "insert into user_id value" + start + user_id + next + fname + " " + lname + end;             
                                                System.out.println(query2);
                                                db.toWrite(query2,set);
                                                String query3 = "insert into user_login value" + start + user_id + next + email + next + pass +next+"0"+ end;
                                                System.out.println(query3);
                                                db.toWrite(query3,set);
                                                String query4 = "insert into user_profile value" + start + user_id + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL" + next + "NIL"+next+fname+" "+lname + end;
                                                System.out.println(query4);
                                                db.toWrite(query4,set);
                                                String path = null;
                                                if (gender.equals("male")) 
                                                {
                                                    df.defaultImageCreater("male",user_id);
                                                    cr.img_creator(user_id);          
                                                }
                                                if (gender.equals("female")) 
                                                {
                                                    df.defaultImageCreater("female",user_id);
                                                    cr.img_creator(user_id);
                                                }

                                                query4 = "insert into user_pics value" + start + user_id + next + path + end;
                                                db.toWrite(query4,set);
                                                query4 = "insert into on_off value" + start + user_id + next + "0" + end;
                                                db.toWrite(query4,set);
                                                
                                                pc.userfoldercreater(user_id);
                                                //System.out.println("successfull");
                                                ret=user_id;
                                                
                           
                            } 
                          
                            
                        }
                   
            } 
            
    }//try
    catch (SQLException ex) {}
    finally
    {
                 try 
                 { 
                     con.close();
                     set.close();
                 } catch (SQLException ex) 
                 {
                     Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                 }

    }         
  return ret;
}
    
    
//  public static void main(String...l)
//  {
//  Signup sn=Signup.objectCreator();
//  //System.out.println(sn.signupAuthentication("noman","akhtar", "noman@gmail.com","1234569878", "integral","lko", "123", "123", "20", "mar", "2012", "male"));
//  }
    
}
