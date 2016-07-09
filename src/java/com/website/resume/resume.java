/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.resume;

import nabeel_temp.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NABEEL
 */
public class resume extends HttpServlet {

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
        try {
            HttpSession hs = request.getSession(false);
            if (hs != null) {
                MakeResume mr = new MakeResume();
                HashMap mp = new HashMap();

                mp.put("full_name", request.getParameter("full_name"));
                mp.put("father_name", request.getParameter("father_name"));
                mp.put("d_o_b", request.getParameter("d_o_b"));
                mp.put("nationality", request.getParameter("nationality"));
                mp.put("l_known", request.getParameter("l_known"));
                mp.put("gender", request.getParameter("gender"));
                mp.put("marital", request.getParameter("marital"));
                mp.put("p_add", request.getParameter("p_add"));
                mp.put("email", request.getParameter("email"));
                mp.put("mobile", request.getParameter("mobile"));
                //out.println("2");
                /**
                 * school information *
                 */
                mp.put("h_s_name", request.getParameter("h_s_name"));
                mp.put("h_s_y_o_a", request.getParameter("h_s_y_o_a"));
                mp.put("h_s_y_o_p", request.getParameter("h_s_y_o_p"));
                mp.put("h_s_d", request.getParameter("h_s_y_o_a") + "-" + request.getParameter("h_s_y_o_p"));
                mp.put("h_s_p", new Integer(request.getParameter("h_s_m_g")) * 100 / (new Integer(request.getParameter("h_s_m_t"))));// Integer.parseInt(*100));
                mp.put("h_s_m_g", request.getParameter("h_s_m_g"));
                mp.put("h_s_m_t", request.getParameter("h_s_m_t"));

                mp.put("s_s_name", request.getParameter("s_s_name"));
                mp.put("s_s_y_o_a", request.getParameter("s_s_y_o_a"));
                mp.put("s_s_y_o_p", request.getParameter("s_s_y_o_p"));
                mp.put("s_s_d", request.getParameter("s_s_y_o_a") + "-" + request.getParameter("s_s_y_o_p"));
                mp.put("s_s_p", new Integer(request.getParameter("s_s_m_g")) * 100 / (new Integer(request.getParameter("s_s_m_t"))));

                mp.put("s_s_m_g", request.getParameter("s_s_m_g"));
                mp.put("s_s_m_t", request.getParameter("s_s_m_t"));

                /**
                 * school information *
                 */
                /**
                 * graduation*
                 */
               //out.println("3");
                //out.println(request.getParameter("choosebr"));
                String m = request.getParameter("choosebr");
                if (m.equals("Choose")) {
                    m = "";
                } else {
                    m = "(" + request.getParameter("choosebr") + ")";
                }
                mp.put("choose_branch", m);
                mp.put("gr_name", request.getParameter("gr_name"));
                mp.put("choose", request.getParameter("choose"));
                mp.put("gr_1_d", request.getParameter("gr_1_d"));
                mp.put("gr_1_m_g", request.getParameter("gr_1_m_g"));
                mp.put("gr_1_p", new Integer(request.getParameter("gr_1_m_g")) * 100 / (new Integer(request.getParameter("gr_1_m_t"))));// Integer.parseInt(*100));
                mp.put("gr_1_m_t", request.getParameter("gr_1_m_t"));
                mp.put("gr_2_d", request.getParameter("gr_2_d"));
                mp.put("gr_2_m_g", request.getParameter("gr_2_m_g"));
                mp.put("gr_2_m_t", request.getParameter("gr_2_m_t"));
                mp.put("gr_2_p", new Integer(request.getParameter("gr_2_m_g")) * 100 / (new Integer(request.getParameter("gr_2_m_t"))));
                mp.put("gr_3_d", request.getParameter("gr_3_d"));
                mp.put("gr_3_m_g", request.getParameter("gr_3_m_g"));
                mp.put("gr_3_m_t", request.getParameter("gr_3_m_t"));
                mp.put("gr_3_p", new Integer(request.getParameter("gr_3_m_g")) * 100 / (new Integer(request.getParameter("gr_3_m_t"))));
                mp.put("gr_4_d", request.getParameter("gr_4_d"));
                mp.put("gr_4_m_g", request.getParameter("gr_4_m_g"));
                mp.put("gr_4_m_t", request.getParameter("gr_4_m_t"));
           // out.println("from "+request.getParameter("gr_4_m_g")+" to");
                // if((request.getParameter("gr_4_d").equals(""))||(request.getParameter("gr_4_m_g").equals(""))||(request.getParameter("gr_4_m_t").equals("")))
                if (!request.getParameter("gr_4_m_g").equals(""))//&&(!request.getParameter("gr_4_m_t").equals(null)))
                {
                    mp.put("gr_4_p", new Integer(request.getParameter("gr_4_m_g")) * 100 / (new Integer(request.getParameter("gr_4_m_t"))));

                    //   out.println("if");
                } else { //out.println("else");
                    mp.put("gr_4_p", "");
                }
                /**
                 * graduation*
                 */
                /* project  */
                //out.println("4");
                mp.put("t_project", request.getParameter("t_project"));
                mp.put("tech_project", request.getParameter("tech_project"));
                mp.put("d_project", request.getParameter("d_project"));
                mp.put("team_project", request.getParameter("team_project"));
                mp.put("roll_project", request.getParameter("roll_project"));

                /*project*/
                /*training*/
                //out.println("5");
                mp.put("trainning_ind", request.getParameter("trainning_ind"));
                mp.put("trainning_on", request.getParameter("trainning_on"));
                mp.put("trainning_d", request.getParameter("trainning_d"));
                mp.put("trainning_from", request.getParameter("trainning_from"));
                mp.put("trainning_to", request.getParameter("trainning_to"));

               
                
                
                
               
                
                
                
                /*training*/
                /*computer skill*/
                mp.put("c_skill_os", "not found");
                mp.put("c_skill_pr", "not found");
                mp.put("c_skill_ide", "not found");
                mp.put("c_skill_db", "not found");

                String c_skill_enable;
                c_skill_enable = request.getParameter("c_skill_enable");
                mp.put("c_skill_enable", "true");
                out.println("1");
                if (c_skill_enable == null) {
                    mp.put("c_skill_enable", "false");
                }
                out.println(mp.get("c_skill_enable"));
                c_skill_enable = request.getParameter("cskos");
                if (c_skill_enable != null) {
                    mp.put("c_skill_os", request.getParameter("c_skill_os"));
                }

                out.println("1");
                c_skill_enable = request.getParameter("cskps");

                if (c_skill_enable != null) {
                    mp.put("c_skill_pr", request.getParameter("c_skill_pr"));
                }
                out.println("1");

                c_skill_enable = request.getParameter("cskide");

                if (c_skill_enable != null) {
                    mp.put("c_skill_ide", request.getParameter("c_skill_ide"));
                }

                out.println("1");
                c_skill_enable = request.getParameter("cskds");

                if (c_skill_enable != null) {
                    mp.put("c_skill_db", request.getParameter("c_skill_db"));
                }
               c_skill_enable = request.getParameter("skill_enable");
                mp.put("skill_enable", "true");
                out.println("1");
                if (c_skill_enable == null) {
                    mp.put("skill_enable", "false");
                } 
                out.println("5");

                /*computer skill*/
                // //out.println("6"+hs.getAttribute("user_id"));
                mp.put("skilltext", "<p style='font-size:15px;'>" + request.getParameter("skilltext") + "</p>");
                String path = PathCreater.objectCreater().resumepathcreater(hs.getAttribute("user_id").toString());
//         /  out.println(mp);
                out.println("hai");
                mr.MakeResumeMaker(mp, path);
                out.println("hai hello");
                String id = hs.getAttribute("user_id").toString();
          // //out.println("downloadresume?id="+id+"'");

                out.println(request.getParameter("skilltext"));
                response.sendRedirect("preresume");
                String ms = "<a id='mid' href='downloadresume.pdf'>download resume</a>";
                ms = "<p id=\"fp\" style=\"font-size: 15px ;font-family: sans-serif; margin-left: 20px;\"  >" + ms + "</p>";
//           out.println("<html>\n" +
//"    <head>\n" +"<title>download_resume</title>"+
//"        <script>\n" +
//"            function loader()\n" +
//"            {\n" +
//"               //document.getElementById('mid').click();" +
//"            }\n" +
//"        </script>\n" +
//"    </head>\n" +
//"    <body onload=\"loader();\">\n" +
//"        <div>"+ms+"</div>\n" +
//"    </body>\n" +
//"</html>\n" +
//"");

            } else {
                request.getRequestDispatcher("Login").forward(request, response);
            }
//            //out.println("<!DOCTYPE html>");
//            //out.println("<html>");
//            //out.println("<head>");
//            //out.println("<title>Servlet NewServletn</title>");            
//            //out.println("</head>");
//            //out.println("<body onload='  document.getElementById('mid').click();'>");
//             //out.println("<a id='mid' href='downloadresume?id="+id+"'>download resume</a>");
//            //out.println("<h1>Servlet NewServletn at " + request.getContextPath() + "</h1>");
//            //out.println("</body>");
//            //out.println("</html>");

         //  //out.println("<script></script>");
            ////out.println("7");
//             out.println(request.getParameter("c_skill_os")) ; 
//             out.println(request.getParameter("c_skill_pr")) ;
//             out.println(request.getParameter("c_skill_ide")) ; 
//             out.println(request.getParameter("c_skill_db")) ; 
            /*
            
             //out.println(request.getParameter("trainning_ind")) ; 
             //out.println(request.getParameter("trainning_on")) ; 
             //out.println(request.getParameter("trainning_d")) ; 
             //out.println(request.getParameter("trainning_from")) ; 
             //out.println(request.getParameter("trainning_to")) ; */
            /*
             out.println(request.getParameter("t_project")) ;   
             out.println(request.getParameter("tech_project")) ; 
             out.println(request.getParameter("d_project")) ; 
             out.println(request.getParameter("team_project")) ; 
             out.println(request.getParameter("roll_project")) ; */
            /*   out.println(request.getParameter("gr_name"));
             out.println(request.getParameter("choose"));
             out.println(request.getParameter("gr_1_d"));
             out.println(request.getParameter("gr_1_m_g"));
             out.println(request.getParameter("gr_1_m_t"));
             out.println(request.getParameter("gr_2_d"));
             out.println(request.getParameter("gr_2_m_g"));
             out.println(request.getParameter("gr_2_m_t"));
             out.println(request.getParameter("gr_3_d"));
             out.println(request.getParameter("gr_3_m_g"));
             out.println(request.getParameter("gr_3_m_t"));
             out.println(request.getParameter("gr_4_d"));
             out.println(request.getParameter("gr_4_m_g"));
             out.println(request.getParameter("gr_4_m_t")); 
               
             */
            //out.println(request.getParameter("h_s_name")); 
            //out.println(request.getParameter("h_s_y_o_a"));
            //out.println(request.getParameter("h_s_y_o_p"));
            //   out.println(request.getParameter("h_s_m_g"));
            //   out.println(request.getParameter("h_s_m_t"));
            //out.println(request.getParameter("s_s_name"));
            //out.println(request.getParameter("s_s_y_o_a"));
            //out.println(request.getParameter("s_s_y_o_p"));
            //  out.println(request.getParameter("s_s_m_g"));
            //  out.println(request.getParameter("s_s_m_t"));
            /*
             out.println(request.getParameter("full_name"));
             out.println(request.getParameter("father_name"));
             out.println(request.getParameter("d_o_b"));
             out.println(request.getParameter("nationality"));
             out.println(request.getParameter("l_known"));
             out.println(request.getParameter("gender"));
             out.println(request.getParameter("marital"));
             out.println(request.getParameter("p_add"));
             out.println(request.getParameter("email"));
             out.println(request.getParameter("mobile"));
             */
             //out.println(request.getParameter("trainning_ind")) ; 
            //out.println(request.getParameter("trainning_on")) ; 
            //out.println(request.getParameter("trainning_d")) ; 
            //out.println(request.getParameter("trainning_from")) ; 
            //out.println(request.getParameter("trainning_to")) ; */
        } finally {
            out.close();
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
