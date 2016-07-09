/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.forgetPassword;

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
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
public class ResetPassword extends HttpServlet {

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
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            encription en = encription.createObject();
            try {
                String user_id=en.decreption(request.getParameter("u"));
                String pass=request.getParameter("p").trim();
                String nonce=request.getParameter("n").trim();
                String query="select nonce from forget_pass where nonce='"+nonce+"';";
                ResultSet st=db.toRead(query, set);
                try {
                    if(st.next())
                    {
                        if(st.getString("nonce").equals(nonce))
                        {
                            query="update user_login set user_pass='"+en.Password(pass)+"' where user_id='"+user_id+"'";
                            int b= db.toUpdate(query, set);
                            query="delete from forget_pass where user_id='"+user_id+"'";
                            db.toDelete(query, set);
                            if(b!=0)
                                out.println(" Your Password has been changed Succesfully");
                            
                            else
                                out.println("Password could not change");
                            
                        }
                        
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } finally {
                out.close();
            }
            con.close();
            set.close();
        }   catch (SQLException ex) {
            Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
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
