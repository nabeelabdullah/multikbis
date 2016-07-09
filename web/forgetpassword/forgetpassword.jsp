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
        <link href="forgetpassword.css" type="text/css" rel="stylesheet"/>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
         <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <title>MultiKBIS</title>
    </head>
    <body>
        <div id="header">
            <div style="width: 960px;height: 40px; margin: 0 auto;"> <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
            </div>
            </div>
        <div id="fcontainer" style="border-color: transparent;">
            <div id="uppermain">
                <p id="upperspan">Write your registered Email Adderess</p>
                <div style="float: left;margin-left: 190px;margin-top: 1px;width: 1px;  height: 1px;border-width: 9px;border-color: transparent transparent  #E8E8E8 transparent;border-style: solid;"></div>
            </div>
            <form action="../Authentication">
                    <div id="middlemain">
                      <ul id="u1">
                      <li> <input type="email" placeholder="Enter Your Registered Email Address" class="inputclass" name="email"/></li>
                      <!--      <li>   <input type="text" placeholder="Enter Your Registered Mobile Address" class="inputclass" name="mobile"/></li>
                      -->
                      </ul>

                     <input type="submit" id='sub' style="margin: 0;padding: 0;height: 0;width: 0;visibility: hidden;">   
                    </div>
               
            </form>
            <div id="lowermain" onclick="document.getElementById('sub').click();">
               <p style="margin: 0;padding: 0;margin-top:12px;color: white;font-family: 'Hind', sans-serif;text-align: center;">Submit</p>
            </div>
            
            
            
        </div>
         <div id="footer">
             <%@include file="../group_info/footer.jspf" %>%>
         </div>
    </body>
</html>
