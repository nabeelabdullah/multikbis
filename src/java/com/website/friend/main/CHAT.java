package com.website.friend.main;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.website.databases.DBclass;
import nabeel_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
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
 * @author nabeel
 */
public class CHAT extends HttpServlet implements Serializable {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  synchronized protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession hs = request.getSession(false);
            
          DBclass db=null;
          Connection con=null;
          Statement set=null;
            if(hs!=null){
            try {
                encription en=encription.createObject();
                out.println("chat inside");
                String r_id = request.getParameter("r_id");
                r_id=en.decreption(r_id);
                
                //String name=request.getParameter("name");
                String msg = request.getParameter("msg");
                String name = hs.getAttribute("name").toString().toUpperCase();
                //hs.("id", "aasc1234");
                
                String start = "('";
                String end = "');";
                String next = "','";
                db=DBclass.objectCreater();
                con=db.getConnection();
                set=con.createStatement();
                //Statement stm=db.createConnection();
                db.toWrite("lock tables id_holder write",set);
                String query = "select chat_id from id_holder;";
                
                ResultSet st = db.toRead(query,set);
                String k = null;
             
                    
                    st.next();
                    work w = work.objectCreater();
                    k = w.id_creater(st.getString("chat_id"));
                    
                    query = "update id_holder set chat_id='" + k + "';";
                    
                    db.toUpdate(query,set);
                    db.toWrite("unlock tables",set);
                    query = "insert into chat value" + start + hs.getAttribute("user_id") + next + msg + next + r_id + next + k + next + name + end;
                    
                    db.toWrite(query,set);
                    hs.setAttribute("pending_id", k);
                    
                    // out.println(query);
                  con.close();
                  set.close();  
               
            }
            
            
            // db.toUpdate(newquery);
 catch (SQLException ex) {
     
                   Logger.getLogger(CHAT.class.getName()).log(Level.SEVERE, null, ex);

            }
            finally
            {
                 
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
