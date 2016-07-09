/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.forgetPassword;

import com.website.databases.DBclass;
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

/**
 *
 * @author NABEEL
 */
public class PasswordReseter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            encription en = encription.createObject();
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            try {
               
                String user_id = en.decreption(request.getParameter("u")).trim();
                String nonce = request.getParameter("n").trim();
                String query = "select nonce from forget_pass where user_id='" + user_id + "';";
                boolean b = false;
                ResultSet st = db.toRead(query, set);
                try {
                    if (st.next()) 
                    {
                        if (st.getString("nonce").equals(nonce)) 
                        {
                            b = true;
                        }
                        if(b)
                        {
                            request.setAttribute("n", nonce);
                            request.setAttribute("u", request.getParameter("u"));
                           // out.println("aaa");
                            request.getRequestDispatcher("WEB-INF/resetPass/changePass.jsp").forward(request, response);
                            // request.getRequestDispatcher("/WEB-INF/resetPass/changePass.jsp").forward(request, response);
                        }
                    }
                    else
                    {
                       out.println("SORRY Request again for change Password");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PasswordReseter.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } finally {
                out.close();
            }
            con.close();
            set.close();
        }   catch (SQLException ex) {
            Logger.getLogger(PasswordReseter.class.getName()).log(Level.SEVERE, null, ex);
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
