<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.

    Document   : self_user
    Created on : 13 Jul, 2014, 2:10:31 AM
    Author     : akhtar


-->
<html>
    <head>
         <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <link href="feedback.css" type="text/css" rel="stylesheet">
        <script src="feedback.js" type="text/javascript"></script>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <style>
        
        </style>
    </head>
    <body>
       
             <div id="header">
            <div id="subheader"><div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
           
            </div>
            </div>
            <form action="feedservlet" method="post" name="form1">
                <div id="main">
                    <p style="font-size: 16px; font-family: 'Hind', sans-serif;padding: 0;margin-top: 20px;;text-align: center;">We welcome your feedback and suggestions</p>
                   <table>
                       <tr>
                           <td valign="top" > Your Full Name:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                           <td ><input type="text" class="ct" id="name"></td>
                           <td></td>
                       </tr>
                         <tr>
                          <td valign="top"> Your Email Address </td>
                          <td ><input type="email" class="ct" id="mail"></td>
                           <td></td>
                       </tr>
                         <tr>
                             <td valign="top"> Your Message:</td>
                          <td ><textarea style="width: 300px; height: 150px; margin-left: 100px;padding: 5px 10px;resize: none" id="msg"></textarea></td>
                           <td></td>
                       </tr>
                        <tr>
                            <td><img src="../img/waitingfile.gif" style="width: 25px;height: 25px;visibility: hidden;" id="loading"><span id="fspam" style="font-family: sans-serif;margin-left: 10px; margin-top: 4px;font-size: 15px;color: black"></span></td>
                          <td ><div id="sendme"  onclick="sendmsq();">
                              
                                  <p style="font-size: 13px; font-family: sans-serif;text-align: center;color: black; margin: 0;padding: 0;margin-top: 7px;">Send</p>
                              </div></td>
                           <td></td>
                       </tr>
                       </table>
                </div><!--main-->
            </form>
        <div id="footer">
            <div style="width: 1000px;margin: 0 auto;"><hr/></div>
            <%@include file="../group_info/footer.jspf" %>
        </div>
        

    </body>
</html>