package com.website.new_post;

import noman_temp.*;
import com.website.databases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import noman_temp.date_time;
import noman_temp.post_id_genrator;

/**
 *
 * @author akhtar
 */
public class NewPost extends HttpServlet {
              DBclass db;
              Connection con;
              Statement set;
              PrintWriter out;
              private  String Query1,Query2,User_id,Post_id;
              private ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
             out = response.getWriter();
           
              HttpSession hs=request.getSession(false);
              StringBuilder sb=new StringBuilder();
              date_time dt=date_time.Object_creator();
              post_file_manager pfm=post_file_manager.objectCreater();
              file_manager fm=file_manager.objectCreater();
              post_id_genrator pig=post_id_genrator.Object_creator();                                                                                                                       
              
              
              String p_time=null,pid="",random="",p_date=null,genrated_post_id="",text_value="",ran="",text_area_value="",ext1="",ext2="";
              String query1="",query2="";
              byte count=0,i=0;
              boolean status=false,valid=false;
              int no_of_attach=0;
              
              
                text_area_value=request.getParameter("text_area_value").trim();
                text_value=request.getParameter("text_value").trim();
                ran=request.getParameter("random").trim();
              
              
    if(text_value!="" && text_area_value!="" && hs!=null)
        {    
             try{
                     db=DBclass.objectCreater();
                     con=db.getConnection();
                     set=con.createStatement();

                     genrated_post_id=pig.post_id_genrator();
                     User_id=hs.getAttribute("user_id").toString();
                     p_date=dt.get_date();
                     p_time=dt.get_time();


                        ////out.println("4444");
                        Query1="select * from attachment where user_id='"+User_id+"';";
                        rs=db.toRead(Query1, set);

                        while(rs.next())
                        { 
                         pid=rs.getString("post_id");
                         random=rs.getString("random");
                         ext1=rs.getString("ext1");
                         ext2=rs.getString("ext2");
                         no_of_attach=rs.getInt("no_of_attach");

                        }


                                   if(ran.equals(random))
                                   { 
                                       ////out.println("!!!!!!");
               //                               
                                             query2="insert into search_record values ('"+pid+"','"+text_value+"','0','"+no_of_attach+"','0','"+p_date+"','"+p_time+"','"+ext1+"','"+ext2+"');";
                                             db.toWrite(query2,set);
                                             status=pfm.new_post_copy(User_id,pid, text_area_value);
                                             Query2="delete from attachment where user_id='"+User_id+"';";
                                             db.toDelete(Query2, set);
                                   }
                                   else
                                   {
                                       ////out.println("*********");
                                       fm.post_creater(User_id, genrated_post_id);
                                       query1="insert into user_post values ('"+User_id+"','"+genrated_post_id+"');";
                                       db.toWrite(query1,set);
                                       query2="insert into search_record values ('"+genrated_post_id+"','"+text_value+"','0','0','0','"+p_date+"','"+p_time+"',null,null);";
                                       db.toWrite(query2,set);
                                       status=pfm.new_post_copy(User_id,genrated_post_id, text_area_value);
                                   }

                                   if(status==true)
                                      out.write("1");

                    }catch (SQLException ex) {}
                     finally
                     {
                         try {
                             con.close();
                             set.close();
                             out.close();
                             rs.close();
                             } catch (SQLException ex) {}
                     }         

                        
              }
              
              
//            sb.append(user_id);
//            sb.append("#");
//            sb.append(text_value);
//            sb.append("#");
//            sb.append(text_area_value);
//            Cookie k1=new Cookie(genrated_post_id, sb.toString());
//            k1.setMaxAge(24*60*30);
//            k1.setValue(sb.toString());
//            response.addCookie(k1);
                 
              
          }catch (IOException io) {}
        
                
         
         
         
         
         
         
         
         
         
         
    
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