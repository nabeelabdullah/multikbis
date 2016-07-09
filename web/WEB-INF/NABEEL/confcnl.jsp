<%-- 
    Document   : myprofile
    Created on : Jul 21, 2014, 2:04:18 PM
    Author     : nabeel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="concle/concle.css" type="text/css" rel="stylesheet">
        <script src="concle/confcle.js" type="text/javascript" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
        
    </head>
    <body>
      <div id="header">
        <div id="subheader"><div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
             <a href="GoHome">        <div id="gohome" style=" width: 120px;">
                  <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                           <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                       </div>
                     <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 14px; color: white;text-align: center;"> Go Home </p>   </div></div>
           
           </a>  
            </div>
    </div>
        <div id="container">
            <div id="main">
               
                     <table style="width:100%;margin-left: 50px;">
                        <tr><td><div id="photodiv">
                    <img src="imagepass?path=${hash['00']}" id="divimg">

                </div></td></tr>
                        <tr>
                            <td>FULL NAME</td>
                            <td>${hash['01']}</td>
                        </tr>
                         <tr>
                            <td>SCHOOLING FROM</td>
                            <td>${hash['02']}</td>
                        </tr>
                         <tr>
                            <td>SECONDERY FROM</td>
                            <td>${hash['03']}</td>
                        </tr>
                         <tr>
                            <td>CONTACT(email/mobile.no)</td>
                            <td>${hash['04']}</td>
                        </tr>
                         <tr>
                            <td>STATUS</td>
                            <td>${hash['05']}</td>
                        </tr>
                        <tr>
                            <td>AREA OF INTEREST(subject)</td>
                              <td>${hash['06']}</td>
                        </tr>
                         <tr>
                            <td>COLLAGE</td>
                              <td>${hash['07']}</td>
                        </tr>
                         <tr>
                            <td>LIVE IN</td>
                              <td>${hash['08']}</td>
                        </tr>
                         <tr>
                            <td>FOUND OFF</td>
                              <td>${hash['09']}</td>
                        </tr>
                         <tr>
                            <td>COURSE</td>
                              <td>${hash['10']}</td>
                        </tr>
                         <tr>
                            <td>BRANCH</td>
                              <td>${hash['11']}</td>
                        </tr>
                                <tr><td></td>
                                    <td>
                                         <div id="submitit">

                        <a class="concle" id="c1" onclick="request_cc('confurm', '${hash['12']}');">confurm</a>
                        <a class="concle" id="c2" onclick="request_cc('cancel', '${hash['12']}');">cancel</a>
                        <img src="../../img/aj1.gif" id="imgv" style="visibility: hidden"/>

                    </div>
                            
                            </td></tr>
                    </table>
                        
                  <!--  
                <ul id="lable">
                    <li class="l1">FULL NAME</li>
                    <li class="l1">SCHOOLING FROM</li>
                    <li class="l1">SECONDERY FROM</li>
                    <li class="l1">CONTACT(email/mobile.no)</li>
                    <li class="l1">STATUS</li>
                    <li class="l1">AREA OF INTEREST(subject)</li>
                    <li class="l1">COLLAGE </li>
                    <li class="l1">LIVE IN </li>
                    <li class="l1">FOUND OFF</li>
                    <li class="l1">COURSE</li>
                    <li class="l1">BRANCH (if any)</li>
                </ul>
                <ul id="txt">

                    <li class="t1">${hash['01']}</li>
                    <li class="t1">${hash['02']}</li>
                    <li class="t1">${hash['03']}</li>  
                    <li class="t1">${hash['04']}</li>
                    <li class="t1">${hash['05']}</li>
                    <li class="t1">${hash['06']}</li>
                    <li class="t1">${hash['07']}</li>
                    <li class="t1">${hash['08']}</li>
                    <li class="t1">${hash['09']}</li>
                    <li class="t1">${hash['10']}</li>
                    <li class="t1">${hash['11']}</li>
                    <div id="submitit">

                        <a class="concle" id="c1" onclick="request_cc('confurm', '${hash['12']}');">confurm</a>
                        <a class="concle" id="c2" onclick="request_cc('cancel', '${hash['12']}');">cancel</a>
                        <img src="../../img/aj1.gif" id="imgv" style="visibility: hidden"/>

                    </div>
                    </li>
                </ul>
-->
            </div>
        </div>
    </body>
</html>
