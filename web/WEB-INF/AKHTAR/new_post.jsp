<%-- 
    Document   : term_condition
    Created on : Oct 8, 2014, 9:22:49 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>MultiKBIS</title>
     <script src="../../new_post_file/new_post.js" type="text/javascript"></script>
     <script src="../../new_post/ckeditor/ckeditor.js" type="text/javascript"></script>
     <link href="../../new_post_file/new_post.css" type="text/css" rel="stylesheet" />
 <!--    <link href='http://fonts.googleapis.com/css?family=Hind|Roboto:400,300' rel='stylesheet' type='text/css'>-->
     <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
    </head>
    
    
        
    
    <body onload="txtfocus();">
        <img src='../../image/waitingfile.gif' style="position: absolute;visibility: hidden;"/>   
        <div id="p_light">
                        <div id="l_container">
                            <div id="l_footer">
                               
                                <div id="f_central">
                                   
                                </div>
                                
                            </div>
                            <div id="l_header">
                                <div id="close" onclick="close_bar();"><img src="../../image/close.ico" height="100%" width="100%"/></div>
                            </div>
                            
                        </div>
        </div>

        <div id="main_body"> 
            
            
             <div id="main_header" >
                
               
                
                <div id="subheader">
                    
                    <div id="user_img">
                       <img src='post_image_manager?uiid=${e_u_id}' style="border-radius: 39px;" height="100%" width="100%" /> 
                    </div>
                    
                    <div style="float: left;margin-left: 38px; margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                    </div>
                    
                    
                      
                    
                    <div class="gohome" onclick="  window.location.replace('usego_offline');">
                       <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center; "> Log Out </p>   </div>
                    </div>
                
                   
                    
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center; "> Go Home </p>   </div>
                    </div>
                    
                    <a href="SelfUserDisplay">
                     <div class="gohome">
                       <!--  <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/my_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center;"> My Post </p>   </div>
                     </div>
                    </a>
                    <a href="PostDisplay">
                     <div class="gohome">
                       <!--  <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                             <img src="../../image/my_post.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center; "> Share Ideas </p>   </div>
                     </div>
                    </a>
                   
                   
                    
                </div>
               
            </div>
            
               
          
          <div id="post_condition_container">
             <div id='post_condition_container_top'>
                 <p class='post_para'>WRITE YOUR POST</p>
              </div>
              <div id='nt_container'>
                  <textarea name='new_post_text_area' id="nptext_area">    
              </textarea>
              <script> 
          //    CKEDITOR.replace('nptext_area');
                 CKEDITOR.replace( 'nptext_area', {
	     //uiColor: 'transparant'
             frameColor:'white'
     
        
});


              </script>
              <div id='stopic'> 
                        <div style=" border: 1px solid transparent; height: 36px;width: 599px;float: left;">
                            <input type="text" name='t_text' placeholder="Write your Reference here" id="to_text">
                        </div>
                       
                  <div id="pattach_right" onmouseout="yourEvent();" onmouseover="myEvent();" onclick="file_uploader_click_2('fileToUpload_2');">
                                   <p class='att_para'>Upload File</p>
                                </div>
                    
              </div>
              <input type='file' name='fileToUpload' id='fileToUpload_2'  onchange='fileSelected_2();' />
                    <div id='pattach'> 
                        
                        <!--<div  class="pattach_left">
                                 <input type="file" name="fileToUpload" id="fileToUpload_2"  onchange="fileSelected_2();" />
                                 <div id="fileName_2" class="fname"></div>
                                 <div id="progressNumber_2" class="pnumber"></div>
                                 <div id="complitness_2"><div id="inside_complitness_2"></div></div>
                                 <div id="progress_bar_2">
                                    <div id="progress_bar_inner_2" class="pbarinner"></div>
                                 </div>
                                 <div id="progress_bar_close_2" class="pbarclose" onclick="hide_file_upload_2();">
                                    <img src='image/close.ico' id='closeicon' height='18' width='18'/>
                                 </div> 
                       </div>-->
                      
                        
                    </div>
              <div id='spost' onmouseover="myEvent2();" onmouseout="yourEvent2();" onclick="messageSubmitter();"> 
                          <p class='post_para'>SUBMIT</p>
              </div>
              
           
            </div>
          </div>
      </div>
    </body>
</html>
