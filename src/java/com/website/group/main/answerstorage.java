/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.group.main;

import com.website.databases.DBclass;
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
 * @author NABEEL
 */
public class answerstorage extends HttpServlet {
DBclass db;
Connection con;
Statement set;
ResultSet st;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                encription en=encription.createObject();
                HttpSession hs=request.getSession(true);
                boolean done=true;
                // out.println("1");
                String g_id=en.decreption(request.getParameter("group_id"));
                String q_id=en.decreption(request.getParameter("q_id"));
                String content =request.getParameter("content");
                content=content.replaceAll("AND","&");
                
                db=DBclass.objectCreater();
                con=db.getConnection();
                set=con.createStatement();
                PathCreater pc=PathCreater.objectCreater();
                String query="select id from answer_id_holder;";
                st=db.toRead(query,set);
                // out.println("2");
                String id="";
                
                try {
                    //     out.println("1");
                    st.next();
                    id=st.getString("id");
                    
                } catch (SQLException ex) {
                    done=false;
                }
                // out.println("2");
                work w=work.objectCreater();
                groupWork lo=groupWork.objectCreater();
                
                String ans_id=w.id_creater(id);
                
                // String path="D:\\myproject\\group\\answer\\"+g_id+"\\"+ans_id;
                String  path=pc.answerPathCreater(g_id, ans_id);//"D:\\myproject\\group\\"+g_id+"\\answer\\"+ans_id;
                done= lo.copyIntoFlle(path, content);
                // out.println("3");
                path=lo.fileReplacerForDB(path);
                if(done)
                {
                    query="insert into group_answer value('"+ans_id+"','"+q_id+"','"+hs.getAttribute("user_id")+"');";
                    db.toWrite(query,set);
                    query="update answer_id_holder set id='"+ans_id+"'";
                    db.toWrite(query,set);
                    query="update group_question set answer_no=answer_no+1 where question_id='"+q_id+"';";
                    db.toWrite(query,set);
                }
                String sender="answerhandler?q_id="+request.getParameter("q_id")+"&group_id="+request.getParameter("group_id");
                response.sendRedirect(sender);
//           if(done)
//             out.write("done");
//           else
//            out.write("fail");
//           out.println(content);
//        try {
//            set.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(answerstorage.class.getName()).log(Level.SEVERE, null, ex);
//        }
            }catch(SQLException sq){}
            finally{
                    try {
                         st.close();
                         con.close();
                         set.close();

                        } catch (SQLException ex) {}
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
