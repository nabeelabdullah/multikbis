/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.friend.main;

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import nabeel_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.reflect.Array.set;
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
import org.json.simple.JSONObject;

/**
 *
 * @author NABEEL
 */
public class NewFriendsNUmbers extends HttpServlet {

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
            HttpSession hs = request.getSession(false);
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            JSONObject js = new JSONObject();
            groupWork gw = groupWork.objectCreater();
            PathCreater pc = PathCreater.objectCreater();
            String path;
            try {
                String query = "select count(*) from friends where user_id='" + hs.getAttribute("user_id") + "' and status='0';";//"select a.user_id from user_id as a inner join friends as b on(a.user_id=b.friend_id) where (b.user_id='" + hs.getAttribute("user_id") + "' and b.status='0');";
                
                
                ResultSet st = db.toRead(query, set);
                int frieng = 0, gre = 0;
                
                if (st.next()) {
                    
                    frieng = st.getInt("count(*)");
                }
                query = "select m.sender_id,m.group_id from group_request as m inner join group_member as gm on(gm.group_id=m.group_id) where gm.member_id='" + hs.getAttribute("user_id") + "';";
                st = db.toRead(query, set);
                
                while(st.next()) {
                    
                    path = pc.requestPathCreater(st.getString("group_id"), st.getString("sender_id"));                   
                    
                    if (!gw.is_Exist(path, hs.getAttribute("user_id").toString())) {
                        
                        gre++;
                        
                        
                    }
                }
                
                js.put("f", frieng);
                js.put("g", gre);
                con.close();
                set.close();
                out.println(js);
            } catch (SQLException ex) {
                Logger.getLogger(NewFriendsNUmbers.class.getName()).log(Level.SEVERE, null, ex);
                
            } finally {
                out.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewFriendsNUmbers.class.getName()).log(Level.SEVERE, null, ex);

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
