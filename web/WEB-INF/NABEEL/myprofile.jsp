<%-- 
    Document   : myprofile
    Created on : Jul 21, 2014, 2:04:18 PM
    Author     : nabeel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <link href="myprofile/myprofile.css" type="text/css" rel="stylesheet">
        <script src="myprofile/myprofile.js" type="text/javascript" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>

    </head>
    <body>

  <img src="../../img/aj1.gif" style="visibility: hidden;position: absolute;"/>
    <div id="header">
        <div id="subheader">
            <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px; background-color: black;border-radius: 45px; float: left;margin-right: 20px;"/>  
            <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
           <a href="GoHome"> 
                       <div id="gohome">
                       <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                        <!--   <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                       </div>-->
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 12px; color: white;text-align: center;"> Go Home </p>   </div>
                       </div>
            </a>  
            </div>
    </div>

                 <div id="container">
 <div id="main">
 <table style="width:700px;margin: 10px auto;margin-left: 150px;">
      <tr>
          <td style="margin-bottom: 10px;">
               <div id="photodiv">
                    <img src="imagepass?path=${hash['00']}" id="divimg">

                </div>
          </td>
          <td>

          </td>
      </tr>
                        <tr>
                            <td style="width: 350px;  font-size: 13px;">FULL NAME</td>
                            <td style="text-transform: capitalize;font-size: 13px;">${hash['01']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">SCHOOLING FROM</td>
                            <td style="font-size: 13px;">${hash['02']}</td>
                        </tr>
                         <tr>
                             <td style="width: 350px;font-size: 13px;">SECONDERY FROM</td>
                            <td style="text-transform: capitalize;font-size: 13px;">${hash['03']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">CONTACT(email/mobile.no)</td>
                            <td style="font-size: 13px;">${hash['04']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">STATUS</td>
                            <td style="font-size: 13px;text-transform: capitalize;">${hash['05']}</td>
                        </tr>
                        <tr>
                            <td style="width: 350px;font-size: 13px;">AREA OF INTEREST(subject)</td>
                              <td style="text-transform: capitalize;font-size: 13px;">${hash['06']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">COLLAGE</td>
                              <td style="text-transform: capitalize;font-size: 13px;">${hash['07']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">LIVE IN</td>
                              <td style="text-transform: capitalize;font-size: 13px;">${hash['08']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">FOUND OFF</td>
                              <td style="text-transform: capitalize;font-size: 13px;">${hash['09']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">COURSE</td>
                              <td style="text-transform: capitalize;font-size: 13px;">${hash['10']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;font-size: 13px;">BRANCH</td>
                              <td style="text-transform: capitalize;font-size: 13px;">${hash['11']}</td>
                         </tr>
                         <tr>
                             <td></td>
                             <td id="unftd" style="margin: 0;padding: 0;">
                                    <a id="unfriend" onclick="unfriend_handler('${hash['12']}');">Unfriend</a>
                                    <img src="../../img/aj1.gif" id="imgv" style="visibility: hidden;">      
                             </td>
                         </tr>
                    </table>
   
 </div>
    </div>
        
    </body>
</html>
