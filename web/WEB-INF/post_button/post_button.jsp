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
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body>
           
<c:forEach var="x" items="${hash}">
 
    <div class="contents">
        
                          <div class="c_header">
                              <table class="ta_header">
                                  <tr>
                                      <td colspan="2" class="ta_col" style="width: 100px;text-align: center;">Reference:</td>
                                      <td colspan="2" class="ta_col" style="">${x.value['topic']}</td>
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
                                             <div style="height: 2px;width:852px;margin: 0 auto; background-color: #989898; float: left;"></div>                   

</c:forEach>
      
    </body>
</html>
