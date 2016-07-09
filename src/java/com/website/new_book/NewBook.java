package com.website.new_book;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.website.databases.*;
import java.io.File;
import noman_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author akhtar
 */
public class NewBook extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize =10000*1024;
    private int maxMemSize =4*1024;
    private File file ;
    String name=null;
    DBclass db;
    Connection con;
    Statement set;
    ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
            
            HttpSession hs=request.getSession(false);
        if(hs!=null)
         {
              try {
                        db=DBclass.objectCreater();
                        con=db.getConnection();
                        set=con.createStatement();
                       date_time dt=date_time.Object_creator();
                       file_manager fm= file_manager.objectCreater();
                       Book_file_manager bfm=Book_file_manager.objectCreater();
                       book_id_genrator big=book_id_genrator.Object_creator();


                       String user_name="";

                       String genrated_id=big.book_id_genrator();
                       String u_id=hs.getAttribute("user_id").toString();
                       String query="select user_name from user_id where user_id='"+u_id+"';";
                       rs=db.toRead(query, set);
                       while(rs.next())
                       {
                           user_name=rs.getString("user_name");
                       }

                       String title=request.getParameter("title").trim();
                       String catagory=request.getParameter("catagory").trim();
                       String college="integral university";
                       String author=request.getParameter("author").trim();
                       String price=request.getParameter("price").trim();
                       String des=request.getParameter("des").trim();
                       String mail=request.getParameter("mail").trim();
                       String mobile=request.getParameter("mob").trim();
                       String address=request.getParameter("address").trim();
                       String validator=request.getParameter("validator");
//                       out.println("valiadator="+validator);
                       String date=dt.get_date();
                       String time=dt.get_time();
                       String day=dt.get_day(date);

                       if(validator.equals("1")) 
                       {
                           try     
                           {

                           bfm.book_creator(u_id, genrated_id);
                           filePath =bfm.return_book_attach(u_id, genrated_id);
                         //  bfm.book_image_copy(filePath);
                           isMultipart = ServletFileUpload.isMultipartContent(request);
                           out.println("is multi  "+isMultipart);
                           DiskFileItemFactory factory = new DiskFileItemFactory();
                           factory.setRepository(null);

                           ServletFileUpload upload = new ServletFileUpload(factory);
                           List<FileItem> list = upload.parseRequest(request);

                           Iterator<FileItem> it123 = list.iterator();

                           byte counter=0;
                           while (it123.hasNext()) 
                                        {
                                          
                                               FileItem fileitem = (FileItem) it123.next();
                                               File file = new File(filePath +(counter++));
                                               fileitem.write(file);
                                              
                                        }


                           }catch(Exception e){out.println("OOPS!");}

                    }
                    else
                    {
                    out.println("1");
                    bfm.book_creator(u_id, genrated_id);
                    out.println("2");
                    String path=bfm.return_book_attach(u_id, genrated_id);
                    out.println("3");
                    bfm.book_image_copy(path);
                    }
                    out.println("4");
                    String first="('";
                    String middle="','";
                    String last="');"; 
                    String query1="insert book_info values"+first+genrated_id+middle+u_id+middle+title+middle+catagory+middle+price+middle+author+middle+college+middle+date+middle+time+last;
                    String query2="insert into book_detail values"+first+genrated_id+middle+user_name+middle+mail+middle+mobile+middle+des+middle+address+last;            
                    out.println(query1+query2);

                    db.toWrite(query1,set);
                    db.toWrite(query2,set);

                               
                }catch(SQLException sq){}
                finally{
                        try {
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
