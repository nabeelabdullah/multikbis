<%-- 
    Document   : book
    Created on : Jan 29, 2015, 4:25:34 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    <body>
<c:forEach var="x" items="${hash}">
    <div class="content">
                <table class="tbl">
                    <tr>
                        <td class="td_1">
                            <div class="pdt_img">
                                <img src='Book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}' height="100%" width="100%"/>
                            </div>
                        </td>
                        <td class="td_2">
                            <div class="td_2_mid">
                                <div class="mid_top">
                                    <a  class="title" href="Full_book_disp?uiid=${x.value['user_id']}&biid=${x.value['book_id']}">${x.value['title']}</a>
                                    <hr/>
                                </div>
                                <div class="mid_top_lft">
                                    <div class="usr_img">
                                        <img src='post_image_manager?uiid=${x.value['user_id']}' style="border-radius: 39px;" height="100%" width="100%"/>
                                    </div>
                                </div>
                                
                                <div class="mid_mid">
                                    <div class="cat"><p style="font-family: sans-serif;font-size: 13px;" >Catagory:&nbsp; ${x.value['catagory']}</p></div>
                                    <div class="col"><p onclick="window.open('http://www.integraluniversity.ac.in/','_blank');"  class="iu">Integral University Lucknow</p>
                                     
                                    </div>
                                </div>
                                 <div class="mid_btm">
                                     <div class="mid_btm_lft">
                                        ${x.value['b_date']} on ${x.value['b_day']} at ${x.value['b_time']}
                                     </div>
                                     <div class="rup">
                                        <div class="rupee"><p style="margin-top: 4px;">${x.value['price']}</p></div>
                                        <img src="../../image/rupee.png" height="30" width="30" style="float: right;;"/>                             
                                     </div>
                                    
                                </div>
                          
                        </td>
                    </tr>
                    
                </table>            
            </div>
    
    
</c:forEach>   
            
    </body>
</html>
