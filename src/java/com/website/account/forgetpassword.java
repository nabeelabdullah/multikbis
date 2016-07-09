/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.account;


import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author akhtar
 */
public class forgetpassword extends HttpServlet {
            
            DBclass db;
            Connection con;
            ResultSet rs;
            Statement set;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            String s1=null,s2=null,s3=null,s4=null;
            s1=request.getParameter("forgetusername");
            s2=request.getParameter("forgetmob");
            if(!s1.equals("")&& !s2.equals(""))
            {
              try {
                
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set=con.createStatement();

                        String quary="select EMAIL,PASSWORD from record where(EMAIL='"+s1+"' and MOBILE='"+s2+"')";
                        out.println(quary);
                        rs=db.toRead(quary,set);
                        try{
                            rs.next();
                            s3=rs.getString("EMAIL");
                            s4=rs.getString("PASSWORD");
                            out.println(s3);
                            out.println(s4);
                            //set.close();
                        }catch(SQLException sqle){}

                        if(s3.equals("")&& s4.equals(""))
                        {
                            out.println("not exist");
                        }
                        else
                        {
                            out.println("ok check email");
                            //write send emailcode
                        }

                 } catch (SQLException ex) {} 
                finally {   
                    try {
                        con.close();
                        set.close();
                        out.close();
                        rs.close();
                         } catch (SQLException ex) {}
                         }  
                
            }
            else
            {
                out.println("invalid entry");
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
