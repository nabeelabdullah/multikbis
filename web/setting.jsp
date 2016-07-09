<%-- 
    Document   : setting
    Created on : 14 Nov, 2015, 11:37:35 AM
    Author     : zishan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="setting.css" type="text/css" rel="stylesheet"/>
        <script src="setting.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
            <div id="subheader">
                    
                    <div id="user_img">
                        <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px;border-radius: 45px; "/>  
                    </div>
                    
                    <div style="float: left;margin-left: 38px; margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                  
                    <div class="gohome" onclick="window.location.replace('usego_offline');">
                       <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center;"> Log Out </p>   </div>
                    </div>
                
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                     <div class="gohome" onclick="window.open('BookDisplay','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           
                    </div>
                    
                    
                    
                </div>
               
        </div>
        <div id="main">
               <hr/>
            <table>
                <tr>
                    <td colspan="2"><span id="chsp" style="margin-left: 160px;"></span></td>
                   
                </tr>
                <tr>
                    <td>Your old Password:</td>
                    <td><input type="password" class="text" id="old"></td>
                </tr>
                <tr>
                    <td>Your New Password:</td>
                    <td><input type="password" class="text" id="newpassword"></td>
                </tr>
                <tr>
                    <td>Re Enter Your new Password:</td>
                    <td><input type="password" class="text" id="reinter"></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" id="submitbutton" style="width: 100px;height: 20px;float: right" onclick="submit();"></td>
                </tr>
            </table>
              <hr/>
        </div>
      
    </body>
</html>
