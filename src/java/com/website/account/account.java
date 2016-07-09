package com.website.account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nabeel_temp.encription;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import noman_temp.Signup;

/**
 *
 * @author akhtar
 */
public class account extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            encription en= encription.createObject();
            Signup sn=Signup.objectCreator();

            String fname = request.getParameter("a1");//first
            String lname = request.getParameter("a2");//last
            String email = request.getParameter("a3");//email
            String mobile = "0000000000";//request.getParameter("a4");//mob
            String inst = request.getParameter("a5");//ins
            String city = "nill";//request.getParameter("a6");//city
            String pass = request.getParameter("a7");//pass
            String repass = request.getParameter("a8");//repass
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String gender = request.getParameter("aa");//radio
            String uid="";
           
                String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LdlHOsSAAAAACe2WYaGCjU2sc95EZqCI9wLcLXY");
		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
		if (reCaptchaResponse.isValid()) 
                {
			uid=sn.signupAuthentication(fname,lname,email,mobile,inst,city,pass,repass,day,month,year,gender);
//			out.print("CAPTCHA Validation Success! User registered.");
		} 
       
            if(!(uid.equals("not ok"))&&(!uid.equals("mailexist")))
            {
                
                //request.getRequestDispatcher("WEB-INF/AKHTAR/thank_you.jsp").forward(request, response);
                response.sendRedirect("http://multikbismail-nomannabeel.rhcloud.com/activateaccount?mail="+email+"&uid="+en.encription(uid));
            }
            else
            {
                if(uid.equals("mailexist"))
                {
                    request.setAttribute("spam", "THIS EMAIL IS EXIST");
                    request.setAttribute("evaluator", "0");
                    request.getRequestDispatcher("WEB-INF/HOME/website.jsp").forward(request, response);  
                }
                else
                {
                    request.setAttribute("evaluator", "2");
                    request.getRequestDispatcher("WEB-INF/HOME/website.jsp").forward(request, response);  
                }
            }
            

             
        }catch(IOException n){}
       
    
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