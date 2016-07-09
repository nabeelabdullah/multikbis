<%-- 
    Document   : forgetpassword
    Created on : Nov 4, 2014, 8:14:38 PM
    Author     : NABEEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../group_info/isyou.css" type="text/css" rel="stylesheet"/>
        <script src="../group_info/isyou.js"type="text/javascript"></script>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body>
        <div id="header">
            <div style="width: 100%;height: 40px;;background-color: black;position: fixed;" id="subheader1" >
            <div style="width: 912px;height: 100%; margin: 0 auto;border: 1px solid transparent;">
                <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
            </div>
                 
        </div> 
        </div>
        <div id="fcontainer">
            <div id="uppermain">
                <p id="upperspan">Are You?</p>
            </div>
            <hr />
             <form action="userlogin" method="post" > 
            <div id="middlemain">
                
                <div style="width: 100px;height: 150px; float: left;">
                   
                    <img src="imagepass?path=${profile}" style="width: 100%;height: 100%;"/>
                </div>
                <div style="width: 340px;height: 200px;float: left;"> <ul id="u1">
                        <li> <p id="namep">${name}</p></li>
                    <li>  
                       <input type="hidden" name="username" value="${email}"/>
                       <input type="password" name="password" placeholder="Enter Your Password:" class="inputclass"/>
                       <input type="hidden" style="position: absolute;" name="bh" value="${bh}" id="bh"/>
                       <input type="hidden" style="position: absolute;" name="bw" value="${bw}" id="bw"/>
                    </li>
                   <p id="fp" style="font-size: 12px ;font-family: 'Hind', sans-serif; margin-left: 20px;"  ><a href="../group_info/forgetpassword.jsp">Forget password?</a></p>
                </ul>
                    <div id="forsubmit" onclick="clickr('submitit')">
                        <p style="text-align: center;font-size: 15px;">Login</p>
                    </div>
                </div>
              
                   
            
            </div>
                    <input type="submit" id="submitit" style="visibility: hidden;">
            </form>
                    <hr />
                    <div id="lowermain" >
                        <a href="Login">  <p id="nin">No I am Not.</p></a>
                    </div>
            
        </div>
         <div id="footer">
             <%@include file="footer.jspf" %>
         </div>
    </body>
</html>
