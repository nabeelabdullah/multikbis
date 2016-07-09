<%-- 
    Document   : Login
    Created on : Mar 23, 2015, 11:05:13 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind|Roboto:400,300' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Multipurpose Knowledge Based Information Sharing is an online solution to facilitate it's user to provide a plateform to share their ideas and informations.">
        <link href="../../Login/Login.css" type="text/css" rel="stylesheet"/>
        <script src="../../Login/Login.js" type="text/javascript"></script>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS Login</title>
    </head>
    <body onload="txtFocus();" id='body'>
        <div id="top">
         <div id="top_container">
                <div id="logo">
                   <b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                </div>
                <div id="quick_links">
                    
                </div>
             <a href="Signup">
                 <div style="height: 23px;width: 70px;background-color: #00796B; float: right;color: white;margin: 5px;padding: 2px; border-radius: 1px;border: 1px solid whitesmoke;font-weight: bold;cursor: pointer;"><p style="margin: 0;padding: 0;text-align: center;margin-top: 2px;font-size: 14px;font-family: 'Hind', sans-serif;">Sign up</p>
            </div>
                 </a>
           
        </div>
        </div>
        <!--<div id='whatis'>
          
   
<ul>
                <li><span class="m1">Multi</span>purpose <span class="m1">K</span>nowledge <span class="m1">B</span>ased <span class="m1">I</span>nformation <span class="m1">S</span>haring is an online solution to facilitate it's user to provide a plateform to
               share their ideas and informations.It has four main modules</li>
           <li> <p><img src="../img/pointing.jpg" style="height: 20px;width: 30px;">&nbsp;Module 1:</p> <span>It is an social network module where user can make friend ,chat with them and send file to each other.User can send member request to Pre defined group and join on the basis of 50% criteria.
               Member of the group can send file to the email to all member of that particuler group and SMS to the phone of all member of that group.A member of the group can answer 
               of the question asked by any one.Any person can ask question to any of the group but only that person answer them who is the member of that paricular group
               .User can change his profile as well as his profile picture which will public for every one.
               </span></li>
</ul>
       
            
            
        </div>-->
        
        <div style="height: 340px;width: 402px; margin: 50px auto;border-radius: 5px; background-color: white;padding: 20px 20px; ">
           
               <form action="userlogin" method="post" onsubmit="abcsubmit('hiddensubmit2');"> 
                  <div  id="login_header">
                      <p style="text-align: center; margin-top: 19px;">Login to MultiKBIS</p>
                      <div style="float: left;margin-left: 190px;margin-top: 0px;width: 1px;  height: 1px;border-width: 9px;border-color: transparent transparent  #E8E8E8 transparent;border-style: solid;"></div>
                  </div>
                   <div id="invalid">
                    <%if(request.getAttribute("login_validator").equals("invalid"))
                    {
                    %>
                    <span  style=" float: left; background-color: transparent;;margin-top: 2px;font-family: sans-serif;font-size: 12px;font-weight: bold;font-family: cursive; color: red;margin-left: 20px;" >USER NAME OR PASSWORD IS INVALID!</span>
                     <% 
                     }
                     %>
                     </div>
                    <input type="text" name="username" placeholder="Enter Email" class="ifield" id="username"/>
                    <input type="password" name="password" placeholder="Enter Password" style="margin-bottom: 20px;" class="ifield" id="password"/>
                    <input type="hidden" style="position: absolute;" name="bh" value="JavaScript:valuegetter();" id="bh"/>
                    <input type="hidden" style="position: absolute;" name="bw" value="JavaScript:valuegetter();" id="bw"/>
                    <div class="sfield" onclick="loginSubmit('hiddensubmit2');" ><p style="text-align: center; margin-top: 15px;font-family: 'Hind', sans-serif;">Login</p></div>
                    <div style="height: 30px;width: 30px;border-radius: 30px;margin-left: 110px; ;float: left;margin-top: 12px;"><p style="font-weight: bold;margin: 0;padding: 0;text-align: center;margin-top: 6px; color: #E0E0E0 ;">?</p></div>
                    <p style="margin-top:15px; float: left;margin-left: 15px;"><a href="../../forgetpassword/forgetpassword.jsp" style="margin-top:20px; text-decoration: underline;font-family: 'Hind', sans-serif; "> Forget password?</a></p>
              
     
                  <input type="submit" id="hiddensubmit2" style="visibility: hidden; height: 0px;width: 0px;position: absolute;">
             </form>
                    
     
       </div>
                     <div id="footer">
                         <div style="width: 1000px; margin: 0 auto;"> <hr/></div>
                     <%@include  file="../../group_info/footer.jspf" %>
                     </div>
    </body>
</html>
