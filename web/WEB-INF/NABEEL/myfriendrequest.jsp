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

                </div> 
                <div class="flistmiddle"> 
                    <div class="fphoto"> 
                        <img src="imagepass?path=${x.value['1']}" id="gimg"/> 
                    </div> 

                    <div class="fattri"> 

                        <ul class="ful"> 
                            <li class="fname" onclick=" opennewtabforconcleprofile('${x.value['2']}', '${x.value['3']}');"> 
                                ${x.value['3']}

                            </li> 
                            <li> 
                                INTEGRAL UNIVERSITY 
                            </li> 
                        </ul> 

                    </div> 

                </div> 
                <div class="flistfooter" id="${x.value['4']}"> 
                    <div class="fbutton" onclick="request_cc('confurm', '${x.value['2']}');">
                        <img src="img/chatting.png" class="cimg"/> 
                        <p class="cvp" id="chatting" > CONFIRM </p> 
                    </div> 
                    <div  class="fbutton" onclick="request_cc('cancel', '${x.value['2']}');"> 
                        <img src="img/vidio.png" class="cimg"/> 
                        <p class="cvp"> CANCEL </p> 
                    </div> 

                </div> 

            </div><!--end of flist-->
        </c:forEach>
       

    </body>
</html>
