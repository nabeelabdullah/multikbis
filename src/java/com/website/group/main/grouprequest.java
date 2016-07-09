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
public class grouprequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession hs=request.getSession(true);
            work w = work.objectCreater();
            encription en=encription.createObject();
            groupWork gw = groupWork.objectCreater();
            PathCreater pc=PathCreater.objectCreater();
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            String group_id = request.getParameter("group_id");
            int countg=0;
            if(en.validater(group_id))
            {
                group_id=en.decreption(group_id);
                String member_id = hs.getAttribute("user_id").toString();//request.getParameter("member_id");
                
                int count = 0;
                String query;
                ResultSet st;
                try {
                    query="select count(*) from group_request where sender_id='"+hs.getAttribute("user_id")+"' and group_id='"+group_id+"';";
                    st= db.toRead(query, set);
                    st.next();
                    countg=st.getInt("count(*)");
                    query = "select count(member_id) from group_member where group_id='" + group_id + "';";
                    
                    st = db.toRead(query,set);
                    st.next();
                    count = st.getInt("count(member_id)");
                    
                } catch (SQLException ex) {
                }
                if(countg==0){
                    if (count == 0) {                                               //if there in no any member in that group
                        
                        query = "insert into group_member value('" + group_id + "','" + member_id + "');";
                        db.toWrite(query,set);
                        out.println("You are member now");
                        
                    } else {                                                        //if there is some member in that group
                        
                        String filepath = pc.requestPathCreater(group_id, member_id);
                        // out.write(filepath);
                        
                        gw.copyIntoFlle(filepath, member_id);
                        
                        filepath = gw.fileReplacerForDB(filepath);
                        
                        query = "insert into group_request value('" + member_id + "','" + group_id + "','" + 0 + "','" + 0 + "')";//,'" + filepath + "');";
                        // out.println(query);
                        db.toWrite(query,set);
                        out.println("Request hs been send");
                    }
                }
                
                else
                {
                    out.println("Already request pending");
                }
                
            }
            else
                out.println("wrong id");
            con.close();
           set.close();

        } catch (SQLException ex) {
            Logger.getLogger(grouprequest.class.getName()).log(Level.SEVERE, null, ex);
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
