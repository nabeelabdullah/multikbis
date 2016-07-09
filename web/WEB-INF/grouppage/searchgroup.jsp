<%-- 
    Document   : searchgroup
    Created on : Oct 1, 2014, 3:26:22 AM
    Author     : NABEEL
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Montserrat|Hind' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body>
      
                    <c:forEach var="x" items="${hash}">
                  <div class="glist">
                       <div class="glistheader">
                        </div> 
                      <a href="searchgroup.jsp"></a>
                        <div class="glistmiddle">
                            <div class="gphoto">
                               <img src="img/kitten1.jpg" id="gimg"/>              
                            </div> 
                           <div class="gattri"> 
 
                                <ul class="gul"> 
                                   
                                    <li class="fname" style="font-family: 'Montserrat', sans-serif; font-size: 16px; margin-bottom: 5px;"> 
                                                    ${x.value['name']}
                                    </li> 
                                    <li class="fname" style="font-family: 'Hind',sans-serif;"> 
                                                   <a onclick="window.open('http://www.integraluniversity.ac.in/','_blank');">Integral University,Lucknow</a>
                                    </li> 
                                </ul> 
                             </div> 
                        </div> 
                        <div class="glistfooter" > 
                            <c:choose>
                                <c:when test="${x.value['condition']=='true'}">
                            
                              <div  class="gbutton" onclick=" questiontab('${x.value['g_id']}');"> 
                               <img src="img/file.png" class="gsfimf"/> 
                                <p class="gsfpara">QUESTION</p> 
                            </div> 
                           <!-- <div  class="gbutton"> 
                              <img src="img/sms.png" class="gsfimf"/> 
                               <p class="gsfpara">&nbsp;sendSMS</p> 
                            </div> -->                            
                            <div  class="gbutton" onclick="filesender('${x.value['g_id']}','${x.value['name']}','g')"> 
                               <img src="img/file.png" class="gsfimf"/> 
                                <p class="gsfpara">sendFILE</p> 
                            </div> 
                                </c:when>
                              <c:otherwise>
                                 
                                               
                            <div  class="gbutton" onclick="questiontab('${x.value['g_id']}');"> 
                               <img src="img/file.png" class="gsfimf"/> 
                                <p class="gsfpara">QUESTION</p> 
                            </div> 
                               <div class="gbuttonc" id="${x.value['this_id']}">  <div class="gbuttonic"    onclick="grouprequest_sender('${x.value['g_id']}','${x.value['this_id']}');"> 
                              <img src="img/sms.png" class="gsfimf"/> 
                               <p class="gsfpara">&nbsp;Send Request.</p> 
                            </div>   </div>    
                               </c:otherwise>
                           </c:choose>
                          
                        </div > 
                        <div class="glistdivider"> 
                        </div> 
                    </div><!--end of glist-->
                    </c:forEach>
                

    </body>
</html>
