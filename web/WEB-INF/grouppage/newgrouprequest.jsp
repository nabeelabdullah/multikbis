<%-- 
    Document   : newgrouprequest
    Created on : Aug 24, 2014, 4:56:42 AM
    Author     : NABEEL
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
       <div class="glist">
                       <div class="glistheader">
                        </div> 
                        <div class="glistmiddle">
                            <div class="gphoto">
                               <img src="img/kitten1.jpg" id="gimg"/>              
                            </div> 
                           <div class="gattri"> 
 
                               <ul class="gul" style="margin-top: 10px;"> 
                                   <li class="fname" style="margin-bottom: 10px;" onclick=" opennewtabforsendreqpro('${x.value['s_id']}','${x.value['u_name']}');"> 
                                        ${x.value['u_name']}
                                    </li> 
                                    <li style="font-size: 12px; margin-bottom: 10px; color: blue;font-family: sans-serif;"> 
                                       Requested For Joinning
                                    </li> 
                                    <li> 
                                        ${x.value['g_name']}
                                    </li> 
                                </ul> 
                             </div> 
                        </div> 
                                    <div class="glistfooter" id="${x.value['id']}"> 
                            
                           
                            
                            <div  class="gbutton" onclick="sendtogroup('accept','${x.value['g_id']}','${x.value['s_id']}','${x.value['id']}');"> 
                               <img src="img/file.png" class="gsfimf"/> 
                                <p class="gsfpara">ACCEPT</p> 
                            </div> 
                            <div  class="gbutton" onclick="sendtogroup('reject','${x.value['g_id']}','${x.value['s_id']}','${x.value['id']}');"> 
                              <img src="img/sms.png" class="gsfimf"/> 
                               <p class="gsfpara">&nbsp;REJECT</p> 
                            </div>                             
                          
                          
                         
                        </div > 
                        <div class="glistdivider"> 
                        </div> 
                    </div><!--end of glist-->
              </c:forEach>
        
        
    </body>
</html>
