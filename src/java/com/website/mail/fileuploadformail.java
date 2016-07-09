package com.website.mail;

import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import nabeel_temp.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author basheer
 */
public class fileuploadformail extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 1000 * 1024;
    private int maxMemSize = 10 * 1024;
    private File file;
    String name = null;
    String date;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        encription en = encription.createObject();
        String to = en.decreption(request.getParameter("to"));
        String sub = request.getParameter("subject");
        String type = request.getParameter("type");
        System.out.println("type  "+type);
        groupWork w = groupWork.objectCreater();
        PathCreater pc = PathCreater.objectCreater();
        HttpSession hs = request.getSession(false);
        System.out.println("start file");
        if (hs == null) {
            System.out.println("log out");
        } else {
            System.out.println("log in");
            try {
                DBclass db = DBclass.objectCreater();
                Connection con = db.getConnection();
                Statement set = con.createStatement();
                String query = "";
                if (type.equals("f")) {
                    query = "select email from user_login where user_id='" + to + "';";
                } else if (type.equals("g")) {
                    query = "select l.email from user_login as l inner join group_member as m on(m.member_id=l.user_id) where group_id='" + to + "';";
                }

                System.out.println(query);
                ResultSet st = db.toRead(query, set);
                try {
                    if (st.next()) {
                        to = st.getString("email");
                        while (st.next()) {
                            to = to+"," + st.getString("email");
                            
                        }
                    }
                    System.out.println("rmail  " + to);
                } catch (SQLException ex) {
                    System.out.println("find" + ex);
                    Logger.getLogger(fileuploadformail.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("1");
                filePath = PathCreater.objectCreater().forMailpathcreater(hs.getAttribute("user_id").toString());
                System.out.println("2  " + filePath);
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(null);
                System.out.println("3");
                factory.setSizeThreshold(maxMemSize);
                ServletFileUpload upload = new ServletFileUpload(factory);
                System.out.println("4");
                try {

                    List fileItems = upload.parseRequest(request);

                    Iterator i = fileItems.iterator();

                    while (i.hasNext()) {

                        FileItem fi = (FileItem) i.next();

                        name = fi.getName();

                        file = new File(filePath + name);

                        fi.write(file);

                    }
                } catch (Exception ex) {
                    System.out.println("Exeption is " + ex);
                    out.println("24 " + ex);

                }
                System.out.println("upload successful");
                con.close();
                set.close();
                SendMail sm = new SendMail();
                out.println(hs.getAttribute("name").toString());
                System.out.println(to);
                sm.sendmail(name, file.toString(), to, hs.getAttribute("name").toString(), sub);
                System.out.println("done");
                file.delete();
            } catch (SQLException ex) {
                System.out.println("exeption " + ex);
                Logger.getLogger(fileuploadformail.class.getName()).log(Level.SEVERE, null, ex);
            }
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
