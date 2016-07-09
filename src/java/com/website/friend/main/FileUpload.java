package com.website.friend.main;




import com.website.databases.database;
import com.website.databases.my_database;
import nabeel_temp.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import noman_temp.img_creator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author basheer
 */
public class FileUpload extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize =1000*1024;
    private int maxMemSize =4*1024;
    private File file ;
    String name=null;
     String date;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
           
            groupWork w=groupWork.objectCreater();
            PathCreater pc=PathCreater.objectCreater();
            HttpSession hs=request.getSession(false);
        //    filePath ="/home/nabeel/NetBeansProjects/myproject/web/img/";//getServletContext().getInitParameter("file-upload");
            String u_id=hs.getAttribute("user_id").toString();
            filePath =pc.forfileupload(u_id);//"/home/nabeel/Pictures/myproject12/web/img/";
            isMultipart = ServletFileUpload.isMultipartContent(request);
          
            DiskFileItemFactory factory = new DiskFileItemFactory();
           
            factory.setSizeThreshold(maxMemSize);
           
              //File f=new File("/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com/temp");
            //FileOutputStream fos=new FileOutputStream(f);
          
            factory.setRepository(null);
         
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            upload.setSizeMax( maxFileSize );
          
            try{ 
               //out.println("1");
                List fileItems = upload.parseRequest(request);
                //out.println("2");
                Iterator i = fileItems.iterator();
               
                while (i.hasNext()){
                   //out.println("3");
                    FileItem fi = (FileItem)i.next();
                    
                    if (!fi.isFormField()){
                      //out.println("4");
                        String fileName ="profile.jpg";// fi.getName();
                        name=fileName;
                        date=new Date().toString();
                     //temp//      
                        date="";
                        if( fileName.lastIndexOf("/") >= 0 ){
                           
                            file = new File( filePath +date+ 
                            fileName.substring( fileName.lastIndexOf("/"))) ;
                            
                        }else{
                            
                            file = new File( filePath +date+ 
                            fileName.substring(fileName.lastIndexOf("/")+1)) ;
                            
                        }
                      //out.println("5");
                        fi.write( file ) ;
                       
                    }
                }
             }catch(Exception ex) {
               
             }
           img_creator.objectCreater().img_creator(u_id);
           out.println("imagepass?path="+encription.createObject().encription(u_id));
         
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