/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.comment;

import com.website.databases.*;
import nabeel_temp.encription;
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
import noman_temp.comment_file_manager;
import noman_temp.comment_id_genrator;
import noman_temp.date_time;

/**
 *
 * @author akhtar
 */
public class new_comment extends HttpServlet {
Connection con;
Statement set;
ResultSet rs;
DBclass db;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            comment_id_genrator cig=comment_id_genrator.Object_creator();
            date_time dt=date_time.Object_creator();
            HttpSession hs=request.getSession(false);
            comment_file_manager cfm=comment_file_manager.objectCreater();
            encription e=encription.createObject();
            
            
            String txt_value=null,user_id=null,post_id=null,date=null,time=null;
            String query1=null,query2=null,query3=null,query4=null,genrated_comment_id=null,u_id="",e_u_id="",e_user_id="",e_post_id="";
            int total_comment=0;
           
            
            txt_value=request.getParameter("txt_val").trim();
            e_post_id=request.getParameter("pid").trim();
            e_user_id=request.getParameter("uid").trim();
            
            if((hs!=null)&& (e.validater(e_user_id)))
            {
                try {
                    post_id=e.decreption(e_post_id);
                    user_id=e.decreption(e_user_id);
                    
                    u_id=hs.getAttribute("user_id").toString().trim();
                    genrated_comment_id=cig.comment_id_genrator();
                    date=dt.get_date();
                    time=dt.get_time();
                    
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set=con.createStatement();
                    query1="insert into user_comment values('"+post_id+"','"+genrated_comment_id+"');";
                    query2="insert into comment_record values('"+genrated_comment_id+"','"+u_id+"','"+date+"','"+time+"',0);";
                    query3="select total_comment from search_record where post_id='"+post_id+"';";
                    rs=db.toRead(query3, set);
                    
                        rs.next();
                    total_comment=Integer.parseInt(rs.getString("total_comment"));
                    
                    total_comment=total_comment+1;
                    query4="update search_record set total_comment='"+total_comment+"' where post_id='"+post_id+"';";
                    db.toWrite(query4, set);
                    db.toWrite(query1, set);
                    db.toWrite(query2, set);
                                    
                    cfm.comment_creater(user_id, post_id, genrated_comment_id);
                    boolean b=cfm.comment_writer(user_id, post_id, genrated_comment_id, txt_value);
                   
                    if(b)
                    {
                    out.println(" <div class=\"c_footer_1\">\n" +
"                                    <div class=\"c_footer_1_left\">\n" +
"                                        <img src='post_image_manager?uiid="+e.encription(u_id)+"' height=\"100%\" width=\"100%\"/>\n" +
"                                    </div>\n" +
"                                    <div class=\"c_footer_1_right\">   \n" +
"                                        <p class=\"content_para\"> \n" +
"                                            "+txt_value+"\n" +
"                                        </p>\n" +
"                                        <p class=\"date_para\"> "+date+" at  "+time+" <b class=\"_comment_like\" id=\""+e.encription(genrated_comment_id)+"cmt_likes_para\"   onclick=\"cmt_like_sender('"+e.encription(user_id)+"','"+e.encription(post_id)+"','"+e.encription(genrated_comment_id)+"']}');\" style=${x2.value['style']}>Like:</b> <h id=\""+e.encription(genrated_comment_id)+"cmt_likes\" >0</h></p>\n" +
"                                    </div>\n" +
"                                </div>");
                     }
                  
                } catch (SQLException ex) {}
                finally{
                       try {
                           con.close();
                           set.close();
                           rs.close();
                           } 
                       catch (SQLException ex) {}
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
