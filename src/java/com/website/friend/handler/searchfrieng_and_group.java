package com.website.friend.handler;

/*
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
 * @author nabeel
 */
public class searchfrieng_and_group extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession(false);

        /**
         * Condition true if session is old *
         */
        if (hs!=null) {

            /**
             * Object creation process end*
             */

            try {
                
                /**
                 * Object creation process *
                 */
                PathCreater pc = PathCreater.objectCreater();
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                encription en = encription.createObject();
                genralwork gw=genralwork.bojectCreater();
                /**
                 * Object creation process end*
                 */
                
                try {
                    
                    String name = request.getParameter("name");       /* Name of person to look for */
                    
                    String query = "select b.table_id ,a.user_name,a.user_id from user_id as a inner join friends as b  on(a.user_id=b.friend_id) where (b.user_id='" + hs.getAttribute("user_id") + "' and b.status='1'" + " and a.user_name like '%" + name + "%'" + " )limit 5;";
                    
                    ResultSet st = db.toRead(query, set);
                    
                    int counter = 0;                             /*Count is use for nested hashmap */
                    
                    String a, b, table_id = "";                 /*a for encripted user_id and b for user_name */
                    
                    HashMap mp = new HashMap();
                    while (st.next()) {
                        
                        HashMap x = new HashMap();
                        a = en.encription(st.getString("user_id"));
                        b = gw.nameFormater(st.getString("user_name"));
                        x.put("1", "sp" + a);
                        x.put("2",a);// pc.profilePicsPathCreater(st.getString("user_id")));
                        x.put("3", a);
                        x.put("4", b);
                        mp.put(counter++, x);
                        table_id = st.getString("table_id");
                    }
                    hs.setAttribute("last_friendid", table_id);
                    hs.setAttribute("remainingfriends", "notrunning");
                    hs.setAttribute("isfriendempty", "notempty");
                    request.setAttribute("hash", mp);
                    con.close();
                    set.close();
                    if (counter != 0) {
                        request.getRequestDispatcher("WEB-INF/NABEEL/searchfriend_and_group.jsp").forward(request, response);
                    } else {
                        out.println("no record");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(searchfrieng_and_group.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                Logger.getLogger(searchfrieng_and_group.class.getName()).log(Level.SEVERE, null, ex);
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
