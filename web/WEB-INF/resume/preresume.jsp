<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link href="../../resume/preresume.css" rel="stylesheet" type="text/css"/>
        <style>
            #gohome:hover
            {
                cursor: pointer;
            }
            #mydownload{
                color: #0000FF;
            }
            #mydownload:hover{
                cursor: pointer;
            }
        </style>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    <body >
        <div style="width: 100%; height: 40px; background-color: black;"> 
         <div id="subheader">
                <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px; background-color: black;border-radius: 45px; float: left;margin-right: 20px;"/>  
                <div style="float: left;margin-top: 5px;">
                    
                    <b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
                 <div id="gohome" onclick="  window.location.replace('usego_offline');">
                     <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                      <!--   <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />-->
                       </div>
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Log Out </p>   </div>
                </div>
                
                <div id="gohome" onclick="window.open('GoHome','_self');">
                     <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                        <!--   <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />-->
                       </div>
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Go Home </p>   </div>
                </div>
             
            </div>
        </div>
        <div style="font-size: 14px;;box-shadow: 0 0  2px black;padding: 50px 50px;;width: 500px ;height: 200px;background-color: lightgray;margin: 0 auto;margin-top: 100px;border: 1px solid black;font-family: sans-serif;">
            <p> To download previously created resume <a id='mydownload' onclick="window.open('downloadresume.pdf','_blank');">click</a> here</p>
            <br/>
            or
            <br/>
            <p> To create new resume <a id="mydownload" onclick="window.open('resumehandler','_self');">click</a> here</p>
        </div>
            
      
    </body>
</html>
