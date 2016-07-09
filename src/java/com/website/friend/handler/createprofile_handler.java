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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nabeel
 */
public class createprofile_handler extends HttpServlet {
    Connection con;
    Statement set;
    DBclass db;
    ResultSet st;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    try {
        PrintWriter out = response.getWriter();
        encription en=encription.createObject();
        HttpSession hs = request.getSession(false);
        if (hs!=null)
        {
                String user_id = hs.getAttribute("user_id").toString();
                
                HashMap mp = new HashMap();
                String query = "select * from user_profile as a where a.user_id='" + user_id + "';";
                PathCreater pc = PathCreater.objectCreater();
                db=DBclass.objectCreater();
                con=db.getConnection();
                set=con.createStatement();
                
                groupWork gww = groupWork.objectCreater();
                st = db.toRead(query, set);
             
                    st.next();
                    
                    mp.put("00",en.encription(user_id));
                    mp.put("01", hs.getAttribute("name"));
                    mp.put("02", st.getString("sch_from"));
                    mp.put("03", st.getString("sec_from"));
                    mp.put("04", st.getString("contact"));
                    mp.put("05", st.getString("status"));
                    mp.put("06", st.getString("a_o_e"));
                    mp.put("07", st.getString("collage"));
                    mp.put("08", st.getString("live_in"));
                    mp.put("09", st.getString("found_off"));
                    mp.put("10", st.getString("course"));
                    mp.put("11", st.getString("branch"));
                    
              
                
                request.setAttribute("hash", mp);
                
                out.println("hiiiiiiiii");
                request.getRequestDispatcher("WEB-INF/NABEEL/userprofile.jsp").forward(request, response);
           
        } 
   else {
         request.getRequestDispatcher("Login").forward(request, response);
        } 
 } catch (SQLException ex) {}
    finally
    {
            try {
                con.close();
                set.close();
                st.close();
            } catch (SQLException ex) {}
                
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
