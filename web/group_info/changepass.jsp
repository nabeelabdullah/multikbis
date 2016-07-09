<%-- 
    Document   : term_condition
    Created on : Oct 8, 2014, 9:22:49 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <link href="../thank_you/changepass.css "type="text/css" rel="stylesheet"/>
      <title>MultiKBIS</title>
    </head>
    <body>
      <div id="main_body">  
         <div id="main_header">
           
           
           <div id="header1">
               
                <div id="subheader"><div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
           
            </div>
            </div>
         </div>
          
          <div id="term_condition_container">
              <div id="thank" style="height: 120px;">
                  <div style="width: 100px ;height: 120px; float: left;">
                       <img src='imagepass?path=${img}' id="gimg"  style="width: 100%;height: 100%;"/>
                    
                  </div>
                   <div style="width: 300px ;height: 120px; float: left;margin-left: 50px;">
                       <p style="font-size: 20px; font-family: 'Hind', sans-serif;color: #990033; text-align: center;margin-top: 50px;"> 
                           Dear . ${name}
                      </p>
                  </div>
                 
              </div>
              
                      <div id="click_here" style="margin-top: 50px;">
                  <p style="text-align: center;font-family: 'Hind', sans-serif; margin-top: 10px;">your password verification code has been sent to your mail.  </p>
                  <a href="/"> <p style="text-align: center;font-family: 'Hind', sans-serif; margin-top: 10px;">Click here to go login page</p></a>
              </div>
          </div>
      </div>
    </body>
</html>
