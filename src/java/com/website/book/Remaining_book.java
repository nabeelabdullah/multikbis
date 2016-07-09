/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.book;

import com.website.databases.DBclass;
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
import noman_temp.date_time;

/**
 *
 * @author akhtar
 */
public class Remaining_book extends HttpServlet {

    DBclass db;
    Connection con;
    Statement set;
    ResultSet sr1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
            PrintWriter out=out =response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            
            HttpSession hs = request.getSession(false);
            StringBuffer sb;
            date_time dt = date_time.Object_creator();
            HashMap hm1;
            HashMap hm4 = null;
            HashMap hm2 = new HashMap();
            encription en = encription.createObject();

            String query1 = "", book_id = "", user_id = "", title = "", catagory = "", b_date = "", b_time = "", b_day = "", u_id = "", author = "", price = "", college = "";
            int counter = 0, value = 1, count = 0, setter = 0,i=0;  
            if (hs != null) 
            {
                try{
                        String val = request.getParameter("value");
                        value = Integer.parseInt(val);
                        int h = value;
                        value = (value * 10) - 10;
                        count = Integer.parseInt(hs.getAttribute("count").toString());

                        hm4 = new HashMap();
                        for (i = h; i <= count && i <= h +6; i++) 
                        {
                            hm4.put(i, i);
                        }
                        if(h==1)
                        {
                            request.setAttribute("b_valid", "0");
                            hs.setAttribute("bck", h);
                        }
                        else
                        {
                        request.setAttribute("b_valid", "1");
                        hs.setAttribute("bck", (h-1));
                        }

                        u_id = hs.getAttribute("user_id").toString();

                            db=DBclass.objectCreater();
                            con=db.getConnection();
                            set=con.createStatement();
                            query1 = "select distinct book_id,user_id,title,catagory,price,author,college,date,time from book_info order by  book_id DESC limit " + value + ",10;";
                            sr1 = db.toRead(query1, set);

                            while (sr1.next()) {
                                hm1 = new HashMap();
                                book_id = sr1.getString("book_id");
                                user_id = sr1.getString("user_id");
                                title = sr1.getString("title");
                                catagory = sr1.getString("catagory");
                                b_date = sr1.getString("date");
                                price = sr1.getString("price");
                                b_day = dt.get_day(b_date);
                                b_time = sr1.getString("time");
                                author = sr1.getString("author");
                                college = sr1.getString("college");

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


                                hm2.put(counter++, hm1);

                            }

                        request.setAttribute("e_u_id", en.encription(u_id));
                        request.setAttribute("hash", hm2);
                        request.setAttribute("cnt", hm4);
                        request.getRequestDispatcher("WEB-INF/book/remaining_book.jsp").forward(request, response);

                }catch(SQLException sql){}
                finally{
                     try {
                         out.close();
                         set.close();
                         con.close();
                         sr1.close();
                         } catch (SQLException ex) {}
                       }  
                
            } 
            else 
            {
                request.getRequestDispatcher("Login").forward(request, response);
            }
    
       
       
    }


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
