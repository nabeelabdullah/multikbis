<%-- 
    Document   : sell
    Created on : Jan 27, 2015, 8:08:38 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind|Montserrat' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
        <link href="../../new_book/new_book.css" type="text/css" rel="stylesheet"/>
        <script src="../../new_book/new_book.js" type="text/javascript"></script>
    </head>
    <body id="my_body">
        
        <div id="res_light">
            <div id="gif"></div>
        </div>
        
        <div id="maximize">
            <div id="max_content">
                <table id="cat_ta">
                    <tr>
                        <td style="width: 345px;"><p style="text-align: center;margin-top: 10px; font-family: 'Hind', sans-serif;font-weight: 900;">Books Category</p></td>
                        <td style="width: 225px; background-color: white;"><div style="width: 0;height: 0;border-top: 24px solid transparent;border-left: 13px solid #E8E8E8;border-bottom: 24px solid transparent;"></div></td>
                        <td style="width: 40px; border: 1px solid rgba(0,0,0,0.1);background-color: white;" onclick="max_hider();"><img src="../../image/book_close.png" height="30" width="30" style="margin-left: 5px;"/></td>
                    </tr>
                </table>
                <div id="max_lft">
                    <div id="inside_cont_lft">
                        <div class="lft_1"  onclick="inside_cont_rgt_opn();"><p id="lft_p_1" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Educationals <img src="../../image/drop_left.png" height="20" width="20" style="float: right;"></p></div>
                        <div class="lft_1"  onclick="con_setter('lft_p_2');"><p id="lft_p_2" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Magazines</p></div>
                        <div class="lft_1"  onclick="con_setter('lft_p_3');"><p id="lft_p_3" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Novels</p></div>
                        <div class="lft_1"  onclick="con_setter('lft_p_4');"><p id="lft_p_4" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Others</p></div>
                        
                    </div>
                </div>
                <div id="max_rgt">
                    <div id="inside_cont_rgt">
                        <div class="lft_1" onclick="con_setter('rgt_p_1');"><p id="rgt_p_1" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Engineering</p></div>
                        <div class="lft_1" onclick="con_setter('rgt_p_2');"><p id="rgt_p_2" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Medical</p></div>
                        <div class="lft_1" onclick="con_setter('rgt_p_3');"><p id="rgt_p_3" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Management</p></div>
                        <div class="lft_1" onclick="con_setter('rgt_p_4');"><p id="rgt_p_4" style="text-align: center;margin-top: 7px; font-family: 'Hind', sans-serif;">Other</p></div>
                        
                    </div>
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
                  
                    <div class="gohome" onclick="window.location.replace('usego_offline');">
                       <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <img src="../../img/logout.jpg" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                          </div>-->
                          <div style="width: 80px ;height: 100%;float: right;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center;"> Log Out </p>   </div>
                    </div>
                
                    <div class="gohome" onclick="window.open('GoHome','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                     <div class="gohome" onclick="window.open('BookDisplay','_self');">
                        <!-- <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                               <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                         </div>-->
                           <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 14px;margin-top: 8px; color: white;text-align: center; "> Book Shop </p>   </div>
                    </div>
                    
                    
                    
                </div>
               
            </div>
                    
                    
                    <div id="container">
                        
                        <div id="content">
                            <div id="content_header">
                                <p id="reg_para">Ragister Products</p>
                            </div>
                            
                            <div class="content_1">
                                <table class="title_ta">
                                <tr>
                                    <td class="content_1_left">
                                        <p class="content_1_left_para" style="margin-left: 40px; margin-top: 18px;">Title</p>
                                    </td>
                                    <td id="content_1_right">
                                        <input type="text" class="ip" id="ip1" placeholder="Enter Title" onfocus="div_col_changer('content_1_right');" onblur="div_col_unchanger('content_1_right');"/>
                                    </td>
                                </tr>
                                </table>
                            </div>
                            
                            <div class="content_2">
                                 <table class="title_ta">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style="margin-left: 40px; margin-top: 18px;">Category</p>
                                        </td>
                                        <td id="content_2_right">
                                            <div class="ip" id="ip2" onclick="opn_max();">
                                                <div id="ip2_inside" style="height: 20px;width: 540px; float: left; margin-top: 10px;"></div>
                                                <img src="../../image/drop.png"height="15" width="15" style=" margin-top: 12px;float: right;">
                                            </div>
                                        </td>
                                    </tr>
                                 </table>
                            </div>
                            <div class="content_3">
                                 <table class="title_ta">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style="margin-left: 40px; margin-top: 18px;">Author</p>
                                        </td>
                                        <td id="content_3_right">
                                            <input type="text" class="ip"  id="ip3" placeholder="Enter Author Name" onfocus="div_col_changer('content_3_right');" onblur="div_col_unchanger('content_3_right');"/>
                                        </td>
                                    </tr>
                                 </table>
                            </div>
                            <div class="content_4">
                                  <table class="title_ta">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style="margin-left: 40px; margin-top: 18px;">Price</p>
                                        </td>
                                        <td id="content_4_right">
                                            <div class="rupee"><img src="../../image/rupee.png" height="100%" width="100%"/></div>
                                            <input type="text" class="ip_pri" id="ip4" placeholder="Enter Price" onfocus="div_col_changer('content_4_right');" onblur="div_col_unchanger('content_4_right');" onkeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;"/>
                                        </td>
                                    </tr>
                                 </table>
                            </div>
                            
                            <div class="content_5">
                                  <table id="title_dis">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style="margin-left: 40px; margin-top: 30px;">Description</p>
                                        </td>
                                        <td id="content_5_right">
                                            <textarea class="ip_txt" id="ip5" placeholder="Mention  Feature, Defects, reason of selling." onfocus="div_col_changer('content_5_right');" onblur="div_col_unchanger('content_5_right');"></textarea>
                                        </td>
                                    </tr>
                                 </table>
                            </div>
                            
                              <div class="content_8">
                                  <table class="title_ta">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style="margin-left: 40px; margin-top: 18px;">Email</p>
                                        </td>
                                        <td id="content_8_right">
                                            <input type="email" class="ip" id="ip8" placeholder="Enter Email" onfocus="div_col_changer('content_8_right');" onblur="div_col_unchanger('content_8_right');"/>
                                        </td>
                                    </tr>
                                 </table>
                            </div>
                            
                             <div class="content_6">
                                 <table class="title_ta">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style="margin-left: 40px; margin-top: 18px;">Mobile Number</p>
                                        </td>
                                        <td id="content_6_right">
                                            <div id="extCnt">
                                                <div class="ext"><p style="text-align: center; font-family:sans-serif;margin-top: 12px; font-size: 13px;">+91</p></div>
                                                <input type="text" class="ip_mob" id="ip6" placeholder="Enter Mobile Number" onfocus="div_col_changer('content_6_right');" onblur="div_col_unchanger('content_6_right');" onkeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;"/>
                                            </div>
                                        </td>
                                                <div id='alert_no' style="margin-left: 750px;height: 82px; margin-top: 20px;width: 180px;border: 0px solid transparent;; background-color:transparent; position: absolute; visibility: hidden;">
                                                    <div  style=" float: left;width: 0;height: 0;border-top: 10px solid transparent;border-right: 22px solid #E0E0E0; ;border-bottom: 10px solid transparent; background-color: transparent;">

                                                    </div>
                                                    <div  style="padding: 10px; float: left;height: 80px;width: 120px;font-family:'Hind',sans-serif; background-color:#E0E0E0;border-radius: 2px;">
                                                            <p style="text-align: center; font-size: 12px;">This field will be public MultiKBIS is not responsible for any Claim !</p>
                                                           <!-- <div class="_tep_new" style="border-radius: 3px;border: 1px solid transparent;height: 30px;width:100px; background-color:#D00000; margin: 0 auto;"><p style="  margin-top: 5px;text-align: center;" onclick="delete_comment('');">Click Here</p></div>-->
                                                    </div>       
                                               </div>
                                    </tr>
                                 </table>
                            </div>
                            <div class="content_9">
                                 <table class="title_ta">
                                    <tr>
                                        <td class="content_1_left">
                                            <p class="content_1_left_para" style=" margin-top: 18px;">Availibility Address</p>
                                        </td>
                                        <td id="content_9_right">
                                            <input type="text" class="ip" id="ip9" placeholder="Enter Availibility Address" onfocus="div_col_changer('content_9_right');" onblur="div_col_unchanger('content_9_right');"/>
                                        </td>
                                    </tr>
                                 </table>
                            </div>
                             <div class="content_7">
                                 <p style="text-align: center;font-family: 'Montserrat', sans-serif;color:rgba(0,0,0,0.4);">Upload Photographs</p>
                                 <div class="img" id="img_1" onclick="fileToUpload_clk('img_1');">
                                     <p style="text-align: center; margin-top: 20px;"><img src="../../image/book.png" height="40" width="50"/></p>
                                 </div>
                                 
                                 <div class="img" id="img_2" onclick="fileToUpload_clk('img_2');">
                                     <p style="text-align: center; margin-top: 20px;"><img src="../../image/book.png" height="40" width="50"/></p>
                                 </div>
                                 
                                 <div class="img" id="img_3" onclick="fileToUpload_clk('img_3');">
                                     <p style="text-align: center; margin-top: 20px;"><img src="../../image/book.png" height="40" width="50"/></p>
                                 </div>
                                 
                                 <div class="img" id="img_4" onclick="fileToUpload_clk('img_4');">
                                     <p style="text-align: center; margin-top: 20px;"><img src="../../image/book.png" height="40" width="50"/></p>
                                 </div>
                                 <input type="file" id="fileToUpload" name="file" onchange="file_demo();" style="visibility: hidden;"/>
                                 
                           
                                 
                            </div>
                            <div id="sub_reg" onclick="value_sender();">
                                <p style="font-family: 'Hind', sans-serif;text-align: center;margin-top: 8px;">SUBMIT</p>
                            </div>
                            
                        </div>
                        
                        
                        
                        
                        
                        
                        
                    </div>
                    
                    
                    
    </body>
</html>
