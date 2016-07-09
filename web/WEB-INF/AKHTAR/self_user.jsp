<%-- 
    Document   : self_user
    Created on : 13 Jul, 2014, 2:10:31 AM
    Author     : akhtar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html id="html">
    <head>    
         <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>MultiKBIS</title>
        <link href="self_user/self_user.css" type="text/css" rel="stylesheet"/>
        <script src="self_user/self_user.js" type="text/javascript"></script>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    <body onscroll="_scroller();"  onload="height_setter();" id="mybody">
          
        
        <div id="maximize_self_user">
            <img src='image/uploader1.gif' id='image_uploader1' height='15' width='40'/>
            <div id="maximize_inside_self_user">
                <div id="maximize_header_self_user">
                    
                    <div id="exit1_close" >
                        <img id="bbc" src='image/close.ico' height='24' width='23' onclick="abcclose_self_user();"/>
                    </div>
                </div>
                <div id="bottom_maximize_self_user"></div>
                <!--<div id="bottom_maximize_self_user_below_container">
                                       
                    <div class='attached' onmousemove="_color_changer();" onmouseout="_color_dechanger();" onclick="downloader();">
                                    <p style="text-align: center;margin: 0;padding: 0; margin-top: 10px; color:#b2afaf;"><strong>Download</strong></p>
                                    <div class='attached_1' >

                                        <div class="fold_img_1"><div class="fold_img_2" style="width: 0; ;border-bottom: 13px solid #C4C4C4;border-left: 15px solid transparent;float: left; margin-top: 2px;"></div></div>
                                        <div  style="width: 0;height: 0;border-top: 15px solid #0082EF;border-right: 15px solid transparent; float: left"></div>   

                                    </div>
                    </div>
                                       
                </div>-->
            </div>
        </div>
        
        
        
        
        <div id="maximize_self_user_edit">
            <div id="maximize_inside_self_user_edit">   
                <div id="maximize_header_self_user_edit">
                    <div id="close_EXIT_self_user_edit" onclick="closeEdit();"><img src='image/close.ico'  height='100%' width='100%'/></div>
                </div>
                <div id="bottom_maximize_self_user_edit">
                    
                    <div id="ta_td_1"><p style="margin: 0;padding: 0;margin-top: 5px;text-align: center;">Reference:</p></div>
                            <div id="ta_td_2"></div>
                
                    </table>
                    <div contenteditable="true"  id="self_user_textarea" name="textarea_self" onkeyup="abc_edit_post_undo('self_user_textarea');">
                        
                    </div>
                </div>
                <div id="self_user_post_submit_div" onclick="messageSender();">
                    <p style="margin: 0;padding: 0;text-align: center;margin-top: 8px;">SUBMIT</p>
                </div>
            </div>
        </div>

        
        
        
        
        
        
              <div id="main_header" >   
                <div id="subheader">
                    
                    <div id="user_img">
                        <img src='post_image_manager?uiid=${e_u_id}' style="border-radius: 39px;" height="100%" width="100%"/>
                    </div>
                    
                    <div style="float: left;margin-left: 38px; margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                    
                    
                    <div class="gohome" onclick="  window.location.replace('usego_offline');">
                       <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center;"> Log Out </p>   
                          </div>
                    </div>
                
                   
                    
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                    
                    <a href="PostDisplay">
                     <div class="gohome">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/new_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px;color: white;text-align: center;"> New Post </p>   </div>
                     </div>
                    </a>
                    
                    <div id="inside_s_container">
                        <input type="text"  id="inputsearch" placeholder="Find your Post"/>   
                        <div id="searchbutton" onclick="itext_sender();" > 
                            <img src="../../image/search.ico" height="25" width="25" style="margin-left: 10px;"/>
                            
                        </div>
                    </div>
                    
                </div>
              </div>  
        
        
        
        <div  style="margin: 0 auto;width:780px; height: 100%;background-color: transparent;  ">

            <div id="content">
                
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
                                <div class="_tep_new" style="border-radius: 3px;border: 1px solid transparent;height: 30px;width:100px; background-color:#D00000; margin: 0 auto;"><p style="  margin-top: 5px;text-align: center; color: white;" onclick="delete_comment('${x.value['post_id']}');">Click Here</p></div>
                            </div>
                            <div id='${x.value['post_id']}container' style=" float: left;width: 0;height: 0;border-top: 10px solid transparent;border-left: 22px solid #F0F0F0; ;border-bottom: 10px solid transparent; background-color: transparent;">
                                
                            </div>
                        </div>
                        
                        
                    </div><!--end of matter matter_containerbottom-->

                    
                    

                </div><!--end of matter container-->


</c:forEach>
            </div>
        </div>

    </body>
</html>