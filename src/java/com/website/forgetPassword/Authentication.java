/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.forgetPassword;

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
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
import nabeel_temp.encription;
import nabeel_temp.genralwork;

/**
 *
 * @author NABEEL
 */
public class Authentication extends HttpServlet {

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
            DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
            encription en = encription.createObject();
            try {
                String email = request.getParameter("email");
                
                
                String query = "select user_id from user_login where email ='" + email + "';";
                
                
                ResultSet st = db.toRead(query, set);
                try {
                    if (st.next()) {
                        
                        String user_id = st.getString("user_id");
                        
                        RandomNumberGenrator rd = RandomNumberGenrator.objectCreater();
                        
                        int nonce = rd.newNumber();
                        query = "delete from forget_pass where user_id='" + user_id + "';";
                        db.toWrite(query, set);
                        query = "insert into forget_pass value('" + user_id + "','" + nonce + "');";
                        
                        db.toWrite(query, set);
                        String e_userID=en.encription(user_id);
                        
                        //String m = "<a href='www.multikbis.com/PasswordReseter?u=" + e_userID + "&n=" + nonce + "'>click here to change password<a>";
                        //String k="send";//com.website.forgetPassword.Mailer.send(email, m,"Change Password");
                        //sendmailForPass s=new sendmailForPass();
                        //s.sendmail(email, m);
                       response.sendRedirect("http://multikbismail-nomannabeel.rhcloud.com/mailme?mail="+email+"&uid="+e_userID+"&nonce="+nonce);
                         
//                        if(k.equals("send")){
    //                           out.println("hello");
    //                           String q2="select user_name from user_id where user_id='"+user_id+"';";
    //                           out.println(q2);
    //                           st = db.toRead(q2, set);
    //                           out.println("hello1");
//                           if(st.next())
//                           {
//                                request.setAttribute("name", genralwork.bojectCreater().nameFormater(st.getString("user_name")));
//                                out.println("hello2");
//                                request.setAttribute("img",e_userID );
//                                out.println("nabeel");
//                                request.getRequestDispatcher("/group_info/changepass.jsp").forward(request, response);
//                            
//                           }
//                            out.println("varification has sent to your Email ");
//                        }
//                        else
//                            out.println(k);
                        
                    }
                    else
                    {
                        out.println("your are not in our list <a href='http://multikbis.com/Signup'>click here</a> for signup in www.multikbis.com");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } finally {
                out.close();
            }
            con.close();
            set.close();
        }   catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
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
