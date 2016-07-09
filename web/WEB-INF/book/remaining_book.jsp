<%-- 
    Document   : book
    Created on : Jan 29, 2015, 4:25:34 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../book/book.css" type="text/css" rel="stylesheet"/>
        <script src="../../book/book.js" type="text/javascript"></script>
        <link href="http://fonts.googleapis.com/css?family=Tangerine|Inconsolata|Droid+Sans" type="text/css" rel="stylesheet"/>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>Multikbis</title>
    </head>
    <body>
        
         <div id="main_header" >
               
                <div id="subheader">
                    
                    <div id="user_img">
                        <img src='post_image_manager?uiid=${e_u_id}' style="border-radius: 39px;" height="100%" width="100%"/>
                    </div>
                    
                    <div style="float: left;margin-left: 38px; margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                  
                    <div class="gohome" onclick="window.location.replace('usego_offline');">
                     <!--    <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                           <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                     
                     </div> -->   
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center; margin-top: 10px;"> Log Out </p>   </div>
                    </div>
                
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                        <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                           <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                           </div> -->   
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center; margin-top: 10px;"> Go Home </p>   </div>
                    </div>
                    <div class="gohome" onclick="window.open('New_book_disp','_self');">
                        <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div> -->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center; margin-top: 10px;"> New Book </p>   </div>
                    </div>
                    
                    
                    
                </div>
               
            </div>        
                    <div id="main_container">
 <div id="container">
     
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
                                    <div class="cat"><p style="font-family: sans-serif;font-size: 13px;">Catagory:&nbsp;; ${x.value['catagory']}</p></div>
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
<c:set var="mul" value="5"/>
                    <div id="bottom">
                        <div id="inside_btm">
                            <div id="btm_mid">
                                <c:if test="${b_valid==1}">
                                   <a href="Remaining_book?value=${sessionScope.bck}"><div id="btm_nxt"><p id="btm_p2"><strong>Back</strong></p></div></a>
                                </c:if> 
                                   <%int i=10; %>
                                   <c:forEach var="z" items="${cnt}" >
                                        
                                        <% 
                                        if(i==10)
                                        {
                                        %>
                                            <a href='Remaining_book?value=${z.value}'><div class="btm_1" style="background-color: #C0C0C0;color:#1A0DB2;" ><p class="btm_p">${z.value}</p></div></a>        
                                        <%i=15;
                                        }
                                        else
                                        {
                                        %>
                                         <a href='Remaining_book?value=${z.value}'><div class="btm_1" ><p class="btm_p">${z.value}</p></div></a>           
                                        <%}%>
                                          
                                      
                                        
                                   </c:forEach>
                                  
                                    <%--<c:if test="${next!=0}">
                                         <!-- <a href="Remaining_book?value=${next}"><div id="btm_nxt"><p id="btm_p2"><strong>Next</strong></p></div></a>-->
                                    </c:if>--%>
                                    
                            </div>
                       </div>
                    </div> 
            
             
             
        </div>    
    </div>
    </body>
</html>
