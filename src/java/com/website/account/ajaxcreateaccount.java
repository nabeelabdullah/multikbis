
package com.website.account;
import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author akhtar
 */
public class ajaxcreateaccount extends HttpServlet {
DBclass db;
Connection con;
Statement set;
ResultSet rs;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            db=DBclass.objectCreater();
            con=db.getConnection();
            set=con.createStatement();
            String email=null;
            String s1=request.getParameter("email");
          
                        s1=s1.trim();
                        String s2="select EMAIL from user_login where (EMAIL='"+s1+"')";
                        rs=db.toRead(s2,set);

                        rs.next();
                        email=rs.getString("EMAIL").trim();
                        set.close();
                        con.close();

                        if(email.equals(null))
                        {
                            out.write("");
                        }
                        else
                        {
                            out.write("THIS  EMAIL IS EXIST");
                        }
            
          }catch(SQLException sqle){}
          finally {
                        try {
                            con.close();
                            set.close();
                            rs.close();
                            out.close();
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
