<%-- 
    Document   : forgetpassword
    Created on : Nov 4, 2014, 8:14:38 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../change_password/changePass.css" type="text/css" rel="stylesheet"/>
        <script src="../../change_password/changePass.js" type="text/javascript"></script>
        <title>MultiKBIS</title>
    </head>
    <body>
        <div id="header">
            <div style="width: 960px;height: 40px; margin: 0 auto;"> <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
            </div>
        </div>
        <div id="fcontainer">
            <div id="uppermain">
                <p id="upperspan">Change Your Password</p>
                <div style="float: left;margin-left: 190px;margin-top: 4px;width: 1px;  height: 1px;border-width: 9px;border-color: transparent transparent  #E8E8E8 transparent;border-style: solid;"></div>
            </div>
            <form action="ResetPassword"  method="post">
                    <div id="middlemain">
                        <ul id="u1">
                            <input type="hidden" name="u" value="${u}">
                            <input type="hidden" name="n" value="${n}">
                            <li> <input type="password" id="p" placeholder="Enter Your New Password" class="inputclass" name="p"/></li>
                            <li> <input type="password" id="rp" placeholder="ReEnter Your New Password" class="inputclass" name="rp"/></li>
                        </ul>
                            <span id="myspan"></span>
                    </div>
                            <div id="lowermain" onclick="onsubmitclick();">
                        <p style="margin: 0;padding: 0;font-size: 15px; font-family: 'Hind', sans-serif;color: white;margin-top:15px; text-align: center;">Submit</p>
                    </div>
                            <input type="submit" id="sub" style="visibility: hidden;height: 0;width: 0;">
            </form>
           

        </div>          
        <div id="footer">
            <hr style="width: 1000px;color: rgba(0,0,0,0.1);"/>
            <%@include  file="../../group_info/footer.jspf" %>
        </div>
    </body>
</html>
