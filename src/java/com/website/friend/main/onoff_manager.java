package com.website.friend.main;

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
 * @author nabeel
 */
public class onoff_manager extends HttpServlet {

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
           if(hs!=null){
            try {
                encription en=encription.createObject();
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                String query="select o.user_id from on_off as o inner join friends as f on(f.friend_id=o.user_id) where o.status='1' and f.user_id ='"+hs.getAttribute("user_id")+"';";
                ResultSet st=db.toRead(query,set);
                JSONObject js=new JSONObject();
                int i=0;
                try {
                    while(st.next())
                    {
                        js.put("a"+i, "sp"+en.encription(st.getString("user_id")));
                        i++;
                    }
                    //set.close();
                } catch (SQLException ex) {
                    con.close();
                    set.close();
                }
                 con.close();
                  set.close();
                out.write(js.toString());
                //stm.close();
               
            } catch (SQLException ex) {
                Logger.getLogger(onoff_manager.class.getName()).log(Level.SEVERE, null, ex);
               
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
