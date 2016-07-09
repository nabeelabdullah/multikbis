/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.servlet.http.HttpSession;
import nabeel_temp.encription;
import org.json.simple.JSONObject;

/**
 *
 * @author zishan
 */
public class ChangePassword extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DBclass db = DBclass.objectCreater();
        Connection con = db.getConnection();
         JSONObject json=new JSONObject();
        try {
            String oldPass = request.getParameter("old");
            String newPassword = request.getParameter("new");
           
            HttpSession hs = request.getSession(false);
            if (hs != null) {
                if (oldPass != null || oldPass != "" || newPassword != null || newPassword != "") {
                    
                    encription en = encription.createObject();
                    Statement st = con.createStatement();
                    String q = "select user_id from user_login where user_id='" + hs.getAttribute("user_id") + "' and user_pass ='" + en.Password(oldPass) + "';";
                    ResultSet result = st.executeQuery(q);
                    if (result.next()) {
                        String query = "update user_login set user_pass='" + en.Password(newPassword) + "' where user_id='" + hs.getAttribute("user_id") + "'";
                        st.execute(query);
                        json.put("status", "done");
                    } else {
                        json.put("status","passwordnotmatch");
                    }
                }
            } else {
                json.put("status","logout");
            }
             out.print(json);
        } catch (SQLException ex) {
            json.put("status","fail");
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            try {
                if(con!=null)
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
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
