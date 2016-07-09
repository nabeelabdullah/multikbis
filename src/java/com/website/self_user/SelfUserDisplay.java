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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nabeel_temp.*;
import noman_temp.compressname;
import noman_temp.post_file_manager;

/**
 *
 * @author akhtar
 */
public class SelfUserDisplay extends HttpServlet {
                DBclass db;
                Connection con;
                Statement set;
                ResultSet rs;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
                response.setContentType("text/html;charset=UTF-8");
             
                PrintWriter out = response.getWriter();
                HttpSession hs=request.getSession(false);
                post_file_manager pfm=post_file_manager.objectCreater();
                HashMap hm2=new HashMap();
                HashMap hm3=new HashMap();
                encription en=encription.createObject();
                    
                String u_id="";
                
                
                 if(hs!=null)
                {  
                      try {
                                db=DBclass.objectCreater();
                                con=db.getConnection();
                                set=con.createStatement();

                                   u_id=hs.getAttribute("user_id").toString();

                                   String post_id =null,topic=null,user_name=null,post=null,profile_pic=null,user_id=null,like=null,attach="";
                                   String quary1=null;
                                   int hash_counter=0;
                                   quary1="select s.topic,s.no_of_attach,s.likes,s.post_id,u.user_name,u.user_ID from search_record as s inner join user_post as p inner join user_id as u on(s.POST_ID=p.POST_ID and p.user_ID=u.user_ID) where (u.user_ID='"+u_id+"') order by s.POST_ID DESC limit 6;";
                                   try {
                                          rs = db.toRead(quary1,set);
                                          while(rs.next()) {         
                                              HashMap hm1=new HashMap();
                                               post_id = rs.getString("post_id");   
                                               user_id = rs.getString("user_id");   
                                                      hm1.put("post_id", en.encription(post_id));
                                                      hm1.put("user_id", en.encription(user_id));
                                                      hm1.put("user_name", rs.getString("user_name"));
                                                      hm1.put("topic", rs.getString("topic"));
                                                      hm1.put("post", pfm.post_reader(user_id, post_id));
                                                      hm1.put("like", rs.getString("likes"));
                                                      hm1.put("attach", rs.getString("no_of_attach"));

                                                      hm3.put(hash_counter++,hm1);
                                               }
                                       }
                                       catch(SQLException e){out.println("!!!!!!!!!!");}
                           request.setAttribute("hash", hm3);
                           hs.setAttribute("self_user_post_id", post_id);
                           hs.setAttribute("self_user_runner", "not_run");
                           request.setAttribute("e_u_id",en.encription(u_id));
                           request.getRequestDispatcher("WEB-INF/AKHTAR/self_user.jsp").forward(request, response);
                           
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
