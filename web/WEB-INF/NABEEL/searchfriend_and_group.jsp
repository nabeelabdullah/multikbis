<%-- 
    Document   : newjsp1
    Created on : Jul 9, 2014, 9:19:50 AM
    Author     : nabeel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body>

        <c:forEach var="x" items="${hash}">
            <div class="flist"> 
                <div class="flistheader"> 
                    <div id="onoff"> 
                        <div id="rgdiv"> 
                            <img src="img/green.png" class="rgimg" id="${x.value['1']}"/> 
                        </div> 
                        <span id="sss"> </span>
                    </div>  
                </div> 
                <div class="flistmiddle"> 
                    <div class="fphoto">

                        <img src='imagepass?path=${x.value['2']}' id="gimg"/> 
                    </div> 

                    <div class="fattri"> 

                        <ul class="ful"> 
                          
                             <a  href="profilehandler?user_id=${x.value['3']}">  
                                <li class="fname" style="font-family: 'Montserrat', sans-serif; font-size: 16px;margin-bottom: 5px;"> 
                                 ${x.value['4']}

                                </li> 
                            </a>
                            <li class="fname" style="font-family: 'Hind',sans-serif;"> 
                               <a onclick="window.open('http://www.integraluniversity.ac.in/','_blank');">Integral University,Lucknow</a>
                            </li>  
                        </ul> 

                    </div> 

                </div> 
                <div class="flistfooter" > 
                    <div class="fbutton" onclick="open1('${x.value['3']}', '${x.value['4']}');">
                        <img src="img/chatting.png" class="cimg"/> 
                        <p class="cvp" id="chatting" > Chating </p> 
                    </div> 
                    <div  class="fbutton" onclick="filesender('${x.value['3']}', '${x.value['4']}', 'f');"> 
                        <img src="img/file.png" class="gsfimf"/> 
                        <p class="gsfpara">sendFILE</p> 
                    </div> 

                </div> 
                <!--div class="flistdivider"> 
                </div--> 
            </div><!--end of flist-->
        </c:forEach>




    </body>
</html>
