/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.new_post;

import com.website.databases.DBclass;
import noman_temp.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
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
 * @author akhtar
 */
public class NewPostFile extends HttpServlet {

    private boolean isMultipart;
    private String Path;
    private int maxFileSize =300*1024*1024;    //1024*1024 =1mb
    private int maxMemSize =300*1024*1024;
    private File file ;
    private int y;
    private String ext;
    DBclass db;
    Connection con;
    Statement set;
    private String Query1,Query2,Query3,User_id,Post_id,File_name;
    private  ResultSet rs;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
                        HttpSession hs=request.getSession(false);
                        post_file_manager pfm=post_file_manager.objectCreater();
                        post_id_genrator pig= post_id_genrator.Object_creator();
                        file_manager fm=file_manager.objectCreater();

              if(hs!=null)
              {
                  try{
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set=con.createStatement();

                        User_id=hs.getAttribute("user_id").toString();
                        String ran=request.getParameter("random").trim();
                        Post_id=pig.post_id_genrator();

                        String Random=null,Attach="first";


                        Query1="select * from attachment where user_id='"+User_id+"';";
                        rs=db.toRead(Query1, set);
                        while(rs.next())
                        {
                        //out.println("***********************");
                        Random=rs.getString("random");
                        Attach=rs.getString("attach");
                        Post_id=rs.getString("post_id");
                        if(Random.equals(ran))
                        {
                        if(Attach.equals("first"))
                            Attach="second";
                        }
                        else
                        {
                        Attach="first";
                        }
                        //out.println("!!!!!!");
                        }
                        ////out.println("9999999999");
                        fm.post_creater(User_id, Post_id);
                        Path=pfm.attachPath(User_id,Post_id);

                            File f=new File(Path);
                            isMultipart = ServletFileUpload.isMultipartContent(request);
                            DiskFileItemFactory factory = new DiskFileItemFactory();             
                            factory.setSizeThreshold(maxMemSize);
                            factory.setRepository(f);
                            ServletFileUpload upload = new ServletFileUpload(factory);
                            upload.setSizeMax( maxFileSize );
                            ////out.println("1");
                                List fileItems = upload.parseRequest(request);
                                ////out.println("2");
                                Iterator i = fileItems.iterator();

                                while (i.hasNext())
                                {
                                   ////out.println("3");
                                    FileItem fi = (FileItem)i.next();
                                    String fileName = fi.getName();
                                    if (!fi.isFormField())
                                    {
                                            ////out.println("4");
                                            y=fileName.lastIndexOf(".");
                                            ext=fileName.substring(y);
                                            file = new File( Path+File.separator+Attach);

                                        fi.write( file ) ;

                                    }
                                }



                                ////out.println("go");
                       if(Random!=null)
                        {
                             //out.println("second time");
                                if(Random.equals(ran))       
                                {
                                //out.println("random==ran");
                                Query1="update attachment set ext2='"+ext+"',attach='second',no_of_attach=2 where user_id='"+User_id+"' and post_id='"+Post_id+"';";
            //                    ////out.println(Query1);
                                db.toUpdate(Query1, set);
                                }
                                else
                                {
                                  //out.println("random!=ran");
                                  Query1="update attachment set ext1='"+ext+"', ext2=null,random='"+ran+"',attach='first',no_of_attach=1 where user_id='"+User_id+"' and post_id='"+Post_id+"';";
            //                      ////out.println(Query1);
                                  db.toUpdate(Query1, set);   
                                }
                        }
                        else
                        {
                            //out.println("first time");

                        Query3="insert into user_post values ('"+User_id+"','"+Post_id+"');";
                        db.toWrite(Query3,set);

                        Query2="insert into attachment values('"+User_id+"','"+Post_id+"','first','"+ext+"',null,'"+ran+"',1);";
                        db.toWrite(Query2, set);
                        }         

                    }catch(Exception j){} 
                    finally {            
                            try {
                                out.close();
                                con.close();
                                set.close();
                                rs.close();
                                } catch (SQLException ex) {}
                            }
                       
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
