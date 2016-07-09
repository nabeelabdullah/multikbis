/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.downloader;
import com.website.databases.DBclass;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import nabeel_temp.encription;
import noman_temp.post_file_manager;

/**
 *
 * @author akhtar
 */
public class downloader extends HttpServlet {
            DBclass db;
            Connection con;
            Statement set;
            ResultSet rs;
            FileInputStream fin;
            BufferedInputStream fb;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
             post_file_manager pfm=post_file_manager.objectCreater();
             encription en= encription.createObject();
             HttpSession hs=request.getSession(false);
             String post_id="",user_id="";
             
            String  e_user_id=request.getParameter("uiid").trim();
            String  e_post_id=request.getParameter("piid").trim();
            String param=request.getParameter("param").trim();
            
            
            if((hs!=null)&& (en.validater(e_post_id))&&en.validater(e_user_id))
            {
                try {
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set=con.createStatement();    

                        post_id=en.decreption(e_post_id);
                        user_id=en.decreption(e_user_id);
                        String ext="";
                        String query="select ext"+param+" from search_record where post_id='"+post_id+"';";
                        rs=db.toRead(query, set);
                        rs.next();
                        ext=rs.getString("ext"+param);

                        String path=pfm.returnAttachPath(user_id, post_id,param);

                        response.reset();
                        String filename="multikbis"+ext;
                        response.setHeader("Content-Disposition","filename="+filename); 
                        fin=new FileInputStream(new File(path));
                        fb=new BufferedInputStream(fin);

                            int i=0;
                            while((i=fb.read())!=-1)
                            {
                                response.getOutputStream().write(i);
                            }

                        response.getOutputStream().close();
                        response.getOutputStream().flush();
                } catch (SQLException ex) {} 
                finally {            
                        try {
                            out.close();
                            fin.close();
                            fb.close();
                            rs.close();
                            con.close();
                            set.close();
                            } catch (SQLException ex) {}
                        }
            }
            else
            { 
                request.getRequestDispatcher("Login").forward(request, response);
            }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
