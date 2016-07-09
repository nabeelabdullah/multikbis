package com.website.friend.handler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.website.databases.DBclass;
import nabeel_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
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
public class friendrehandler extends HttpServlet {

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
        HttpSession hs = request.getSession(false);
        if ( hs!=null){

            try {
                
                String name = request.getParameter("name");
                
                hs.setAttribute("f_friend_id", "0");
                hs.setAttribute("f_friend_processing", "no");
                
                groupWork gww = groupWork.objectCreater();
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                PathCreater pc = PathCreater.objectCreater();
                encription en = encription.createObject();
                genralwork gw=genralwork.bojectCreater();
                try {
                    
                    String query = "select * from user_id as u  where u.user_name like '%" + name + "%' and user_id>'" + hs.getAttribute("f_friend_id") + "' limit 10;";
                    
                    ResultSet st = db.toRead(query, set);
                    
                    int count = 0;
                    HashMap mp = new HashMap();
                    String a, last = hs.getAttribute("f_friend_id").toString();;
                    while (st.next()) {
                        HashMap x = new HashMap();
                        last = st.getString("user_id");
                        a = en.encription(st.getString("user_id"));
                        x.put("1", a);
                        x.put("2", a);
                        x.put("3", gw.nameFormater(st.getString("user_name")));
                        x.put("4", "foot" + a);
                        mp.put(count++, x);
                        
                    }
                    request.setAttribute("hash", mp);
                    hs.setAttribute("f_friend_id", last);
                    con.close();
                    set.close();
                    if (count != 0) {
                        request.getRequestDispatcher("WEB-INF/NABEEL/friendreq.jsp").forward(request, response);
                    } else {
                        hs.setAttribute("f_friend_processing", "yes");
                        out.println("<div style='height:70px;width:100%;margin: 0; '> <p style=\"text-align: center;font-family: sans-serif; font-weight: bold;margin-top: 40px;\">Not Found</p></div>");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(friendrescroller.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                Logger.getLogger(friendrehandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //hs.invalidate();
            request.getRequestDispatcher("userlogin").forward(request, response);
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
