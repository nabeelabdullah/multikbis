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
public class searchedfriend extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String f_id = request.getParameter("f_id");
            //out.println(f_id);
            work w = work.objectCreater();
            HttpSession hs = request.getSession(false);
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            encription en = encription.createObject();
            String data = "val";
            if(hs!=null){
                if (en.validater(f_id)) {
                    f_id = en.decreption(f_id);
                    String r_q = "select * from friends where friend_id='" + hs.getAttribute("user_id") + "' and user_id='" + f_id + "';";
                    ResultSet st = db.toRead(r_q,set);
                    
                    try {
                        if (st.next()) {
                            
                            if (st.getString("status").equals("1")) {
                                data = "af";
                            }
                            else if (st.getString("status").equals("0")) {
                                data = "ap";
                            }
                        }
                    } catch (SQLException ex) {
                        
                    }
                    
                    if (data.equals("val")) {
                        String start = "('";
                        String end = "');";
                        String next = "','";
                        String id = "";
                        String query = "select * from friends_table_id_holder";
                        st = db.toRead(query,set);
                        try {
                            st.next();
                            id = st.getString("id");
                            id = w.friend_table_id(id);
                        } catch (SQLException ex) {
                            
                        }
                        query = "insert into friends values" + start + id + next + f_id + next + hs.getAttribute("user_id") + next + 0 + end;
                        db.toWrite(query,set);
                        query = "update friends_table_id_holder set id='" + id + "';";
                        db.toWrite(query,set);
                        
                    }
                }
                con.close();
                set.close();
                //stm.close();
                if(data.equals("val"))
                    out.write("nf");
                else if(data.equals("ap"))
                    out.write("ap");
                else if(data.equals("af"))
                    out.write("af");
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(searchedfriend.class.getName()).log(Level.SEVERE, null, ex);
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
