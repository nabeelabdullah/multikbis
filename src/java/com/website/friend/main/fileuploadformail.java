package com.website.friend.main;




import com.website.databases.database;
import com.website.databases.my_database;
import nabeel_temp.PathCreater;
import nabeel_temp.encription;
import nabeel_temp.groupWork;
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
    private int maxFileSize =1000*1024;
    private int maxMemSize =4*1024;
    private File file ;
    String name=null;
     String date;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
           
            encription en=encription.createObject();
            String to=en.decreption(request.getParameter("to"));
            String sub=request.getParameter("subject");
            String type=request.getParameter("type");
            groupWork w=groupWork.objectCreater();
            PathCreater pc=PathCreater.objectCreater();
            HttpSession hs=request.getSession(true);
        
            
            filePath ="D:\\formail\\";
            isMultipart = ServletFileUpload.isMultipartContent(request);
          
            DiskFileItemFactory factory = new DiskFileItemFactory();
           
            factory.setSizeThreshold(maxMemSize);
           
             // File f=new File("D:\\temp");//("/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com/temp");
       
          
            factory.setRepository(null);
         
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            upload.setSizeMax( maxFileSize );
          
            try{ 
           
                List fileItems = upload.parseRequest(request);
        
                Iterator i = fileItems.iterator();
               
                while (i.hasNext()){
                   //out.println("3");
                    FileItem fi = (FileItem)i.next();
                    
                    if (!fi.isFormField()){
                 
                        String fileName =fi.getName();
                        name=fileName;
                        date=new Date().toString();
               
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
                out.println("24 "+ex);
               
             }
            out.println("done");
//         File fo=new File("");
//         FileOutputStream fout=new FileOutputStream(fo);
//         FileInputStream fin=new FileInputStream(file);
//         int i=0;
//         while((i=fin.read())!=-1)
//             fout.write(i);
//         file.delete();
         
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