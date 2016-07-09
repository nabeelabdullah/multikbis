/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.group.handler;

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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NABEEL
 */
public class questionhandler extends HttpServlet {

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
        
        if (hs==null) {
            // out.println("plz login");
            //hs.invalidate();
             request.getRequestDispatcher("Login").forward(request, response);
            
        } else {
            
            String group_id = request.getParameter("g_id");

            if (en.validater(group_id)) {
                try {
                    String dg = en.decreption(group_id);
                    String query = "select u.user_name,u.user_id,q.question_id,q.answer_no from group_question as q inner join user_id as u on(q.user_id=u.user_id) where group_id='" + dg + "';";

                   DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
                    ResultSet st = db.toRead(query, set);
                    genralwork gw=genralwork.bojectCreater();
                    String path = null;
                    PathCreater pc = PathCreater.objectCreater();

                    groupWork w = groupWork.objectCreater();
                    HashMap mp = new HashMap();
                    int i = 0;
                    while (st.next()) {
                        HashMap t = new HashMap();
                        path = pc.questionPathCreater(dg, st.getString("question_id"));

                        t.put("1", w.contentInFile(path));
                        t.put("2", en.encription(st.getString("user_id")));
                        t.put("3",gw.nameFormater(st.getString("user_name")));
                        t.put("4", en.encription(st.getString("question_id")));

                        t.put("6", st.getInt("answer_no"));

                        mp.put(i++, t);
                    }
                    con.close();
                    set.close();
                    request.setAttribute("gi", group_id);
                    request.setAttribute("hash", mp);
                    request.getRequestDispatcher("WEB-INF/NABEEL/question.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(questionhandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                out.println("wrong id");
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
