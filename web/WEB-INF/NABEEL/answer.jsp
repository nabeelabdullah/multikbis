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
        <link href="../../question/question.css" type="text/css" rel="stylesheet"/>
        <script src="answer/answer.js" type="text/javascript"></script>
        <script src="../../ckeditor/ckeditor.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    <body style="margin: 0;padding: 0; border:0px solid white;" onscroll="scroller();">

        <div id="header" style="z-index: 5;  width: 100%; height: 40px;position: fixed;background-color: black; " onclick="temp();">
            <div id="subheader">
             <!--   <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px; background-color: black;border-radius: 45px; float: left;margin-right: 20px;"/>  -->
                <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
                
                   <div id="gohome" onclick="  window.location.replace('usego_offline');">
                     <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                     <!--    <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />-->
                       </div>
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Log Out </p>   </div>
                </div>
                <div id="gohome" onclick="gohome();">
                        <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                      <!--      <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />  -->
                        </div>
                        <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                
                  <div id="goquestion" style="padding: 0 8px;" onclick="questionpage('${gid}');">
                        <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                          <!--  <img src="../../img/daaaownload.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />  -->
                        </div>
                        <div style="width: 100px ;height: 100%;float: left; margin-bottom: 5px;">   <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;">Question Page </p>  
                        </div>

                    </div>

            </div>
        </div>
        <div id="container" >
            <div style="width: 100%;height: 40px;"></div>
            <DIV ID="qustion" style="font-family: sans-serif;padding: 5px 5px;">

                <div class="second"  >
                    <img src="img/images0.jpeg" class="qustion_img" >
                </div>
                <p  style="width: 900px; margin-left: 50px; font-family: sans-serif;" >

                    ${content}

                </p>

                <hr />

            </DIV>
            <p style="font-size: 20px; font-family: sans-serif;text-align: center;">Answers</p>
            <c:forEach var="x" items="${hash}">
                <div class="mydiv" style="font-family: sans-serif;">
                    <div class="second"  >
                        <img src="img/images1.jpeg" class="qustion_img" >
                    </div>
                    <p  class="textp" >

                        ${x.value['1']}

                    </p>

                    <a class="asked_by" href="simpleprofilepage_handler?user_id=${x.value['2']}" > <p style="font-family: sans-serif;">Answered by <span style="color: red;">${x.value['3']}</span></p> </a>
                    <hr />

                </div>
            </c:forEach>

        </div>

        <c:if test="${condition=='true'}">
            <div id="textdiv" >

                <p style="font-family: sans-serif;margin-top:20px; text-align: center;">WRITE YOUR ANSWER HERE</p>
                <form action="answerstorage" method="get">

                    <textarea id="textvalue" name="content"></textarea>
                    <script> CKEDITOR.replace('textvalue');</script>
                    <input type="hidden" id="gid" name="group_id"/>
                    <input type="hidden" id="qid" name="q_id"/>
                    <input type="submit" id="submitme" style="visibility: hidden;position: absolute;">
                </form>
                <div id="clickme" onclick="callajax('${gid}', '${qid}');"> 
                    <p id="submitp">   Submit Answer</p>
                </div>
            </div>
        </c:if>

    </body>
</html>

