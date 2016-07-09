/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.comment;

import com.website.databases.*;
import nabeel_temp.*;
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
import noman_temp.like_comment_file_manager;

/**
 *
 * @author akhtar
 */
public class like_comment extends HttpServlet {

    Connection con;
    Statement set;
    ResultSet sr1;
    DBclass db;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
            HttpSession hs=request.getSession(false);
            encription e=encription.createObject();
            like_comment_file_manager lcfm=like_comment_file_manager.objectCreater();
           
                 
                 
            
            String p_id="",u_id="",user_id="",c_id="",e_u_id="",e_p_id="",e_c_id="";
            String query1="",query2="";
            
             e_u_id=request.getParameter("uiid").trim();
             e_p_id=request.getParameter("piid").trim();
             e_c_id=request.getParameter("ciid").trim();
             
             
            if((hs!=null)&& (e.validater(e_c_id))&&(e.validater(e_p_id))&&(e.validater(e_u_id)))
            {   
             try {
                 db=DBclass.objectCreater();
                 con=db.getConnection();
                 set=con.createStatement();
               
                u_id=e.decreption(e_u_id);
                p_id=e.decreption(e_p_id);
                c_id=e.decreption(e_c_id);
                
                user_id=hs.getAttribute("user_id").toString();
                out.write(4);
                boolean b=lcfm.like_comment_validater(u_id, p_id, c_id, user_id);
                 out.println(b);  
                    if(!b)
                    {
                      
                    boolean bb=lcfm.like_comment_setter(u_id, p_id, c_id, user_id);
                    out.println(bb);
                        if(bb==true)
                        {
                                
                                query1="update comment_record set c_likes=c_likes+1 where comment_id='"+c_id+"';";
                                db.toWrite(query1, set);
                              //  out.write("oooookkkkkkk");
                             
                        }
                    } 
                } catch (SQLException ex) {}
                finally {
                        try {
                            con.close();
                            set.close();
                            } catch (SQLException ex) {}
                        }
               
            }
            else
            {             
               // request.getRequestDispatcher("Login").forward(request, response);
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
