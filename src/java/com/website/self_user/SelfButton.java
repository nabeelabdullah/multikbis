/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.self_user;

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
import noman_temp.compressname;
import noman_temp.post_file_manager;

/**
 *
 * @author akhtar
 */
public class SelfButton extends HttpServlet {
        DBclass db;
        Connection con;
        Statement set;
        ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                HttpSession hs=request.getSession(false);
                encription en=encription.createObject();
                post_file_manager pfm=post_file_manager.objectCreater();
                HashMap hm2=new HashMap();
                HashMap hm3=new HashMap();
               
                
                
                 if(hs!=null)
                {  
                     try {
                            db=DBclass.objectCreater();
                            con=db.getConnection();
                            set=con.createStatement();
                               String u_id=hs.getAttribute("user_id").toString();
                               String post_id =null,topic=null,user_name=null,post=null,profile_pic=null,user_id=null,like=null;
                               String quary1=null;
                               int hash_counter=0;
                               String txt_value=request.getParameter("itxt");

                               quary1="select s.topic,s.likes,s.post_id,u.user_name,u.user_id from search_record as s inner join user_post as p inner join user_id as u on(s.POST_ID=p.POST_ID and p.user_ID=u.user_ID) where (u.user_ID='"+u_id+"' and s.topic like '%"+txt_value+"%') order by s.POST_ID DESC limit 6;";
                                      rs = db.toRead(quary1,set);
                                      while(rs.next()) {         
                                          HashMap hm1=new HashMap();
                                           post_id = rs.getString("post_id");   
                                           user_id = rs.getString("user_id");   
                                           user_name=rs.getString("user_name");
                                           topic =rs.getString("topic");
                                           like=rs.getString("likes");
                                           post=pfm.post_reader(user_id, post_id);


                                                  hm1.put("post_id",en.encription(post_id));
                                                  hm1.put("user_id", en.encription(user_id));
                                                  hm1.put("user_name", user_name);
                                                  hm1.put("topic", topic);
                                                  hm1.put("post", post);
                                                  hm1.put("like", like);



           //                                        out.println("post_id="+post_id);
           //                                        out.println("user_id="+user_id);
           //                                        out.println("user_name="+user_name);
           //                                        out.println("topic="+topic);
           //                                        out.println("like="+like);

                                           hm3.put(hash_counter++,hm1);
                                           }

                       request.setAttribute("hash", hm3);
                       request.setAttribute("e_u_id", en.encription(u_id));
                       hs.setAttribute("self_user_button_post_id", post_id);   
                       request.getRequestDispatcher("WEB-INF/AKHTAR/self_button.jsp").forward(request, response);

                } catch (SQLException ex) {}
                finally
                {
                    try {
                        con.close();
                        set.close();
                        rs.close();

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
