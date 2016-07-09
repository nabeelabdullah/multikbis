<%-- 
    Document   : full_book
    Created on : Feb 1, 2015, 9:39:26 AM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind|Montserrat' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MultiKBIS</title>
        <script src="../../full_book/full_book.js" type="text/javascript"></script>
        <link href="../../full_book/full_book.css" type="text/css" rel="stylesheet" />
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    <body>
        <img src='Full_book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}&vall=0' height="100%" width="100%" style="position: absolute;visibility: hidden;"/>
        <img src='Full_book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}&vall=1' height="100%" width="100%" style="position: absolute;visibility: hidden;"/>
        <img src='Full_book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}&vall=2' height="100%" width="100%" style="position: absolute;visibility: hidden;"/>
        <img src='Full_book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}&vall=3' height="100%" width="100%" style="position: absolute;visibility: hidden;"/>
        <div id="main_header" >
               
                <div id="subheader">
                    
                    <div id="user_img">
                        <img src='post_image_manager?uiid=${e_u_id}' style="border-radius: 39px;" height="100%" width="100%"/>
                    </div>
                    
                    <div style="float: left;margin-left: 38px; margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                  
                    <div class="gohome" onclick="window.location.replace('usego_offline');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                           <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center; "> Log Out </p>   </div>
                    </div>
                
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                         <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                          <!--     <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center; "> Go Home </p>   </div>
                    </div>
                    <div class="gohome" onclick="window.open('NewBookDisplay','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center; "> Add Book </p>   </div>
                    </div>
                    
                    
                    
                </div>
               
            </div>
                    <div id="main_cotainer">
                        
                        <div id="container">
<c:forEach var="x" items="${hash}">
                            <div id="content_header">
                                <table id="tbl_hdr">
                                    <tr>
                                        <td class="nxt_bck"><p style="font-size: 12px;float: left;color:#006AFF;">Back</p></td>
                                        <td id="mdle"></td>
                                    </tr>
                                </table>
                            </div>
                            <div id="til">
                                <div id="til_top">
                                    <div class="rup">
                                        <div class="rupee"><p style="margin-top: 2px;">${x.value['price']}</p></div>
                                        <img src="../../image/rupee.png" height="30" width="30" style="float: right;;"/>                             
                                     </div>
                                    <div id="title">
                                        <p style="margin: 0;padding: 0;font-size: 17px;font-family:'Montserrat',sans-serif;">${x.value['title']}</p>
                                    </div>
                                        <p style="font-size: 14px;font-family: 'Hind', sans-serif;width: 300px; color: black;/*color: #978270;*/ text-transform: capitalize;">Author :&nbsp; ${x.value['author']}</p>
                                    <p style="font-size:12px;font-family: 'Hind', sans-serif;margin-top: 3px;margin-bottom: 3px; color: #978270;">${x.value['b_date']} on ${x.value['b_day']} at ${x.value['b_time']}</p>
                                    <hr style="margin: 0;padding: 0;"/>
                                </div>
                                 <div id="til_btm">
                                     <div id="ur_nm">
                                         <a href="sendreqprofilehandler?user_id=${x.value['user_id']}" style="color: #1900FF;font-family: sans-serif;font-size: 14px;">${x.value['seller_name']}</a>
                                         <a onclick="window.open('http://www.integraluniversity.ac.in/','_blank');"><p style="font-size: 12px; font-family: 'Hind', sans-serif; margin-top: 3px;color: #1900FF;;">Integral University Lucknow</p></a>
                                    </div>
                                     
                                    <div id="ur_img">
                                        <img src='post_image_manager?uiid=${b_u_id}' style="border-radius: 39px;" height="100%" width="100%"/>
                                    </div>
                                </div>
                               
                                
                            </div>
                            <div id="bk_img">
                                
                                <div id="photo_lft">
                                    <div id="photo_lft_1">
                                        <div class="im" onclick="img_chgr('${x.value['user_id']}','${x.value['book_id']}','1');"><img src="../../image/slide_lft.png" height="100%"width="100%"/></div>
                                    </div>
                                    <div id="photo_lft_2">
                                        <img src='Full_book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}&vall=0' height="100%" width="100%" />
                                    </div>
                                </div>
                                <div style="height: 412px;margin-left: 5px;width: 1px;background-color: rgba(0,0,0,0.1);float: left;"></div>
                                <div id="photo_rgt">
                                     <div id="photo_rgt_1">
                                         <div class="im" onclick="img_chgr('${x.value['user_id']}','${x.value['book_id']}','2');"><img src="../../image/slide_rgt.png" height="100%"width="100%"/></div>
                                     </div>
                                     <div id="photo_rgt_2">
                                        <img src='Full_book_image_manager?uiid=${x.value['user_id']}&biid=${x.value['book_id']}&vall=1' height="100%" width="100%" "/>
                                     </div>
                                </div>
                            </div>
                                <!--<div id="all_img">
                                    <div class="img_1" style="margin-left: 240px;"></div>
                                      <div class="img_1"></div>
                                      <div class="img_1"></div>
                                      <div class="img_1"></div>
                                    
                                </div>-->
                                <div id="dismiss">
                                    <p style="font-size: 15px;font-family: 'Hind', sans-serif;font-style: italic; margin: 0;padding: 0;color: #978270;">Discription&nbsp;:</p>
                                    <p style="font-size: 13px;font-family: 'Hind', sans-serif; margin-top: 3px;"> ${x.value['description']}</p>
                                </div>
                                <div id="cnt">
                                    <p style="font-size: 15px;font-family: 'Hind', sans-serif;font-style: italic; margin: 0;padding: 0;color: #978270;">Seller info:</p>
                                    <div id="n_e">
                                        
                                        <table>
                                            <tr>
                                                <td id="con_lft"><p style="color:#606060;font-size: 14px;margin-top: 10px; font-family: 'Hind', sans-serif;float: left">Email</p></td>
                                                <td id="con_rgt"><p style="color:#606060;margin-top: 10px; font-family: 'Montserrat', sans-serif;font-size: 13px;">${x.value['email']}</p></td>
                                            </tr>
                                            <tr>
                                               <td id="m_lft"><p style="color:#606060;margin-top: 10px;font-size: 14px; font-family: 'Hind', sans-serif;float: left;">Contact No</p></td>
                                               <td id="m_rgt"><p style="color:#606060;margin-top: 10px; font-family: 'Montserrat', sans-serif;font-size: 13px;">+91-${x.value['mobile']}</p></td>
                                            </tr>
                                            <tr>
                                               <td id="a_lft"><p style="color:#606060;margin-top: 10px;font-size: 14px; font-family: 'Hind', sans-serif;float: left;">Availability Address</p></td>
                                               <td id="a_rgt"><p style="color:#606060;margin-top: 10px; font-family: 'Montserrat', sans-serif;font-size: 13px;">${x.value['address']}</p></td>
                                            </tr>
                                        </table>
                                    </div>
                                    
                                </div>
                                <p style="margin: 0;padding: 0;color: rgba(0,0,0,0.3);font-family: sans-serif;font-size: 10px;margin-left: 340px;float: bottom;">&copy; 2014-2015 MultiKBIS.com</p>
</c:forEach>               
                        </div>
   
                    </div>
                    
    </body>
</html>
