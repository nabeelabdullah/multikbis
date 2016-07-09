/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mailsendRedirect;

import com.website.databases.DBclass;
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
import nabeel_temp.encription;
import nabeel_temp.genralwork;

/**
 *
 * @author akhtar
 */
public class redirecter extends HttpServlet {

      Connection con;
      Statement set;
      DBclass db;
      encription en;
      ResultSet st;
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            db=DBclass.objectCreater();
            con=db.getConnection();
            set=con.createStatement();
            en = encription.createObject();  
            String user_id=request.getParameter("uid");
           
                        String q2="select user_name from user_id where user_id='"+en.decreption(user_id)+"';";
                           // out.println(q2);
                           st = db.toRead(q2, set);
                           if(st.next())
                           {
                                request.setAttribute("name", genralwork.bojectCreater().nameFormater(st.getString("user_name")));
                                request.setAttribute("img",user_id);
                                request.getRequestDispatcher("/group_info/changepass.jsp").forward(request, response);
                                
                           }
                          
                        
        }catch(IOException io){}catch(SQLException sql){} finally {            
            try {
                out.close();
                con.close();
                set.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(redirecter.class.getName()).log(Level.SEVERE, null, ex);
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
