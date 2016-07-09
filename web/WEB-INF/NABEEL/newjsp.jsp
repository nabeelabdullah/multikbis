<%-- 
    Document   : mainpage
    Created on : Nov 5, 2014, 3:13:46 PM
    Author     : NABEEL
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="newjs/newcss.css" type="text/css" rel="stylesheet"/>
        <link href="../group_info/plzlogin.css" type="text/css" rel="stylesheet"/>
        <script src="../../newjs/newjs.js" type="text/javascript"></script>
        <script src="../../newjs/jquery-1.10.2.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='http://fonts.googleapis.com/css?family=Montserrat|Hind' rel='stylesheet' type='text/css'>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
        
    </head>
    <body onclick="tempsc()" onload="loadert();">
    <!--   <div id="templogout" style="visibility: hidden;position: absolute;width: 100%;height: 100%;background-color: rgba(255,255,255,.9); z-index: 50;">
            <div id="fcontainer">
            <div id="uppermain">
                <p id="upperspan">You are logout plz login to continue</p>
            </div>
               
            <div id="middlemain">
                
                <div style="width: 100px;height: 150px; float: left;">
                   
                    <img src="imagepass?path=${userimg}" style="width: 100%;height: 100%;"/>
                </div>
                <div style="width: 340px;height: 200px;float: left;"> <ul id="u1">
                        <li> <p id="namep">${name}</p></li>
                    <li>  
                       <input type="hidden" name="username" value="nabeelabdullah.11@gmail.com"/>
                       <input type="password" id="temppass" name="password" placeholder="Enter Your Password:" class="inputclass"/>
                       <input type="hidden" style="position: absolute;" name="bh" value="${bh}" id="bh"/>
                       <input type="hidden" style="position: absolute;" name="bw" value="${bw}" id="bw"/>
                    </li>
                  
                </ul>
                    <div id="forsubmit" onclick="templogin();">
                        <p style="color: white;text-align: center;font-size: 11px;">Login</p>
                    </div>
                </div>
              
                   
            
            </div>
                    <input type="submit" id="submitit" style="visibility: hidden;">
           
                    <div id="lowermain" >
                        <a href="home_dispacher">  <p id="nin">I Don't want to login again</p></a>
                    </div>
            
        </div>
        </div>-->
        <div id="supportheader"></div>

        <div id="tpdiv">
            <div id="insidetpdiv">
                <div id="upperinside"> 
                    <p id="top" style="font-family: 'Hind', sans-serif; font-size: 13px;"> To:  <span id="namespan"></span></p>
                    <div id="closed" onclick="closer('tpdiv');">
                        <img src="../../img/close.ico" style="width: 100%;height: 100%;">
                    </div>
                </div>
                <div id="middleSinside">
                    <div class="sendfileclass" id="sub">
                        <div id="cont"><p id="contp">Subject:</p></div>
                        <input type="text" id="textd" />
                    </div>
                    <div class="sendfileclass" id="brows" onclick="file_uploader_click('fileToUpload');">
                        <div id="cont1"><p id="contp1"> Browse:</p></div>
                        <div id="filename"> <p id="filenamep"></p></div>
                        <input type="file" style="visibility: hidden; position: absolute;" id="fileToUpload" onchange="name_giver();"/>
                    </div>
                    <p id="sp">  <span id="ss"></span><span id="showpercent"></span></p>   <img src="../../img/waitingfile.gif" id="imgg"/>
                    <div id="submitbutton" onclick="fileSelected();"><p style="font-size: 17px;  margin-top: 5px;color: black;border: none;text-align: center;">Send</p></div>       
                </div>

                <div id="lowerrinside"></div>
            </div>
        </div>

        <img src="../../img/aj1.gif" style="position: absolute;visibility: hidden"/>
        <img src="../../img/search_loader.gif" style="position: absolute;visibility: hidden"/>
        <img src="../../img/done.jpg" style="position: absolute;visibility: hidden"/>

        <div id="container" style="height:${sessionScope.bh}px;">
            <div id="mainheader">       
                <div id="header">
                    <div id="header1">
                        <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px;border-radius: 45px; float: left;margin-left: 30px;"/>  
                         <div id="why"><b style="font-family: cursive;color: #16c2f6; text-align: center;"><span style="font-family: sans-serif; font-size: 13px;">Multi</span>KBIS</b></div>
                      
                    </div>
                    <div id="header2">
                        
                    </div>
                    <div id="header3">
                         <a href="JavaScript:createprofile();">
                            <div id="username" >
                                <p id="username_sp" >${sessionScope.name}<p>
                                    
                            </div>
                        </a>
                    </div>
                    <div id="header4">
                        <div style="width: 100%;background-color: rgba(0,0,0,0); height: 37px;  padding: 0;">
                            <a href="PostDisplay">   <div class="postbook" style=" float: left; border-left: 1px solid  transparent/*gray*/;">
                                  
                                    <div style="width: 35px; height: 100%; float: left;">
                                        <img src="../../img/actIcon-ShareWhite.png" style="width: 25px;height: 25px; margin-top: 6px;margin-left: 5px;" />
                                        </div>
                                        <div style="float: left; height: 40px;width:79px; ">
                                        <p  style="text-align: center; font-size: 13px;font-family: 'Montserrat', sans-serif; "> Share Ideas </p>
                                    </div>
                                    
                                </div></a>
                            <a href="BookDisplay">      <div class="postbook" style=" float: right;  border-left: 1px solid  transparent/*gray*/; border-right: 1px solid  transparent/*gray*/;">
                                    
                                    <div style="width: 35px; height: 100%; float: left;">
                                        <img src="../../img/imagess.png" style="width: 25px;height: 25px; margin-top: 6px;margin-left: 5px;" />
                                        </div>
                                        <div style="float: left; height: 40px;width:79px; ">
                                         <p  style="text-align: center; font-size: 13px;font-family: 'Montserrat', sans-serif; ">Book Shop</p>
                                    </div>
                                   
                                </div></a>
                                <a href="preresume">   <div class="postbook" style=" float: left;  border-left: 1px solid  transparent/*gray*/;">
                                        <div style="width: 40px; height: 100%; float: left;margin-left: 10px;">
                                            <img src="../../img/b90424fd.resume-icon.png" style="width: 25px;height: 25px; margin-top: 6px;margin-left: 5px;" />
                                        </div>
                                        <div style="float: left; height: 40px;width:49px;  ">
                                        <p style="text-align: center; font-size: 13px;font-family: 'Montserrat', sans-serif; margin-bottom: 7px;">Resume</p>
                                    </div>
                                        </div></a>
                           


                        </div>
                    </div>
                    <div id="header5">

                        <div id="setting">
                            <div id="groupn" class="n" onclick="makevisible1('mygr', 'con_mygr');">
                                <img src="../../img/g.png" id="groupimg" style="position: absolute;"/>   
                                <div style="position: absolute; width: 20px;height: 20px;;margin-top: 0;">
                                    <div id="grreq" style="visibility: hidden;width: auto ;height: 13px; background-color: red;float: right;margin-top: 5px;padding: 2px 2px;font-size: 12px;;color: white;font-family: 'Hind', sans-serif;">
                                        2
                                    </div>
                                </div>
                            </div><!--end of groupn-->
                            <div id="friendn" class="n" onclick="makevisible1('myfr', 'con_myfr');" >
                                <div style="position: absolute;width: 20px;height: 20px;"> <img src="../../img/f.png" id="friendimg" /></div> 
                                 <div style="position: absolute; width: 20px;height: 20px;;margin-top: 0;">
                                    <div id="frreq" style="width: auto ;height: 13px; visibility: hidden;background-color: red;float: right;margin-top: 5px;padding: 2px 2px;font-size: 12px;;color: white;font-family: 'Hind', sans-serif;">
                                        2
                                    </div>
                                </div>
                            </div><!--end of friendn-->

                            <div id="sett" class="n" onclick="tempo();" >
                                <img src="img/n.png" id="settimg"/>
                            </div><!--end of set-->

                            <div id="notificationn" class="n" onclick="fortemp('setinside', 'cutter');">   
                                <img src="img/s.png" id="notiimg"/> 
                            </div><!--end of groupn-->
                            <div id="cutter">
                                <!--<img src="img/pointer.png" id="pointerimg"/>-->
                            </div>



                        </div><!--end of setting-->
                    </div>
                    <div id="header6">
                        <div id="search">
                           <!--<div id="searchbutton" onclick="makevisible1('newfr', 'con_newfr1');">
                            <img src="../../image/search.ico" height="25" width="25" style="margin-left: 10px;"/>
                            </div>-->
                            <input type="text" id="searchtext" placeholder="Search People on MultiKBIS" onfocus="reseter('2');"/>

                        </div><!--end of search-->
                    </div>
                </div>
            </div>
            <div id="setinside" class="alhider">
                <div  class="setclass" onclick="templogout()">
                    <p class="setp" > <a href="/setting.jsp">setting</a></p>
                </div>
                <div  class="setclass">
                    <p class="setp">account</p>
                </div>
                <div  class="setclass" id="itislast" onclick="openprofiletab();">
                    <p class="setp">profile</p>
                </div>
                <div  class="setclass" onclick="ogoffline();">
                    <p class="setp">logout</p>
                </div> 
            </div>
            <div id="newfr"  class="alhider" onclick="z_index_mg('newfr', 'myfr');" onscroll="f_scroll_caller();">

                <div style="width: 400px;height: 20px ;background-color: black; position: fixed; "> <div style="width: 20px;height: 20px;">  <img  src="../../img/close.ico" class="closec" onclick="makehidden1('newfr', 'con_newfr1');" style="height: 100%;width: 100%;"/></div></div>

                <div id="con_newfr1" class="newmy">

                </div>
            </div>
            <div id="myfr" class="alhider" onclick="z_index_mg('myfr', 'newfr');" >
                <div style="width: 400px;height: 20px ; box-shadow: 0 0 3px green;background-color:black; position: fixed; "> 
                    <div style="width: 20px;height: 20px;">  <img  src="../../img/close.ico" class="closec" onclick="makehidden1('myfr', 'con_myfr');" style="height: 100%;width: 100%;"/></div></div>


                <div id="con_myfr" class="newmy">

                </div>

            </div><!--end of myfr-->

            <div id="mygr" class="alhider" onclick="z_index_mg('myfr', 'newfr');">

                <div style="height: 20px;width: 100px; position: fixed; border: 1px solid transparent;">
                    <div style="width: 395px;height: 20px ;background-color: black; position: fixed; "> <div  style="width: 20px;height: 20px;" >  <img  src="../../img/close.ico" class="closec" onclick="makehidden1('mygr', 'con_mygr');" style="height: 100%;width: 100%;"/></div></div>

                </div>

                <div id="con_mygr" class="newmy" style="margin-top: 20px;">

                </div>

            </div><!--end of myfr-->
            <div id="middle" >
                <div id="leftmidddle" class="lms">
                    <div id="searchfriend" class="searchgf">
                        <input type="text" id="searchfriendinput" class="sfi" placeholder="Search Your Friends..." onfocus="reseter('3');"/>
                        <div id="searchfrienddiv" class="sfd" onclick="searchfriend();">
                            <img src="img/search.png" class="searchimg"/>
                        </div>
                    </div>

                    <div id="openchat1">

                        <div id="pendingchat">
                            <div class="friendpendind" id="id1"  onclick="maximize();" onmouseover="valuechanger('10');"><!--1-->
                                <div class="clsp">    <span  id="sp1"></span></div>
                                <div class="maxdiv"  onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>
                            <div class="friendpendind" id="id2" onmouseover="valuechanger('9');"><!--2-->
                                <!--span class="clsp" id="sp2"></span-->
                                <div class="clsp">    <span  id="sp2"></span></div>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();"  >
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>
                            <div class="friendpendind" id="id3" onmouseover="valuechanger('8');"><!--3-->
                                <span class="clsp" id="sp3"></span>
                                <div class="maxdiv" onclick="maximize();" >

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>
                            <div class="friendpendind" id="id4" onmouseover="valuechanger('7');"><!--4-->
                                <span class="clsp" id="sp4"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>


                            <div class="friendpendind" id="id5" onmouseover="valuechanger('6');"><!--5-->
                                <span class="clsp" id="sp5"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>
                            <div class="friendpendind" id="id6" onmouseover="valuechanger('5');"> <!--6-->
                                <span class="clsp" id="sp6"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>

                            <div class="friendpendind" id="id7" onmouseover="valuechanger('4');"><!--7-->
                                <span class="clsp" id="sp7"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>

                            <div class="friendpendind" id="id8" onmouseover="valuechanger('3');"><!--8-->
                                <span class="clsp" id="sp8"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>

                            <div class="friendpendind" id="id9" onmouseover="valuechanger('2');"><!--9-->
                                <span class="clsp" id="sp9"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>

                            <div class="friendpendind" id="id10" onmouseover="valuechanger('1');"><!--10-->
                                <span class="clsp" id="sp10"></span>
                                <div class="maxdiv" onclick="maximize();">

                                </div>
                                <div class="cutdiv" onclick="cut_chat();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>
                            </div>

                        </div>

                        <div id="startchat" >   
                            <div id="chatheader" onclick="received_chat();" >
                                
                                <div class="clspp"><span  id="chatsp"></span></div>
                                <div id="mindiv" onclick="minimize();">

                                </div>
                                <div class="cutdiv" onclick="setter();">
                                    <img src="../../img/close.ico" class="cutimg"> 
                                </div>

                            </div>
                            <div id="chatmiddle">
                                 
                                 
                    
                            </div>

                            <div id="chatfooter" >

                                <input type="text" id="sendchattext" placeholder="write you text and press Enter" onfocus="reseter('1');"/>
                             

                            </div>

                        </div>             <!-- start openchat -->


                    </div>
                </div>
                <div id="centermidddle" class="lms">

                    <div id="main" class="lms">

                        <div id="left" onscroll="scrollercaller();" onmouseover="scrollerviewer('left');" onmouseout="scrollhider('left');" class="leftright" >

                            <c:forEach var="x" items="${hash}">
            <div class="flist"> 
                <div class="flistheader"> 
                    <div id="onoff"> 
                        <div id="rgdiv"> 
                            <img src="img/green.png" class="rgimg" id="${x.value['1']}"/> 
                        </div> 
                        <span id="sss"> </span>
                    </div>  
                </div> 
                <div class="flistmiddle"> 
                    <div class="fphoto">

                        <img src='imagepass?path=${x.value['2']}' id="gimg"/> 
                    </div> 

                    <div class="fattri"> 

                        <ul class="ful" > 
                            <a  href="profilehandler?user_id=${x.value['2']}">  
                                <li class="fname" style="font-family: 'Montserrat', sans-serif; font-size: 16px;margin-bottom: 5px;"> 
                                 ${x.value['3']}

                                </li> 
                            </a>
                            <li class="fname" style="font-family: 'Hind',sans-serif;"> 
                                     <a onclick="window.open('http://www.integraluniversity.ac.in/','_blank');">Integral University,Lucknow</a>
                            </li> 
                        </ul> 

                    </div> 

                </div> 
                <div class="flistfooter" > 
                    <div class="fbutton" onclick="open1('${x.value['2']}', '${x.value['3']}');">
                        <img src="img/chatting.png" class="cimg"/> 
                        <p class="cvp" id="chatting" > Chating </p> 
                    </div> 
                    <div  class="fbutton" onclick="filesender('${x.value['2']}', '${x.value['3']}', 'f');"> 
                        <img src="img/file.png" class="gsfimf"/> 
                        <p class="gsfpara">sendFILE</p> 
                    </div> 

                </div> 
                <!--div class="flistdivider"> 
                </div--> 
            </div><!--end of flist-->
        </c:forEach>



                        </div><!--end of left-->



                        <div id="right" class="leftright" onmouseover="scrollerviewer('right');" onmouseout="scrollhider('right');">

                            <c:forEach var="x" items="${hashgroup}">
                                <div class="glist">
                                    <div class="glistheader">
                                    </div> 
                                    <a href="searchgroup.jsp"></a>
                                    <div class="glistmiddle">
                                        <div class="gphoto">
                                            <img src="img/kitten1.jpg" id="gimg"/>              
                                        </div> 
                                        <div class="gattri"> 

                                            <ul class="gul"> 
                                                <li class="fname" style="font-family: 'Montserrat', sans-serif; font-size: 16px; margin-bottom: 5px;"> 
                                                    ${x.value['name']}
                                                </li> 
                                                <li class="fname" style="font-family: 'Hind',sans-serif;"> 
                                                   <a onclick="window.open('http://www.integraluniversity.ac.in/','_blank');">Integral University,Lucknow</a>
                                                </li> 
                                            </ul> 
                                        </div> 
                                    </div> 
                                    <div class="glistfooter" > 
                                        <c:choose>
                                            <c:when test="${x.value['condition']=='true'}">

                                                <div  class="gbutton" onclick=" questiontab('${x.value['g_id']}');"> 
                                                    <img src="../../img/question.png" class="gsfimf"/> 
                                                    <p class="gsfpara">Questions</p> 
                                                </div> 
                                                <!--<div  class="gbutton"> 
                                                    <img src="img/sms.png" class="gsfimf"/> 
                                                    <p class="gsfpara">&nbsp;sendSMS</p> 
                                                </div> -->                            
                                                <div  class="gbutton" onclick="filesender('${x.value['g_id']}', '${x.value['name']}', 'g')"> 
                                                    <img src="img/file.png" class="gsfimf"/> 
                                                    <p class="gsfpara">sendFILE</p> 
                                                </div> 
                                            </c:when>
                                            <c:otherwise>
                                                <div  class="gbutton" onclick="questiontab('${x.value['g_id']}');"> 
                                                    <img src="../../img/question.png" class="gsfimf"/> 
                                                    <p class="gsfpara">QUESTION</p> 
                                                </div> 
                                                <div class="gbuttonc" id="${x.value['this_id']}">  <div class="gbuttonic"    onclick="grouprequest_sender('${x.value['g_id']}', '${x.value['this_id']}');"> 
                                                        <img src="../../img/sr.png" class="gsfimf"/> 
                                                        <p class="gsfpara">&nbsp;Send Request&nbsp;</p> 
                                                    </div>   </div>                         

                                            </c:otherwise>
                                        </c:choose>

                                    </div > 
                                    <div class="glistdivider"> 
                                    </div> 
                                </div><!--end of glist-->
                            </c:forEach>



                        </div><!--end of right-->

                    </div><!--end of main-->

                </div>
                <div id="rightmidddle" class="lms">
                    <div id="searchgroup" class="searchgf">
                        <input type="text" id="searchgroupinput" class="sfi" placeholder="Search your groups...." onfocus="reseter('4');"/>
                        <div id="searchgroupdiv" class="sfd">
                            <img src="img/search.png" class="searchimg"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
