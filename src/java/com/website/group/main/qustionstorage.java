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
public class qustionstorage extends HttpServlet {

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
                    
                    HttpSession hs=request.getSession(false);
                    boolean done=true;
                    
                    String g_id=request.getParameter("group_id");
                    encription en=encription.createObject();
                    g_id=en.decreption(g_id);
                    String content =request.getParameter("content");
                    content=content.replaceAll("AND","&");
                    PathCreater pc=PathCreater.objectCreater();
                    DBclass db=DBclass.objectCreater();
                    Connection con=db.getConnection();
                    Statement set=con.createStatement();
                    String query="select id from question_id_holder;";
                    ResultSet st=db.toRead(query,set);
                    
                    String id="";
                    
                    try {
                        //     out.println("1");
                        st.next();
                        id=st.getString("id");
                        
                    } catch (SQLException ex) {
                        done=false;
                    }
                    // out.println("2");
                    work w=work.objectCreater();
                    groupWork lo=groupWork.objectCreater();
                    
                    String qus_id=w.id_creater(id);
                    
                    
                    String  path=pc.questionPathCreater(g_id, qus_id);
                    done= lo.copyIntoFlle(path, content);
                    // out.println("3");
                    path=lo.fileReplacerForDB(path);
                    if(done)
                    {
                        query="insert into group_question value('"+hs.getAttribute("user_id")+"','"+g_id+"','"+qus_id+"',"+0+");";
                        db.toWrite(query,set);
                        query="update question_id_holder set id='"+qus_id+"'";
                        db.toWrite(query,set);
                    }
                      con.close();
                    set.close();;
                    
                    String m="questionhandler?g_id="+request.getParameter("group_id");
                    response.sendRedirect(m);
//                if(done)
//                    out.write("done");
//                else
//                    out.write("fail");
                 
                    
                } catch (SQLException ex) {
                    Logger.getLogger(qustionstorage.class.getName()).log(Level.SEVERE, null, ex);
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
