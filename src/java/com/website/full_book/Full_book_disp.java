/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.full_book;

import com.website.databases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nabeel_temp.encription;
import noman_temp.*;

/**
 *
 * @author akhtar
 */
public class Full_book_disp extends HttpServlet {
DBclass db;
Connection con;
Statement set;
ResultSet sr1;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
       
            HttpSession hs=request.getSession(false);
            StringBuffer sb;
            date_time dt=date_time.Object_creator();
            HashMap hm1;
            HashMap hm2=new HashMap();
            HashMap hm4=null;
            encription en=encription.createObject();
            
            
            String query1="", book_id="",user_id="",address="",title="",email="",mobile="",seller_name="",description="",catagory="",b_date="",b_time="",b_day="",u_id="",author="",price="",college="";
            int counter=0,count=0,i=1;
            double d=0;
          
             user_id=request.getParameter("uiid").trim();
             book_id=request.getParameter("biid").trim();
            if((hs!=null) && (en.validater(user_id)&&(en.validater(book_id))))
            {
                try {   
                        u_id=hs.getAttribute("user_id").toString();
                        user_id=en.decreption(user_id);
                        book_id=en.decreption(book_id);

                            db=DBclass.objectCreater();
                            con=db.getConnection();
                            set=con.createStatement();
                            
                            query1 ="select  i.title,i.book_id,i.user_id,i.catagory,i.price,i.author,i.college,i.date,i.time,d.mobile,d.description,d.email,d.user_name,d.address from book_info as i inner join book_detail as d on(i.book_id=d.book_id) where i.book_id='"+book_id+"' and i.user_id='"+user_id+"'order by  i.book_id DESC limit 1;";
                            sr1=db.toRead(query1, set);        
                               sr1.next();
                               hm1=new HashMap();
                               book_id=sr1.getString("book_id");
                               user_id=sr1.getString("user_id");
                               title=sr1.getString("title");
                               seller_name=sr1.getString("user_name");
                               catagory =sr1.getString("catagory");
                               email =sr1.getString("email");
                               mobile =sr1.getString("mobile");
                               description =sr1.getString("description");
                               b_date =sr1.getString("date");  
                               price =sr1.getString("price");
                               b_day=dt.get_day(b_date);
                               b_time =sr1.getString("time");
                               author=sr1.getString("author");
                               college=sr1.getString("college");
                               address=sr1.getString("address");

                                   hm1.put("book_id", en.encription(book_id));
                                   hm1.put("user_id", en.encription(user_id));
                                   hm1.put("title", title);
                                   hm1.put("email", email);
                                   hm1.put("mobile", mobile);
                                   hm1.put("seller_name", seller_name);
                                   hm1.put("description", description);
                                   hm1.put("b_date", b_date);
                                   hm1.put("b_day", b_day);
                                   hm1.put("b_time", b_time);
                                   hm1.put("catagory", catagory);
                                   hm1.put("author", author);  
                                   hm1.put("price", price); 
                                   hm1.put("college", college); 
                                   hm1.put("address", address); 

                               hm2.put(counter++, hm1);               

                        request.setAttribute("b_u_id", en.encription(user_id));
                        request.setAttribute("e_u_id", en.encription(u_id));
                        request.setAttribute("hash",hm2);
                        request.getRequestDispatcher("WEB-INF/full_book/full_book.jsp").forward(request, response);

                }catch (SQLException e){ }  
                finally{
                        try {
                            con.close();
                            set.close();
                            sr1.close();
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
