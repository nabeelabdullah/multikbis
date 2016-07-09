package com.website.account;



import com.website.databases.DBclass;
import com.website.databases.database;
import com.website.databases.my_database;
import nabeel_temp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author akhtar
 */
public class userlogin extends HttpServlet{
DBclass db;
Connection con;
ResultSet rs,st;
Statement set;
PreparedStatement pset;
String id;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();
          try{
                response.setContentType("text/html;charset=UTF-8");
                
               
               
                String getmail= request.getParameter("username").trim();
                String getpass= request.getParameter("password").trim();
                String m=request.getParameter("bh").trim();
                String h=request.getParameter("bw").trim();
                encription en=encription.createObject();
                PathCreater pc = PathCreater.objectCreater();
                genralwork gw=genralwork.bojectCreater();
                getpass =en.Password(getpass);
                String username=null;
                String pass=null;
                String path=null,name="";
                int i=0;
                boolean isuser=false;
                int status=0;
                
                db=DBclass.objectCreater();
                con=db.getConnection();
                set=con.createStatement();
               
            try{
                        String quary1="select l.user_id,u.user_name,l.user_pass,l.status from user_login as l inner join user_id as u on(l.user_id=u.user_id) where l.email =?";// '"+getmail+"';";
                        pset =con.prepareStatement(quary1);
                        pset.setString(1, getmail);
                        rs=pset.executeQuery();
                        

                        if(rs.next())
                        {
                            isuser=true;
                            status=rs.getInt("status");
                            name=gw.nameFormater(rs.getString("user_name"));
                            path=en.encription(rs.getString("user_id"));
                        }

                        if(getpass.equals(rs.getString("user_pass")))
                        {
                            id=rs.getString("user_id");
                            pass=rs.getString("user_pass");
                            username=gw.nameFormater(rs.getString("user_name"));
                            i=1;

                        }
                } catch (SQLException ex) {} 
                    finally {   
                        try {
                            pset.close();
                            rs.close();
                             } catch (SQLException ex) {}
                             } 
                 
                if(i==1)
                {
                    if(status==1)
                    {
                         try{
                         HttpSession hs=request.getSession(true);
                         SessionListener listener=new SessionListener();
                       ;
                                hs.setAttribute("user_id",id);
                                hs.setAttribute("user_img", en.encription(id));
                                hs.setAttribute("online","yes");
                                hs.setAttribute("listener", listener);
                                String query="select max(id) from chat where r_id = '"+id+"';";

                                        st= db.toRead(query,set);
                                        st.next();

                                        String pending=st.getString("max(id)");
                                        hs.setAttribute("name", username);
                                        hs.setAttribute("max_id",pending);
                                        hs.setAttribute("pending_id", pending);


                                        hs.setAttribute("bh", m);
                                        hs.setAttribute("bw", h);
                                        request.setAttribute("bh", m);
                                        request.setAttribute("bw", h);

                                        out.println(hs.getAttribute("pending_id"));
                                        String up="update on_off set status='1' where user_id='"+hs.getAttribute("user_id")+"';";
                                        db.toWrite(up,set);


                                        i=0;
                                        response.sendRedirect("youonline");
                                        //request.getRequestDispatcher("mainfriends").forward(request, response);
                                        // request.getRequestDispatcher("WEB-INF/NABEEL/newjsp.jsp").forward(request, response);
                                } catch (SQLException ex) {} 
                                        finally {   
                                            try {
                                                st.close();
                                                 } catch (SQLException ex) {}
                                                 }  
                                
                    }
                    else
                    {
                        request.setAttribute("name", name);
                        request.setAttribute("mail", getmail);
                        request.setAttribute("uid", path);
                        request.getRequestDispatcher("group_info/unactive_account.jsp").forward(request, response);
                    }
                }
                else
                {
                            if(isuser)
                            {
                                request.setAttribute("name", name);
                                request.setAttribute("email", getmail);
                                request.setAttribute("bh", m);
                                request.setAttribute("bw", h);
                                request.setAttribute("profile", path);
                                request.getRequestDispatcher("group_info/isyou.jsp").forward(request, response);
                            }
                            else
                            {
                                request.setAttribute("login_validator", "invalid");
                                request.getRequestDispatcher("WEB-INF/HOME/Login.jsp").forward(request, response);
                            }
                            
                }
                
          } catch (IOException io) {} catch(SQLException sql){}
                finally {   
                    try {
                        con.close();
                        set.close();
                        out.close();
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
