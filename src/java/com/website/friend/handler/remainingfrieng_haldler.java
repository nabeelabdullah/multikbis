/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.friend.handler;

import com.website.databases.DBclass;
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
public class remainingfrieng_haldler extends HttpServlet {

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
        //out.println("1");
        HttpSession hs = request.getSession(false);
        //   out.println("1");
        String name = request.getParameter("name");
        //  out.println("1");
        if (hs!=null) {
            //out.println("1");

            String rm = hs.getAttribute("remainingfriends").toString();
            String empty = hs.getAttribute("isfriendempty").toString();
           // out.println(rm+"   "+empty);
            if ((!rm.equals("running")) && (!empty.equals("empty"))) {
                
                try {
                    groupWork gww = groupWork.objectCreater();
                    DBclass db=DBclass.objectCreater();
                    Connection con=db.getConnection();
                    Statement set=con.createStatement();
                    PathCreater pc = PathCreater.objectCreater();
                    encription en = encription.createObject();
                    genralwork gw=genralwork.bojectCreater();
                    String last_friendid = hs.getAttribute("last_friendid").toString();
                    hs.setAttribute("remainingfriends", "running");
                    String query = "select a.user_name,a.user_id ,b.table_id from user_id as a inner join friends as b on(a.user_id=b.friend_id) where (b.user_id='" + hs.getAttribute("user_id") + "' and b.status='1'" + " and b.table_id > '" + last_friendid + "' and a.user_name like '%" + name + "%') limit 5 ;";
                    //out.println(query);
                    ResultSet st = db.toRead(query, set);
                    int count = 0;
                    HashMap mp = new HashMap();
                    String a, last = "";

                    while (st.next()) {
                        HashMap x = new HashMap();
                        last = st.getString("table_id");
                        a = en.encription(st.getString("user_id"));
                        x.put("1", a);//pc.profilePicsPathCreater(st.getString("user_id")));
                        x.put("2", a);
                        x.put("3", gw.nameFormater(st.getString("user_name")));
                        x.put("4", "sp" + a);
                        mp.put(count++, x);

                    }
                    hs.setAttribute("last_friendid", last);

                    hs.setAttribute("remainingfriends", "notrunning");
                    con.close();
                    set.close();
                    if (count != 0) {
                        hs.setAttribute("isfriendempty", "notempty");
                       // out.println("chala");
                        hs.setAttribute("hash", mp);
                        request.getRequestDispatcher("WEB-INF/NABEEL/remainingfriends.jsp").forward(request, response);
                    } else {
                        hs.setAttribute("isfriendempty", "empty");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(remainingfrieng_haldler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
           // hs.invalidate();
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
