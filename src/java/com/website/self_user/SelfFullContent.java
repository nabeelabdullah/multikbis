package com.website.self_user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import nabeel_temp.encription;
import noman_temp.post_file_manager;


/**
 *
 * @author akhtar
 */
public class SelfFullContent extends HttpServlet {
        DBclass db;
        Connection con;
        Statement set;
        ResultSet rs;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        HttpSession hs=request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(hs!=null)
        {
            try {
                        db=DBclass.objectCreater();
                        con=db.getConnection(); 
                        set=con.createStatement();
                        encription en=encription.createObject();
                        post_file_manager pfm=post_file_manager.objectCreater();

                        String u_id=request.getParameter("user_id").trim();
                        String p_id=request.getParameter("post_id").trim();
                        u_id=en.decreption(u_id);
                        p_id=en.decreption(p_id);

                        String quary ="select s.topic,s.post_id,u.user_id from search_record as s inner join user_post as p inner join user_id as u on(s.POST_ID=p.POST_ID and p.user_ID=u.user_ID) where (u.user_ID='"+u_id+"' and p.POST_ID='"+p_id+"');";
                        rs=db.toRead(quary,set);
                        StringBuilder sb=new StringBuilder();

                        rs.next(); 
                        String post_id=rs.getString("POST_ID");
                        sb.append(en.encription(rs.getString("user_ID")));
                        sb.append("#");
                        sb.append(rs.getString("TOPIC"));
                        sb.append("#");

                        String post=pfm.full_post_reader(u_id, p_id);
                        sb.append(post); 
                //             Cookie k=new Cookie(post_id, sb.toString()); 
                //             k.setMaxAge(24*60*30);       
                //             response.addCookie(k);
                         out.println(sb.toString());
                         
            }catch (SQLException ex) {}
            finally
            {
               try {
                   con.close();
                   set.close();
                   rs.close();

                   } catch (SQLException ex) {}
            }            
                         
        }
        else
        {
           request.getRequestDispatcher("Login").forward(request, response);  
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
