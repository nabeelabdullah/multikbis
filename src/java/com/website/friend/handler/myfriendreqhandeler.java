package com.website.friend.handler;

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

public class myfriendreqhandeler extends HttpServlet {

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
        if (hs!=null) {
            
            try {
                
                groupWork gww = groupWork.objectCreater();
                DBclass db=DBclass.objectCreater();
                Connection con=db.getConnection();
                Statement set=con.createStatement();
                
                PathCreater pc = PathCreater.objectCreater();
                encription en = encription.createObject();
                try {
                    
                    String query = "select a.user_name,a.user_id from user_id as a inner join friends as b on(a.user_id=b.friend_id) where (b.user_id='" + hs.getAttribute("user_id") + "' and b.status='0');";
                    ResultSet st = db.toRead(query, set);
                    int count = 0;
                    HashMap mp = new HashMap();
                    String a;
                    
                    while (st.next()) {
                        HashMap x = new HashMap();
                        
                        a = en.encription(st.getString("user_id"));
                        x.put("1", a);//pc.profilePicsPathCreater(st.getString("user_id")));
                        x.put("2", a);
                        x.put("3", st.getString("user_name").toUpperCase());
                        x.put("4", "ccf" + a);
                        mp.put(count++, x);
                        
                    }
                    request.setAttribute("hash", mp);
                    con.close();
                    set.close();
                    if(count!=0)
                        request.getRequestDispatcher("WEB-INF/NABEEL/myfriendrequest.jsp").forward(request, response);
                    else
                        out.println("<div style='height:70px;width:100%;margin: 0; '> <p style=\"text-align: center;font-family: sans-serif; font-weight: bold;margin-top: 40px;\">No any Friend Request Found</p></div>");
                } catch (SQLException ex) {
                    Logger.getLogger(myfriendreqhandeler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(myfriendreqhandeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
          //  hs.invalidate();
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
