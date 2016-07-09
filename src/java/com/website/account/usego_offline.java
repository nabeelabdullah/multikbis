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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author akhtar
 */
public class usego_offline extends HttpServlet {
    
    DBclass db;
    Connection con;
    Statement set;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession(false);
        
        if (hs != null) {            
            try {
                hs.removeAttribute("listener");
                db = DBclass.objectCreater();
                con = db.getConnection();
                set = con.createStatement();
                String up = "update on_off set status='0' where user_id='" + hs.getAttribute("user_id") + "';";
                
                db.toWrite(up, set);
                hs.invalidate();
            } catch (SQLException ex) {
            } finally {                
                try {
                    con.close();
                    set.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            
        }
        
        out.println(request.getSession(false));
        //out.println("you successfully go off_line if you want to go in login page  "+ "<a href='home/website.html'>click here</a>");
        request.getRequestDispatcher("Login").forward(request, response);
        //response.sendRedirect("home_dispacher");
        
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
