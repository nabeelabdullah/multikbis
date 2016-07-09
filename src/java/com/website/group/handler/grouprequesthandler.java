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
public class grouprequesthandler extends HttpServlet {

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
        HttpSession hs = request.getSession(false);
        if (hs!=null) {
            try {
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                encription en = encription.createObject();
                groupWork gw = groupWork.objectCreater();
                PathCreater pc = PathCreater.objectCreater();
                try {
                    
                    String query = "select distinct m.sender_id,m.group_id, m.accept,m.reject,n.user_name , g.group_name from group_request as m inner join user_id as n  inner join group_name as g inner join group_member as gm on(gm.group_id=m.group_id and m.sender_id=n.user_id and m.group_id=g.group_id) where gm.member_id='" + hs.getAttribute("user_id") + "';";
                    
                    ResultSet st = db.toRead(query, set);
                    int count = 0;
                    String a, b, path,this_id;
                    HashMap mp = new HashMap();
                    while (st.next()) {
                        
                        path = pc.requestPathCreater(st.getString("group_id"), st.getString("sender_id"));
                        
                        if (!gw.is_Exist(path, hs.getAttribute("user_id").toString())) {
                            
                            HashMap x = new HashMap();
                            a = en.encription(st.getString("sender_id"));
                            b = en.encription(st.getString("group_id"));
                            // int m=new Integer(a)+new Integer(b);
                            //this_id=new Integer()
                            x.put("s_id", a);
                            x.put("u_name", st.getString("user_name").toUpperCase());
                            x.put("g_name", st.getString("group_name").toUpperCase());
                            x.put("g_id", b);
                            x.put("id", "gcc" + (a+count));
                            mp.put(count++, x);
                        }
                    }
                    request.setAttribute("hash", mp);
                    con.close();
                    set.close();
                    if (count != 0) {
                        request.getRequestDispatcher("WEB-INF/grouppage/newgrouprequest.jsp").forward(request, response);
                    } else {
                       out.println("<div style='height:70px;width:100%;margin: 0; '> <p style=\"text-align: center;font-family: sans-serif; font-weight: bold;margin-top: 40px;\">No any Group Request Found</p></div>");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(grouprequesthandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(grouprequesthandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //hs.invalidate();
            //  out.println("plz login");
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
