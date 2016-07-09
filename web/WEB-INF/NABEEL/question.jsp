<%-- 
    Document   : newgrouprequest
    Created on : Aug 24, 2014, 4:56:42 AM
    Author     : NABEEL
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>MultiKBIS</title>
        <meta charset="UTF-8"> 
        <script src="../../ckeditor/ckeditor.js" type="text/javascript"></script>
        <link href="question/question.css" type="text/css" rel="stylesheet"/>
        <script src="question/question.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    <body style="margin: 0;padding: 0; border:0px solid #F7E7CE;" onload="onloader();" onscroll="scroller();">
     <!--   <div id="subheader1" style="height: 40px;width: 100%;position: fixed;background-color: #9b060b;visibility: hidden;">
            
            <div id="header" style="z-index: 5;  width: 100%; height: 60px; " >
            <div id="subheader"><div style="float: left;"><p style="font-size: 15px;margin-left: 40px; font-family: cursive; color: white">MultiKBIS</p></div>
             <a href="GoHome">     <div id="gohome">
                    <p style="font-family: sans-serif;font-size: 15px; color: white;text-align: center;"> Go Home </p>  
                </div>
           </a>  
            </div>
        </div> 
        </div>-->
        <div id="header" style="z-index: 5;  width: 100%; height: 40px;position: fixed;background-color: black; " >
      
            <div id="subheader">
                <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px; background-color: black;border-radius: 45px; float: left;margin-right: 20px;"/>  
                <div style="float: left;margin-top: 5px;">
                    
                    <b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
                 <div id="gohome" onclick="  window.location.replace('usego_offline');">
                     <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                         
                       </div>
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Log Out </p>   </div>
                </div>
                
                <div id="gohome" onclick="goback();">
                     <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                          
                       </div>
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Go Home </p>   </div>
                </div>
             
            </div>
        </div>
        <div id="container">
            <div style="width: 100%;height: 40px;"></div>
            <c:forEach var="m" items="${hash}">
                <div class="mydiv" style="font-family: sans-serif;">
                   
                    <div class="second"  >
                        <img src="img/images0.jpeg" class="qustion_img" >
                    </div>
                
                    <p  class="textp"  >
                        ${m.value['1']}
                        <!-- content in file,user_id,user_name,user_name,question_id,group_id,group_id  -->
                    </p> 
                    
                     <table>
                       <tr>
                           <td><a class="asked_by" href="simpleprofilepage_handler?user_id=${m.value['2']}" > <p style="font-family: sans-serif;">Asked by <span style="color: red;">${m.value['3']}</span></p> </a></td>
                           <td>
                               <a class="answerp" href="answerhandler?q_id=${m.value['4']}&group_id=${gi}"><p style="font-family: sans-serif;">${m.value['6']}  Answers </p></a>
                           </td>
                       </tr>
                   </table>
                    
                   <hr />
                </div>
            </c:forEach>

        </div>

       
        <div id="textdiv" >

            <p style="font-family: sans-serif;margin-top:20px; text-align: center;">Write Your Question Here</p>
            <form action="qustionstorage" method="get">

                <textarea id="textvalue" name="content"></textarea>
                <script> CKEDITOR.replace('textvalue');</script>
                <input type="hidden" id="gid" name="group_id"/>

                <input type="submit" id="submitme" style="visibility: hidden;position: absolute;">
            </form>
            <div id="clickme" onclick="callajax('${gi}');"> 
                <p id="submitp">   Submit Question</p>
            </div>
        </div>
    </body>
</html>

