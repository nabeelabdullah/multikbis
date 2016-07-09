package com.website.friend.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class createprofile1 extends HttpServlet {

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
                String sch_from=request.getParameter("sch_from");//.toUpperCase();
                String sec_from=request.getParameter("sec_from");//.toUpperCase();
                String contact=request.getParameter("contact");//.toUpperCase();
                String status=request.getParameter("status");//.toUpperCase();
                String a_o_e=request.getParameter("a_o_e");//.toUpperCase();
                String collage=request.getParameter("collage");//.toUpperCase();
                String live_in=request.getParameter("live_in");//.toUpperCase();
                String found_off=request.getParameter("found_off");//.toUpperCase();
                String course=request.getParameter("course");//.toUpperCase();
                String branch=request.getParameter("branch");//.toUpperCase();
                
                out.println(sch_from+" "+sec_from+" "+contact+" "+status+" "+a_o_e+" "+collage+" "+live_in+" "+found_off+" "+course+" "+branch);
                
                
                String query="update user_profile set sch_from='"+sch_from+"', sec_from='"+sec_from+"', contact='"+contact+"',status='"+status+"',a_o_e='"+a_o_e+"',collage='"+collage+"',live_in='"+live_in+"',found_off='"+found_off+"',course='"+course+"',branch='"+branch+"' where user_id='"+hs.getAttribute("user_id")+"';";
                
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                db.toWrite(query,set);
                
                con.close();
                set.close();
                request.getRequestDispatcher("createprofile_handler").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(createprofile1.class.getName()).log(Level.SEVERE, null, ex);
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
