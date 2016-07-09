package com.website.friend.main;

/*
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
public class sendmsg extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            HttpSession hs=request.getSession(false);
            if(hs!=null){
            encription en =encription.createObject();
            String s_id=request.getParameter("s_id");
            s_id=en.decreption(s_id);
            
             
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            String reciever=hs.getAttribute("user_id").toString();
            String msg ="select * from chat where (s_id='"+s_id+"' or s_id='"+reciever+"') and ( r_id = '"+s_id+"' or r_id = '"+reciever+"');";
           
            ResultSet st= db.toRead(msg,set);
            String max=null;
            String mssg=null;
            int i=0;
            JSONObject js1=new JSONObject(); 
            JSONObject js2=new JSONObject(); 
            while(st.next())
            {
                if(s_id.equals(st.getString("s_id")))
                {  
                   out.write(fromchat(st.getString("msg"))); 
                  
                   // out.write("<div class='chatpara'> <p class='fupara'>Friend:</p>"+st.getString("msg")+"</div><hr/>");
                    //out.write("<div class='chat_devider'></div>");
                  // out.write("<img src='img/122.png' class='chat_devider'/>");
                   
                    max=st.getString("id");
                }
                if(reciever.equals(st.getString("s_id")))
                { 
                    out.write(youchat(st.getString("msg")));
                 // out.write("<div class='chatpara'> <p class='fupara'>You:</p>"+st.getString("msg")+"</div><hr/>");
                  //out.write("<img src='img/122.png' class='chat_devider'/>");
                  //out.write("<div class='chat_devider'></div>");
                  max=st.getString("id");
                }
           
            }
              con.close();
             set.close();
             hs.setAttribute("max_id", max); 
            
         
             
           
           
          
        }
    }
   private String fromchat(String data)
   {
       
       String ret= "<div class='fromyou' >"+
            
                                
                                   " <div class='fromchatimg' >"+
                "<div class='fromchatimgin' >"+
                    "<img src='../img/lpointer.png' class='fromchatimage' />"+
                "</div>"+
            "</div>"+
                "<div class='fromchatcontent' >"+
                "<p  class='fromchatcontentp' >"+data+
                "</p>"+
           " </div>"+
       " </div>";
       return ret;
   }
private String youchat(String data)
{ String ret=                    "<div class='fromyou' >"+
            
                                    "<div class='youchatcontent' >"+
                "<p  class='fromchatcontentp' >"+data+
                "</p>"+
           " </div>"+
                                   " <div class='fromchatimg' >"+
                "<div class='fromchatimgin' >"+
                    "<img src='../img/rpointer.png' class='fromchatimage' />"+
                "</div>"+
            "</div>"+
       " </div>";
               
        
       return ret;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sendmsg.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sendmsg.class.getName()).log(Level.SEVERE, null, ex);
        }
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
