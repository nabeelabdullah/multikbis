<%-- 
    Document   : term_condition
    Created on : Oct 8, 2014, 9:22:49 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <link href="../thank_you/unactiv_account.css"type="text/css" rel="stylesheet"/>
         <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
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
              <div id="thank">
                  <p style="font-size: 25px; font-family: 'Hind', sans-serif;color: #990033; text-align: center;">Welcome ${name}</p>
              </div>
              
              <div id="click_here">
                  <p style="text-align: center;font-family: 'Hind', sans-serif; margin-top: 10px;">Activate your account using the link which we have sent to your email account (${mail})</p>
                  
                  <a href="http://multikbismail-nomannabeel.rhcloud.com/activateaccount?mail=${mail}&uid=${uid}"> <p style="text-align: center;font-family: 'Hind', sans-serif; margin-top: 10px;">Click here if you have not received the mail until now.</p></a>
                  <p style="text-align: center;font-family: 'Hind', sans-serif; margin-top: 10px;"></p>
              </div>
          </div>
      </div>
    </body>
</html>
