package com.website.friend.main;/*
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
public class newpendingchat extends HttpServlet {

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
            
            
            HttpSession hs=request.getSession(false);
            if(hs!=null){
            try {
                encription en =encription.createObject();
                //   out.println("1");
                String curr=request.getParameter("current");
                if(!curr.equals("0"))
                    curr=en.decreption(curr);
                
                String s="select * from chat where r_id= '"+hs.getAttribute("user_id")+"' and s_id !='"+curr+"'"+" and id > '"+hs.getAttribute("pending_id")+"' limit 5;";
                
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                String max=hs.getAttribute("pending_id").toString();
                
                JSONObject js=new JSONObject();
                ResultSet st= db.toRead(s,set);
                try {
                    int i=1;
                    while(st.next())
                    {
                        
                        JSONObject js1=new JSONObject();
                        js1.put("s_name",st.getString("name"));
                        js1.put("s_id",en.encription(st.getString("s_id")));
                        js.put("a"+i++, js1);
                        max=st.getString("id");
                        
                    }
                    con.close();
                    set.close();
                    hs.setAttribute("pending_id",max);
                    out.write(js.toString());
                    
                }
                
                catch (SQLException ex) {}
                
                
                
                
                
                
            }
           
            catch (SQLException ex) {Logger.getLogger(newpendingchat.class.getName()).log(Level.SEVERE, null, ex);
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
