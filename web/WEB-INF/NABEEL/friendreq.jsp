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
        <div style="width: 100%; height: 20px;"></div>
        <c:forEach var="x" items="${hash}">
            <div class="flistsf"> 
                <div class="flistheader"> 

                </div> 
                <div class="flistmiddlesf"> 
                    <div class="fphotosf"> 
                        <img src="imagepass?path=${x.value['1']}" id="gimg"/> 
                    </div> 

                    <div class="fattrisf"> 

                        <ul class="fulsf" style="font-size: 10px;"> <!--onclick=" opennewtabforsendreqpro('${x.value['2']}', '${x.value['3']}');"--> 
                             <a  href="sendreqprofilehandler?user_id=${x.value['2']}">  
                                <li class="fname" style="font-family: 'Montserrat', sans-serif; font-size: 16px;margin-bottom: 5px;"> 
                                 ${x.value['3']}
                                </li> 
                            </a>
                            <li class="fname" style="font-family: 'Hind',sans-serif;"> 
                                     <a onclick="window.open('http://www.integraluniversity.ac.in/','_blank');">Integral University,Lucknow</a>
                            </li>  
                        </ul> 

                    </div> 

                </div> 
                <div class="flistfootersf" id="${x.value['4']}" > 
                    <div class="fsbutton" onclick="frequest_sender('${x.value['2']}');">
                        <img src="img/request.png" class="cimg"/> 
                        <p class="cvp" id="chatting"  > &nbsp; Send Request. </p> 
                    </div> 


                </div> 

            </div>
                      
        </c:forEach>

    </body>
</html>
