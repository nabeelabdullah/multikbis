/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.group.handler;

import com.website.databases.DBclass;
import nabeel_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class searched_group extends HttpServlet {

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
        String name = request.getParameter("group_name");
        HttpSession hs = request.getSession(false);

        if (hs!=null) {
            try {

              DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
                ResultSet stg;
                encription en = encription.createObject();
                String m = "select group_id from group_member where member_id='" + hs.getAttribute("user_id") + "'";
                List<String> li = new ArrayList<String>();
                stg = db.toRead(m, set);
                groupWork gw = groupWork.objectCreater();
                while (stg.next()) {
                    li.add(stg.getString("group_id"));
                }
                String q = "select distinct group_id ,group_name from group_name where group_name like '%" + name + "%';";
               

                stg = db.toRead(q, set);
                HashMap mp = new HashMap();
                int count = 0;
                String egid, this_id;
                while (stg.next()) {
                    HashMap x = new HashMap();
                    egid = en.encription(stg.getString("group_id"));
                    this_id = "srq" + egid;
                    x.put("name", stg.getString("group_name"));
                    if (gw.checkr(li, stg.getString("group_id"))) {
                        x.put("condition", "true");
                    } else {
                        x.put("condition", "false");
                    }
                    x.put("g_id", egid);
                    x.put("this_id", this_id);

                    mp.put(count++, x);

                }
                con.close();
                set.close();
                request.setAttribute("hash", mp);
                if(count!=0)
                request.getRequestDispatcher("WEB-INF/grouppage/searchgroup.jsp").forward(request, response);
                else
                    out.println("NOT FOUND");
            } catch (SQLException ex) {
                Logger.getLogger(searched_group.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           // hs.invalidate();
            out.println("plz login");
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
