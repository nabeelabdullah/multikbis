/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.account;

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
import nabeel_temp.encription;

/**
 *
 * @author akhtar
 */
public class AccountValidater extends HttpServlet {

    
    encription en;
    DBclass db;
    Connection con;
    Statement st;
    ResultSet rs;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           en = encription.createObject();
           db=DBclass.objectCreater();
           con=db.getConnection();
           st=con.createStatement();
           String uid=request.getParameter("u_id");
           if(en.validater(uid))
           {
               uid=en.decreption(uid);
           String mail=request.getParameter("mail");
           
           String query="select email from user_login where user_id='"+uid+"';";
           rs=db.toRead(query, st);
           if(rs.next())
           {
           if(rs.getString("email").equals(mail))
           {
           String query2="update user_login set status=1 where user_id='"+uid+"';";
           db.toUpdate(query2, st); 
           response.sendRedirect("http://www.multikbis.com/");
           }
           else
           out.println("something goes wrong");
           }
           else
           {
                out.println("something goes wrong");
           }
           }
           else
               out.println("wrong id");
            
            
        } catch (SQLException ex) {} 
        finally {   
            try {
                con.close();
                con.close();
                out.close();
                rs.close();
            } catch (SQLException ex) {}
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
