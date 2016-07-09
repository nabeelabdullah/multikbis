<%-- 
    Document   : post
    Created on : Dec 20, 2014, 1:44:31 AM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        
     <!--   <link href='http://fonts.googleapis.com/css?family=Hind|Roboto:400,300' rel='stylesheet' type='text/css'>-->
        <link href="../../post/post.css" type="text/css" rel="stylesheet"/>
        <script src="../../post/post.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body onscroll="_scroller();" id="mybody" onload="height_setter();">
        <img src='../../image/uploader2.gif' style="visibility: hidden;position: absolute;">
            <div id="main_header" >
                
               
                
                <div id="subheader">
                    
                   <!--   <div id="user_img">
                      <img src='post_image_manager?uiid=${e_u_id}' style="border-radius: 39px;" height="100%" width="100%" />
                    </div>-->
                    
                    <div style="float: left;margin-left: 38px; margin-top: 12px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                    
                    <div class="gohome" onclick="window.location.replace('usego_offline');">
                       <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 12px;margin-top: 8px; color: white;text-align: center;"> Log Out </p>   </div>
                    </div>
                
                   
                    
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                         <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 12px;margin-top: 8px; color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                    
                    <a href="SelfUserDisplay">
                     <div class="gohome">
                         <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/my_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 12px;margin-top: 8px;color: white;text-align: center;"> My Post </p>   </div>
                     </div>
                    </a>
                    <a href="NewPostDisplay">
                     <div class="gohome">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/new_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 12px;margin-top: 8px;color: white;text-align: center;"> New Post </p>   </div>
                     </div>
                    </a>
                    
                    <div id="inside_s_container">
                        <input type="text"  id="inputsearch"  name="searchtext" placeholder="Find your Post"/>   
                        <div id="searchbutton" onclick="itext_sender();" > 
                            <!--<img src="../../image/search.ico" height="25" width="25" style="margin-left: 10px;"/>-->
                            <input type="submit" id="hiddensubmitsearch">
                        </div>
                    </div>
                    
                </div>
               
            </div>
             <div id="container123">
                 <div id="container">
<c:forEach var="x" items="${hash}">
 
    <div class="contents">
        
                          <div class="c_header">
                              <table class="ta_header">
                                  <tr>
                                      <td colspan="2" class="ta_col" style="width: 100px;text-align: center;">Reference:</td>
                                      <td colspan="2" class="ta_col" style="text-transform: capitalize;">${x.value['topic']}</td>
                                      <!--<td colspan="2" class="ta_col" style="width: 50px;text-align: center;">Date:</td>
                                      <td colspan="2" class="ta_col" style="width: 120px;text-align: center;">14/DEC/2014</td>-->
                                  </tr>
                              </table>  
                          </div>
                        <div class="c_middle">
                            <div class="c_middle_1">
                                <div class="c_middle_1_left">
                                    
                                    <img src='post_image_manager?uiid=${x.value['user_id']}' height="100%" width="100%"/>
                                </div>
                                <div class="c_middle_1_right">
                                   <p class="name_para"><a href="sendreqprofilehandler?user_id=${x.value['user_id']}">${x.value['user_name']}</a></p>
                                    <p class="date_para" style="margin-left: 15px;">${x.value['p_date']} at ${x.value['p_time']} on ${x.value['p_day']}</p>
                                </div>
                            </div>
                            <div class="c_middle_2">
                               ${x.value['post']}
                            </div>
                             <div class="c_middle_3">
                                 <table class="c_middle_3_tbl" >
                                     <tr>
                                         <td  class="ta_coll_1" id='${x.value['post_id']}like_text' style=${x.value['style']}><b class="like"  onclick="like_sender('${x.value['post_id']}','${x.value['user_id']}');">Like</b></td>
                                         <td  class="ta_col" style="width: 60px;" id='${x.value['post_id']}like'>${x.value['like']}</td>
                                         <td  class="ta_col" style="width: 100px;text-align: center; font-family: serif; color: #0000FF;"><b>Comment</b></td>
                                         <td  class="ta_col" style="width: 60px;" id='${x.value['post_id']}cmt_f'>${x.value['no_of_comment']}</td>
                                         <td  class="ta_col" style="width: 100px;font-family: serif;color: #0000FF;text-align: center;"><b>Attachment</b></td>
                                         <td  class="ta_col" style="width: 20px;"><b id="like">${x.value['attach']}</b></td>
                                         <td  class="ta_col" style=" font-family: serif;color: #0000FF; padding-left: 330px;"><a href='FullPostDisplay?piid=${x.value['post_id']}'><b class="like">See more</b></a></td>
                                         
                                     </tr>
                                 </table>
                            </div>
                        </div>
                                       
                                      
                        <div class="c_footer" id="${x.value['post_id']}cmt">
               
                            <c:forEach var="x2" items="${x.value['detail']}">
                           
                                <div class="c_footer_1">
                                    <div class="c_footer_1_left">
                                        <img src='post_image_manager?uiid=${x2.value['c_user_id']}' height="100%" width="100%"/>
                                    </div>
                                    <div class="c_footer_1_right">   
                                        <p class="content_para"> 
                                            ${x2.value['comment']}
                                        </p>
                                        <div style="width: 100%; height: 4px;"></div>
                                        <p class="date_para"> ${x2.value['comment_date']} at  ${x2.value['comment_time']} <b class="_comment_like" id="${x2.value['comment_id']}cmt_likes_para"   onclick="cmt_like_sender('${x.value['user_id']}','${x.value['post_id']}',' ${x2.value['comment_id']}');" style=${x2.value['style']}>Like:</b> <h id="${x2.value['comment_id']}cmt_likes" >${x2.value['comment_like']}</h></p>
                                    </div>
                                </div>
                                        
                            </c:forEach>
                            
                            <div class="c_footer_3">
                                <div class="c_footer_3_left">
                                    <img src='post_image_manager?uiid=${e_u_id}' height="100%" width="100%"/>
                                </div>
                                <input type="text" class="c_footer_3_right" id="${x.value['post_id']}" placeholder="Write a comment and press Enter" onfocus="txt_sender('${x.value['user_id']}','${x.value['post_id']}');" onblur="txt_setter();"/>
                                <div class="_img" id="${x.value['post_id']}txt"> </div>
                                
                            </div>
                        </div>
                        
                    </div>
                                <div style="height: 50px;width:100%;margin: 0 auto; float: left; background-color: transparent;margin: 3px;">
                                
                                </div>

</c:forEach>
            
                </div>
            

             </div>
        
    </body>
</html>
