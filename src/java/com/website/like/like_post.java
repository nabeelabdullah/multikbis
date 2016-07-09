/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.like;

import com.website.databases.*;
import nabeel_temp.encription;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import noman_temp.*;

/**
 *
 * @author akhtar
 */
public class like_post extends HttpServlet {

Connection con;
Statement set;
ResultSet rs;
DBclass db;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
                 
            like_post_file_manager lfm=like_post_file_manager.objectCreater();
            HttpSession hs=request.getSession(false);
            encription e=encription.createObject();
            
            String user_id="",post_id="",p_id="",u_id="",e_u_id="",user_name="",e_post_id="";
            String query1="",query2="",query3="";
            
               
                e_post_id=request.getParameter("piid").trim();
                e_u_id=request.getParameter("uiid").trim();
            
            if((hs!=null)&&(e.validater(request.getParameter("piid").trim()))&&(e.validater(request.getParameter("uiid"))))
              {
                   try {
                            db=DBclass.objectCreater();
                            con=db.getConnection();
                            set=con.createStatement();

                           u_id=e.decreption(e_u_id);
                           p_id=e.decreption(e_post_id);
                           user_id=hs.getAttribute("user_id").toString();

                            boolean bb=lfm.like_validater(u_id, p_id,user_id);
                            if(!bb)
                            {
                                    query2="select user_name from user_id where user_id='"+user_id+"';";
                                    rs=db.toRead(query2, set);
                                            rs.next();
                                            user_name=rs.getString("user_name");
                                    boolean b=lfm.like_setter(u_id,p_id,user_id,user_name);
                                    if(b)
                                        {
                                         query1="update search_record set likes=likes+1 where post_id='"+p_id+"';";
                                         db.toWrite(query1, set);
                                         out.write("okkkkkkkkkk");
                                         }
                              }  
                            
                     } catch (SQLException ex) {}
                    finally{
                            try {
                                out.close();
                                con.close();
                                set.close();
                                rs.close();
                                } 
                            catch (SQLException ex) {}
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
