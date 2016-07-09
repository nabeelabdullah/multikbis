/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.group.handler;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NABEEL
 */
public class answerhandler extends HttpServlet {

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
            encription en = encription.createObject();
            HttpSession hs = request.getSession(false);
            String e_qid = request.getParameter("q_id");
            String group_id = request.getParameter("group_id");

            if (hs!=null) {
                if (en.validater(e_qid) && en.validater(group_id)) {
                    try {
                        String q_id = en.decreption(e_qid);
                        String  dgroup_id = en.decreption(group_id);
                        
                    
                      DBclass db=DBclass.objectCreater();
            Connection con=db.getConnection();
            Statement set=con.createStatement();
                        ResultSet stg;
                        PathCreater pc=PathCreater.objectCreater();
                        
                        String m="select group_id from group_member where member_id='" +hs.getAttribute("user_id")+"'";
                        List<String> li=new ArrayList<String>();
                        stg=db.toRead(m,set);
                        groupWork w=groupWork.objectCreater();
                        while(stg.next())
                        {
                            li.add(stg.getString("group_id"));
                        }
                        String query="select u.user_name,u.user_id,a.answer_id from user_id as u inner join group_answer as a on(u.user_id=a.answer_by) where a.question_id='"+q_id+"';";
                        
                        stg=db.toRead(query,set);
                        
                        String path=pc.questionPathCreater(dgroup_id, q_id);
                        request.setAttribute("content", w.contentInFile(path));
                        HashMap hm=new HashMap();
                        int i=0;
                         if(w.checkr(li, dgroup_id))
                            {
                              request.setAttribute("condition", "true");
                            }
                            else
                                request.setAttribute("condition", "false");
                        
                        while(stg.next())
                        {
                            HashMap x=new HashMap();
                            x.put("1",w.contentInFile(pc.answerPathCreater(dgroup_id, stg.getString("answer_id"))));
                            x.put("2",en.encription(stg.getString("user_id")));
                            x.put("3",stg.getString("user_name"));
                           
                        
                            hm.put(i++, x);
                        }
                        con.close();
                        set.close();
                        request.setAttribute("gid", group_id);
                        request.setAttribute("qid", e_qid);
                        request.setAttribute("hash", hm);
                        request.getRequestDispatcher("WEB-INF/NABEEL/answer.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(answerhandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    out.println("wrong id");
                }
            } else {
                
               
                  //  hs.invalidate();
                request.getRequestDispatcher("Login").forward(request, response);
                    //out.println("plz login");
                
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
