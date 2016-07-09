/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.book;

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
public class SearchingBook extends HttpServlet {

                 Connection con;
                 Statement set;
                 ResultSet sr1;
                 DBclass db;
    
    
    
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
            
            
            String query1="", book_id="",user_id="",title="",catagory="",b_date="",b_time="",b_day="",u_id="",author="",price="",college="";
            int counter=0,count=0,i=1;
            double d=0;
            sr1=null;
            
            if(hs!=null)
            {
                try{
                        String txt=request.getParameter("search_text");
                        String global=request.getParameter("global");
                        u_id=hs.getAttribute("user_id").toString();
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set=con.createStatement();

                            out.println(txt);
                            out.println(global);
                            query1 ="select distinct book_id,user_id,title,catagory,price,author,college,date,time from book_info where "+global+" like '%"+txt+"%' order by  book_id DESC limit 4;";
                            sr1=db.toRead(query1, set);
                            out.println(query1);

                               while(sr1.next()) 
                               {
                               hm1=new HashMap();
                               book_id=sr1.getString("book_id");
                               user_id=sr1.getString("user_id");
                               title=sr1.getString("title");
                               catagory =sr1.getString("catagory");
                               b_date =sr1.getString("date");
                               price =sr1.getString("price");
                               b_day=dt.get_day(b_date);
                               b_time =sr1.getString("time");
                               author=sr1.getString("author");
                               college=sr1.getString("college");



                                   hm1.put("book_id", en.encription(book_id));
                                   hm1.put("user_id", en.encription(user_id));
                                   hm1.put("title", title);
                                   hm1.put("b_date", b_date);
                                   hm1.put("b_day", b_day);
                                   hm1.put("b_time", b_time);
                                   hm1.put("catagory", catagory);
                                   hm1.put("author", author);  
                                   hm1.put("price", price); 
                                   hm1.put("college", college); 

           ////                                out.println("title="+title);
           ////                                out.println("author"+author);
           ////                                out.println("cata="+catagory);
           ////                                


                               hm2.put(counter, hm1);
                               counter=counter+1;
                               }

                        hs.setAttribute("b_id", book_id);
                        request.setAttribute("e_u_id", en.encription(u_id));
                        request.setAttribute("hash",hm2);
                        out.println(hm2);
                        request.getRequestDispatcher("WEB-INF/book/book_search.jsp").forward(request, response);
             }catch(SQLException sq){}
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
