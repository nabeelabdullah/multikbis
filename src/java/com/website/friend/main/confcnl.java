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

/**
 *
 * @author nabeel
 */
 public class confcnl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  synchronized protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          DBclass db=DBclass.objectCreater();
          Connection con=db.getConnection();
          Statement set=con.createStatement();
          encription en=encription.createObject();
          HttpSession hs=request.getSession(false);
          work w=work.objectCreater();
          String value=request.getParameter("value").trim();
          String f_id=request.getParameter("f_id");
          int returner=0;
          if((hs!=null)&&(en.validater(f_id)))
          {
              try {
                  f_id=en.decreption(f_id);
                  
                  
                  if(f_id.equals(hs.getAttribute("user_id").toString()))
                  {
                      value="cancel";
                  }
                  String start="('";
                  String end="');";
                  String next ="','";
                  String q="select status from friends where friend_id='"+f_id+"' and user_id='"+hs.getAttribute("user_id")+"';";
                  //out.println(q+"  "+returner);
                  ResultSet st=db.toRead(q,set);
                  if(st.next())
                  { //out.println(1);
                      returner=1;      //there is record
                      if(st.getString("status").equals("1"))
                      {
                          returner=2;             //already friend
                      }
                      else
                          returner=3;              //not friend priviously
                  }
                  if(returner==3)
                  {
                      if(value.equals("confurm"))
                      {
                          // out.println("conf");
                          
                          String id="";
                          String query="select * from friends_table_id_holder";
                          st = db.toRead(query,set);
                          try {
                              st.next();
                              id=st.getString("id");
                              id=w.friend_table_id(id);
                          } catch (SQLException ex) {
                              
                          }
                          
                          
                          query="update friends set status='1' where user_id='"+hs.getAttribute("user_id")+"' and friend_id='"+f_id+"';";
                          
                          db.toUpdate(query,set);
                          
                          
                          query="insert into friends values"+start+id+next+f_id+next+hs.getAttribute("user_id")+next+1+end;
                          db.toWrite(query,set);
                          query="update friends_table_id_holder set id='"+id+"';";
                          db.toWrite(query,set);
                          hs.setAttribute("isfriendempty", "notempty");
                          returner=4;  //confurm sucessful
                      }
                      if(value.equals("cancel"))
                      {
                          //out.println("concle");
                          String query="delete from friends where user_id='"+hs.getAttribute("user_id")+"' and friend_id='"+f_id+"';";
                          
                          db.toDelete(query,set);
                          returner=5;//calcel sucessfull
                      }
                  }
                  con.close();
                  set.close();
              } catch (SQLException ex) {
                  Logger.getLogger(confcnl.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          //stm.close();
          /*
          returner=0 priviously cancle
          returner=1 there is record
          returner=2 //already friend
          returner=3 //not friend priviously
          returner=4 /confurm sucessful
          returner=4 cancle sucessfull
          */
          out.print(returner);
          //out.write(returner);
      } catch (SQLException ex) {
          Logger.getLogger(confcnl.class.getName()).log(Level.SEVERE, null, ex);
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
