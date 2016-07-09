<%-- 
    Document   : post
    Created on : Dec 20, 2014, 1:44:31 AM
    Author     : akhtar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href='http://fonts.googleapis.com/css?family=Hind|Roboto:400,300' rel='stylesheet' type='text/css'>
<!DOCTYPE html>
<html>
    <head>
        <!--<link href="../../full_post/full_post.css" type="text/css" rel="stylesheet"/>-->
        <script src="../../full_post/full_post.js" type="text/javascript"></script>
        <link href="../../post/post.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body onscroll="_scroller();" id="mybody" onload="height_setter();">
      <img src='../../image/uploader2.gif' style="visibility: hidden;position: absolute;">
            <div id="main_header">
             
                       
                <div id="subheader">
                    
                 <!--   <div id="user_img">
                         <img src='post_image_manager?uiid=${e_u_id}' style="border-radius: 39px;" height="100%" width="100%"/>
                    </div> -->
                    
                    <div style="float: left;margin-left: 38px; margin-top: 15px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                    
                    
                      
                    
                    <div class="gohome" onclick="  window.location.replace('usego_offline');">
                       <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center;"> Log Out </p>   </div>
                    </div>
                
                   
                    
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                    
                    <a href="SelfUserDisplay">
                     <div class="gohome">
                         <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/my_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center;"> My Post </p>   </div>
                     </div>
                    </a>
                    
                    </a>
                    <a href="NewPostDisplay">
                     <div class="gohome">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/new_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center;"> New Post </p>   </div>
                     </div>
                    </a>
                    
                    <div id="inside_s_container">
                        <input type="text"  id="inputsearch"  name="searchtext" placeholder="Find your Post"/>   
                        <div id="searchbutton" onclick="itext_sender();" > 
                            <img src="../../image/search.ico" height="25" width="25" style="margin-left: 10px;"/>
                            <input type="submit" id="hiddensubmitsearch">
                        </div>
                    </div>
                    
                </div>
               
                
            </div>
           
        <div style="margin: 0 auto;width: 1000px; height: 100%;background-color: transparent;">
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
                            <div class="c_middle_2" >
                                 ${x.value['post']}
                                
                            </div>
                             <div class="c_middle_3">
                                 <table class="c_middle_3_tbl" >
                                     <tr>
                                         <td  class="ta_coll_1" id='${x.value['post_id']}like_text' style=${x.value['style']}><b class="like"  onclick="like_sender('${x.value['post_id']}','${x.value['user_id']}','${x.value['user_name']}');">Like</b></td>
                                         <td  class="ta_col" style="width: 60px;" id='${x.value['post_id']}like'>${x.value['like']}</td>
                                         <td  class="ta_col" style="width: 100px;text-align: center; font-family: serif; color: #0000FF;"><b>Comment</b></td>
                                         <td  class="ta_col" style="width: 60px;" id='${x.value['post_id']}cmt_f'>${x.value['no_of_comment']}</td>
                                         <td  class="ta_col" style="width: 100px;font-family: serif;color: #0000FF;text-align: center;"><b>Attachment</b></td>
                                         <td  class="ta_col" style="width: 20px;"><b id="like">${x.value['attach']}</b></td>
                                         <td  class="ta_col" style=" font-family: serif;color: #0000FF; padding-left: 330px;"><b class="like"></b></a></td>
                                         
                                     </tr>
                                 </table>
                            </div>
                            <div class='c_middle_4'>
                                <p class='people' id="${x.value['post_id']}_div">People like this:&nbsp;<strong class="people_b">${x.value['matter']}</strong></p>
                            </div>
                                <c:if test="${x.value['attach']>0}">
                                    <div class='c_middle_5'>
                                        <div style="height:57px;max-width:300px;text-align: center; margin: 0 auto;">
                                                <c:forEach var="i" begin="1" end="${x.value['attach']}">
                                                    <a  style="text-decoration: none;" onclick="window.open('downloader?uiid=${x.value['user_id']}&piid=${x.value['post_id']}&param=${i}','_blank');">
                                                   <div id="${i}" class='attached' onmousemove="_color_changer('${i}','${i}1','${i}2');" onmouseout="_color_dechanger('${i}','${i}1','${i}2');">
                                                        <p style="text-align: center;margin: 0;padding: 0; margin-top: 10px; color:#b2afaf;"><strong>Download</strong></p>
                                                        <div class='attached_1' >

                                                            <div id="${i}1" class="fold_img_1"><div id="${i}1" class="fold_img_2" style="width: 0; ;border-bottom: 13px solid #C4C4C4;border-left: 15px solid transparent;float: left; margin-top: 2px;"></div></div>
                                                            <div  style="width: 0;height: 0;border-top: 15px solid #0082EF;border-right: 15px solid transparent; float: left"></div>   

                                                        </div>
                                                   </div>
                                                 </a>
                                                </c:forEach>
                                        </div>
                                    </div>
                                </c:if>
                            
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
          <div style="height: 2px;width:852px;margin: 0 auto; float: left; margin-top: 5px;"></div>
</c:forEach>
                    <!--<hr/>-->
                         
         </div>
    </div>
    </body>
</html>
