/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.new_post;

import com.website.databases.DBclass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import noman_temp.post_file_manager;

/**
 *
 * @author akhtar
 */
public class UploadCancel extends HttpServlet {

            DBclass db;
            Connection con;
            Statement set;
             private String Query1,Query2,Query3,User_id,Post_id,File_name;
             private  ResultSet rs;
            boolean valid=false;
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            db=DBclass.objectCreater();
            con=db.getConnection();
            set=con.createStatement();
            HttpSession hs=request.getSession(false);
            post_file_manager pfm=post_file_manager.objectCreater();
            
            //////out.println(100);
            String which=request.getParameter("which").trim();
            User_id=hs.getAttribute("user_id").toString();
            //////out.println(1);
            Query2="select post_id from attachment where user_id='"+User_id+"';";
            rs=db.toRead(Query2, set);
            //////out.println(2);
            while(rs.next())
            {
            Post_id=rs.getString("post_id");
            }
            //////out.println(3);
            Query1="update attachment set ext2=null,attach='first',no_of_attach=1";
            db.toUpdate(Query1, set);
            valid=pfm.fileDelete(User_id,Post_id, which);
            if(valid)
                out.write("1");
            else
                out.write("0");
            }catch(SQLException qw){} 
          finally {            
                  try {
                        out.close();
                        con.close();
                        set.close();
                        rs.close();
                      } catch (SQLException ex) {}
                  }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
