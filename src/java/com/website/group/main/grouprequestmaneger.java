/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.group.main;

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

/**
 *
 * @author NABEEL
 */
public class grouprequestmaneger extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                String value = request.getParameter("value");
                encription en=encription.createObject();
                String group_id = en.decreption(request.getParameter("group_id"));
                String sender_id = en.decreption(request.getParameter("sender_id"));
                PathCreater pc=PathCreater.objectCreater();
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                groupWork gw = groupWork.objectCreater();
                HttpSession hs = request.getSession();
                String query = "select accept,reject from group_request where group_id='" + group_id + "' and sender_id='" + sender_id + "';";
                
                ResultSet st = db.toRead(query,set);
                long count = 0;
                int accept = 0;
                int reject = 0;
                int filedelete = 0;
                String path = "";
                try {
                    st.next();
                    accept = st.getInt("accept");
                    reject = st.getInt("reject");
                    path = pc.requestPathCreater(group_id, sender_id);//st.getString("path");
                    path = gw.fileReplacer(path);
                    
                    if (value.equals("accept")) {
                        query = "update group_request set accept=" + (accept + 1) + " where group_id='" + group_id + "' and sender_id='" + sender_id + "';";
                        accept++;
                        // out.println(query);
                    } else if (value.equals("reject")) {
                        query = "update group_request set reject=" + (reject + 1) + " where group_id='" + group_id + "' and sender_id='" + sender_id + "';";
                        //  out.println(query);
                        reject++;
                    }
                    db.toWrite(query,set);
                    gw.insert_intoFile(path, hs.getAttribute("user_id").toString());
                    query = "select count(member_id) from group_member where group_id='" + group_id + "';";
                    
                    st = db.toRead(query,set);
                    st.next();
                    count = st.getInt("count(member_id)");
                    
                } catch (SQLException ex) {
                }
                
                
                if (100 * accept / count >= 50) {
                    
                    query = "insert into group_member value('" + group_id + "','" + sender_id + "');";
                    db.toWrite(query,set);
                    
                    
                    query = "delete from group_request where group_id='" + group_id + "' and sender_id='" + sender_id + "';";
                    db.toWrite(query,set);
                    //  gw.fileDelete(path);
                    filedelete = 1;
                    
                } else if (100 * reject / count >= 50) {
                    
                    query = "delete from group_request where group_id='" + group_id + "' and sender_id='" + sender_id + "';";
                    db.toWrite(query,set);
                    //  out.println(" from"+ path+" to");
                    gw.fileDelete(path);
                    filedelete = 1;
                    
                }
                // out.write(path);
                if (filedelete==1) {
                    //out.write(path);
                    gw.fileDelete(path);
//            try {
//                //stm.close();
//                set.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(grouprequestmaneger.class.getName()).log(Level.SEVERE, null, ex);
//            }
                }
                con.close();
                set.close();
                out.println("done");
            } catch (SQLException ex) {
            Logger.getLogger(grouprequestmaneger.class.getName()).log(Level.SEVERE, null, ex);
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
