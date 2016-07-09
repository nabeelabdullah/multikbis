package com.website.self_user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.website.databases.DBclass;
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
import nabeel_temp.encription;
import noman_temp.post_file_manager;


/**
 *
 * @author akhtar
 */
public class DeletePost extends HttpServlet {
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
                
                String query1="",query2="",query3="",query4="",query5="";
                String p_id="",u_id="";
                boolean valid=false;
                int y=0,z=0;
                
               p_id=request.getParameter("piid").trim();
               if((hs!=null) && (en.validater(p_id)))
                {
                    try {
                                db=DBclass.objectCreater();
                                con=db.getConnection();
                                set=con.createStatement();
                           p_id=en.decreption(p_id);
                           u_id=hs.getAttribute("user_id").toString();
                           boolean b=pfm.delete_post(u_id, p_id);
                                   if(b)
                                   {
                                   query1="select comment_id from user_comment where post_id='"+p_id+"';";
                                   rs=db.toRead(query1, set);
                                       while(rs.next())
                                       {
                                       String c_id=rs.getString("comment_id");
                                       query2="delete from comment_record where comment_id='"+c_id+"';";
                                       z=db.toDelete(query2, set);
                                       }
                                   query5="delete from user_comment where POST_ID='"+p_id+"';";
                                   db.toDelete(query5, set);

                                   query3="delete from search_record where POST_ID='"+p_id+"';";
                                   db.toDelete(query3, set);
                                   query4="delete from user_post where POST_ID='"+p_id+"';";
                                   db.toDelete(query4, set);
                                   out.println("done");
                                   }
                                   else
                                   {
                                   out.println("cancel");
                                   }
                                   
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
