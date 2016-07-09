package com.website.friend.main;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import nabeel_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nabeel
 */
public class continuechat extends HttpServlet {

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
        encription en = encription.createObject();
        HttpSession hs = request.getSession(false);
        if (hs != null) {
            try {
                String s_id = request.getParameter("s_id");
                if (!s_id.equals("0")) {
                    s_id = en.decreption(s_id);
                    DBclass db = DBclass.objectCreater();
                    Connection con = db.getConnection();
                    Statement set = con.createStatement();

                    String query = "select * from chat where id >'" + hs.getAttribute("max_id") + "' and s_id='" + s_id + "' and r_id='" + hs.getAttribute("user_id") + "';";
                    String max = "";
                    ResultSet st = db.toRead(query, set);
                    try {
                        while (st.next()) {

                        // out.write("<div class='chatpara'> <p class='fupara'>FRIEND:</p>" + st.getString("msg") + "</div>");
                            //  out.write("<div class='chat_devider'></div>");
                            out.write(fromchat(st.getString("msg")));
                            max = st.getString("id");

                            hs.setAttribute("max_id", max);

                        }
                        con.close();
                        set.close();
                    } catch (SQLException ex) {

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(continuechat.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    private String fromchat(String data) {

        String ret = "<div class='fromyou' >"
                + " <div class='fromchatimg' >"
                + "<div class='fromchatimgin' >"
                + "<img src='../img/lpointer.png'class='fromchatimage'/>"
                + "</div>"
                + "</div>"
                + "<div class='fromchatcontent' >"
                + "<p  class='fromchatcontentp' >" + data
                + "</p>"
                + " </div>"
                + " </div>";
        return ret;
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
