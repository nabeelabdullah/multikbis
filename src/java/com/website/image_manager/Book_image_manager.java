/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.image_manager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nabeel_temp.encription;
import noman_temp.Book_file_manager;
import noman_temp.utility;

/**
 *
 * @author akhtar
 */
public class Book_image_manager extends HttpServlet {

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
        
        String u_id="",path="",book_id="";
        
        encription en = encription.createObject();
        HttpSession hs=request.getSession();
        Book_file_manager bfm=Book_file_manager.objectCreater();

        
          book_id=request.getParameter("biid");
          u_id=request.getParameter("uiid");
          path=bfm.return_book_attach(en.decreption(u_id),en.decreption(book_id));
         // out.println(path);
         if(en.validater(book_id))
         {
            File Img = new File(path+"0");
            if(!Img.exists())
            {
                Img=new File(utility.objectCreator().utility_reader("path")+File.separator+"default/defaultBook.png");
            }
                
            BufferedInputStream bin=new BufferedInputStream(new FileInputStream(Img));

            response.reset();
            response.setContentType("image/jpeg");
            int i;
            while((i=bin.read())!=-1)
               response.getOutputStream().write(i);

            //response.getOutputStream().write(imageBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
         else
         { 
        //out.println("wrong path");
             
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
