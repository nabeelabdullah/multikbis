/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.full_post;

import com.website.databases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nabeel_temp.encription;
import noman_temp.*;

/**
 *
 * @author NABEEL
 */
public class full_post_button extends HttpServlet {
                DBclass db;
                Connection con1,con2;
                Statement set1,set2;
                ResultSet sr1,sr2;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
             HttpSession hs=request.getSession(false);
            StringBuffer sb;
            HashMap hm1;
            HashMap hm2;
            HashMap hm3;
            HashMap hm4=new HashMap();
            date_time dt=date_time.Object_creator();
            post_file_manager pfm=post_file_manager.objectCreater();
            encription en=encription.createObject();
            comment_file_manager cfm=comment_file_manager.objectCreater();
            like_post_file_manager lfm=like_post_file_manager.objectCreater();
            like_comment_file_manager lcfm= like_comment_file_manager.objectCreater();
            
            
            
            
            String user_id="",query1="",query2="",query3="",post_id="",user_name="",topic="",post="",p_date="",p_time="",p_day="",u_id="",e_user_id="",e_u_id="";
            String c_date="",c_time="",comment="",c_id="",c_user_id="",txt_value="";
            int c_like=0;
            int counter=0,attach=0,post_counter=0,like=0,no_of_comment=0,comment_counter=0,tem_counter=0;
            txt_value=request.getParameter("itxt").trim();
         
            if(hs!=null)
            {
                 try {   
                            u_id=hs.getAttribute("user_id").toString();

                            db=DBclass.objectCreater();
                            con1=db.getConnection();
                            set1=con1.createStatement();
                            
                            
                            query1 ="select distinct s.topic,s.p_date,s.p_time,s.no_of_attach,s.total_comment,s.LIKES,s.POST_ID,u.user_name,u.user_id from search_record as s inner join user_post as p inner join user_id as u on(s.POST_ID=p.POST_ID and p.user_ID=u.user_ID) where s.topic like '%"+txt_value+"%'  order by  s.POST_ID DESC limit 4;";
                            sr1=db.toRead(query1, set1);

                               while(sr1.next()) 
                                {
                                hm1=new HashMap();
                                user_id=sr1.getString("user_id");
                                user_name=sr1.getString("user_name");
                                post_id=sr1.getString("POST_ID");
                                topic =sr1.getString("TOPIC");
                                p_date =sr1.getString("p_date");
                                p_day=dt.get_day(p_date);
                                p_time =sr1.getString("p_time");
                                like=sr1.getInt("likes");
                                no_of_comment=Integer.parseInt(sr1.getString("total_comment"));
                                attach=Integer.parseInt(sr1.getString("no_of_attach"));
                                post=pfm.full_post_reader(user_id, post_id);
                                        String matter=new String("");
                                        matter=lfm.get_postlike_user_name(user_id, post_id);
                                boolean res= lfm.like_validater(user_id, post_id,u_id);
                                //out.println("like_validator="+res);

                                e_user_id=en.encription(user_id);

                                if(!res)
                                {
                                  hm1.put("style", "'color: #0000FF;'");  
                                }
                                else
                                {
                                 hm1.put("style", "'color:red;'"); 
                                }

                                    hm1.put("user_id", e_user_id);
                                    hm1.put("user_name", user_name);
                                    hm1.put("p_date", p_date);
                                    hm1.put("p_day", p_day);
                                    hm1.put("p_time", p_time);
                                    hm1.put("post_id", en.encription(post_id));
                                    hm1.put("topic", topic);
                                    hm1.put("like", like);  
                                    hm1.put("no_of_comment",no_of_comment);
                                    hm1.put("attach", attach);
                                    hm1.put("post", post);


                                            //out.println("user_name="+user_name);
                                            //out.println("post_id="+post_id);
                                            //out.println("like="+like);
                                            //out.println("attach="+attach);
                                            //out.println("post="+post);
                                            //out.println("topic="+topic);
                                            //out.println("no of_ comment="+no_of_comment);

                                        if(no_of_comment>0)
                                        {     
                                            con2=db.getConnection();
                                            set2=con2.createStatement();
                                                query2="select c_r.c_date,c_r.comment_id,c_r.c_time,c_r.c_likes,c_r.c_user_id from comment_record as c_r  inner join user_comment  as u_c inner join user_post as u_p on (c_r.comment_id=u_c.comment_id and u_c.post_id=u_p.post_id ) where (u_p.post_id='"+post_id+"') order by c_r.comment_id DESC;"; 
                                                sr2=db.toRead(query2,set2); 
                                                try{         
                                                            hm3=new HashMap();
                                                            while(sr2.next())
                                                            {  
                                                             hm2=new HashMap();


                                                             c_date=sr2.getString("c_date");
                                                             c_user_id=en.encription(sr2.getString("c_user_id"));
                                                             c_like=sr2.getInt("c_likes");
                                                             c_time=sr2.getString("c_time");
                                                             c_id=sr2.getString("comment_id");
                                                             comment=cfm.comment_reader(user_id, post_id, c_id);

                                                             boolean bn=lcfm.like_comment_validater(user_id, post_id, c_id, u_id);

                                                                        if(!bn)
                                                                        {
                                                                         hm2.put("style", "'color: #0000FF;'");  
                                                                        }
                                                                        else
                                                                        {
                                                                         hm2.put("style", "'color:red;'"); 
                                                                        }   

                                                                        hm2.put("comment",comment);
                                                                        hm2.put("comment_id",en.encription(c_id));
                                                                        hm2.put("comment_date",c_date);
                                                                        hm2.put("c_user_id",c_user_id); 
                                                                        hm2.put("comment_time",c_time); 
                                                                        hm2.put("comment_like",c_like);
                                                            //out.println("comment="+comment);
                                                            //out.println("c_date="+c_date);
                                                            //out.println("c_time="+c_time);
                                                            //out.println("c_id="+c_id);
                                                            //out.println("c_likes="+like);


                                                             hm3.put(comment_counter,hm2);   
                                                             comment_counter=comment_counter+1;
                                                            }
                                                             hm1.put("detail",hm3);   
                                                             comment_counter=0;


                                                    post_counter=0;

                                                   }catch(SQLException sq){}
                                                   finally{
                                                        try {
                                                            sr2.close();
                                                            con2.close();
                                                            set2.close();
                                                            } catch (SQLException ex) {}
                                                          }



                                        }   
                                hm4.put(counter, hm1);
                                counter=counter+1;
                                }


                         hs.setAttribute("scroll_full_post_id", post_id);
                         request.setAttribute("e_u_id",en.encription(u_id));
                         request.setAttribute("hash", hm4);
                         request.getRequestDispatcher("WEB-INF/full_post_button/full_post_button.jsp").forward(request, response);

                }catch (SQLException e) {out.println("ohhh! sorry");}    
                finally
                {
                    try {
                        con1.close();
                        set1.close();
                        sr1.close();
                        } catch (SQLException ex) {}
                }       
            
            
            }
            else
            {
              request.getRequestDispatcher("Login").forward(request, response);
            }
            
            
         
          
         
            
            
            
            
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
