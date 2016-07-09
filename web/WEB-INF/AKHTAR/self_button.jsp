<%-- 
    Document   : self_scroll
    Created on : Jan 22, 2015, 10:38:18 AM
    Author     : akhtar
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
            <div class="matter_container" id="w1">

                        <div class="setting_container" id='${x.value['post_id']}' onmouseout="close_setting_bar('${x.value['post_id']}');">
                            
                           
                            <div id="setting_image_container">
                            </div><!--end of setting_image_container-->
                        </div><!--end setting-->
                        
                        <!--setting div close------------------------------------------------->
                        
                    <div class="image">
                       <img src='self_image_manager?uiid=${e_u_id}'height="100%" width="100%" />
                    </div><!--end imagediv-->
                    <div class="text_matter" class="a1">
                       ${x.value['post']}
                       
                      
                    </div><!--end of text_matter-->

                    <div class="matter_containerbottom">
                        <div class="visitor_name" id="b1" style="text-transform: capitalize;">
                            <p style="margin: 0;padding: 0;text-align: center;margin-top: 2px;font-size: 13px;"><c:out value="${x.value['user_name']}"/></p>
                        </div>


                        <img src="image/maximize.ico" class="text_letter1"  height="21" width="22" style="margin-top:3px;" onclick="common_maximize('${x.value['user_id']}','${x.value['post_id']}', '1','${x.value['topic']}');"/> 
                        <img src="image/deleteicon.ico" class="text_letter1"  height="21" width="22" style="margin-top:3px; margin-right: 10px;" onclick="delete_temp('${x.value['post_id']}');"/> 
                        <img src="image/editicon2.ico" class="text_letter1"  height="21" width="22" style="margin-top:3px; margin-right: 10px;" onclick="common_maximize('${x.value['user_id']}','${x.value['post_id']}', '2','${x.value['topic']}');"/> 
                       
                        <div class="like_count" id="c1">${x.value['like']}</div><!--like_count-->


                        <div id="text_letter3"><p style="margin: 0;padding: 0;text-align: center;margin-top: 2px;font-size: 13px;">Like</p></div>
                        
                        <div  id="self_user_topic"><p style="margin: 0;padding: 0;margin-left: 5px;margin-top: 2px;font-size: 13px;"><c:out value="${x.value['topic']}"/></p></div>
                        <div id="text_letter4"> <p style="margin: 0;padding: 0;text-align: center;margin-top: 2px;font-size: 13px;">Reference</p></div>
                      
                       
                        
                        
                        <div id="${x.value['post_id']}container" style="margin-left: 486px;height: 102px;width: 200px;border: 0px solid transparent; background-color:transparent; position: absolute; visibility: hidden;" onMouseOver="this.style.cursor='default';" onMouseOut="this.style.cursor='pointer';">
                           
                            <div  style=" float: left ;border: 1px solid rgba(0,0,0,0.1);height: 100px;width: 175px;font-size: 13px;font-family: monospace; background-color:#F8F8F8;">
                                <p style="text-align: center;">Are you sure want to delete?</p>
                                <div class="_tep_new" style="border-radius: 3px;border: 1px solid transparent;height: 30px;width:100px; background-color:#D00000; margin: 0 auto;"><p style="  margin-top: 5px;text-align: center;" onclick="delete_comment('${x.value['post_id']}');">Click Here</p></div>
                            </div>
                            <div id='${x.value['post_id']}container' style=" float: left;width: 0;height: 0;border-top: 10px solid transparent;border-left: 22px solid #F0F0F0; ;border-bottom: 10px solid transparent; background-color: transparent;">
                                
                            </div>
                        </div>
                        
                        
                    </div>

                    
                    

                </div>
        
          
</c:forEach>
    </body>
</html>
