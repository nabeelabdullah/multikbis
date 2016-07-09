<%-- 
    Document   : myprofile
    Created on : Jul 21, 2014, 2:04:18 PM
    Author     : nabeel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <link href="userprofile/userprofile.css" type="text/css" rel="stylesheet">
        <script src="userprofile/userprofile.js" type="text/javascript" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body>
    
    <img src="../../img/aj1.gif" style="visibility: hidden;position: absolute;"/>
    <div id="header">
        <div id="subheader">
            <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px; background-color: black;border-radius: 45px; float: left;margin-right: 20px;"/>  
            <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
             <a href="GoHome"> 
                       <div id="gohome">
                       <!--<div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                        <!--   <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                       </div>-->
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: 'Hind', sans-serif;font-size: 12px; color: white;text-align: center;"> Go Home </p>   </div>
                       </div>
            </a>  
            </div>
    </div>
<div
    <div id="container">

<div id="main">    
 <table style="width:700px;margin: 10px auto;margin-left: 150px;">
      <tr>
          <td style="margin-bottom: 10px;">
               <div id="photodiv">
                    <img src="imagepass?path=${hash['00']}" id="divimg">

                </div></td>
                <td>
                <div id="changimgdiv" >

                <div id="changeheader">
                    <a id="cppa"> Change your profile pics</a>
                </div>
                <div id="changemiddle">
                    <div id="changename">

                        <div id="fileName">

                        </div>
                        <div id="changenameholder" onclick="file_uploader_click('fileToUpload');">&nbsp;&nbsp;&nbsp;&nbsp;Browse Image </div>
                    </div>
                    <div id="asker"> <a id="askrp" onclick="fileSelected();">Upload</a></div>
                    <div id="uploadbarcontainer">
                        <div id="uploading"></div>
                        <div id="file_uploader_bar">
                            <input type="file" name="fileToUpload" id="fileToUpload" onchange="name_giver();"/>


                            <div id="progressNumber"></div>

                            <div id="progress_bar">
                                <div id="progress_bar_inner"></div>
                            </div><!--progress_bar-->


                        </div><!--end of file_uploader_bar-->
                    </div>
                </div>


            </div>
                </td></tr>
                        <tr>
                            <td style="width: 350px;">FULL NAME</td>
                            <td style="text-transform: capitalize;">${hash['01']}</td>
                        </tr>
                         <tr>
                            <td style="width: 350px;">SCHOOLING FROM</td>
                            <td>${hash['02']}</td>
                        </tr>
                         <tr>
                            <td>SECONDERY FROM</td>
                            <td style="text-transform: capitalize;">${hash['03']}</td>
                        </tr>
                         <tr>
                            <td>CONTACT(email/mobile.no)</td>
                            <td>${hash['04']}</td>
                        </tr>
                         <tr>
                            <td>STATUS</td>
                            <td style="text-transform: capitalize;">${hash['05']}</td>
                        </tr>
                        <tr>
                            <td>AREA OF INTEREST(subject)</td>
                              <td style="text-transform: capitalize;">${hash['06']}</td>
                        </tr>
                         <tr>
                            <td>COLLAGE</td>
                              <td style="text-transform: capitalize;">${hash['07']}</td>
                        </tr>
                         <tr>
                            <td>LIVE IN</td>
                              <td style="text-transform: capitalize;">${hash['08']}</td>
                        </tr>
                         <tr>
                            <td>FOUND OFF</td>
                              <td style="text-transform: capitalize;">${hash['09']}</td>
                        </tr>
                         <tr>
                            <td>COURSE</td>
                              <td style="text-transform: capitalize;">${hash['10']}</td>
                        </tr>
                         <tr>
                            <td>BRANCH</td>
                              <td style="text-transform: capitalize;">${hash['11']}</td>
                        </tr>
                               
                    </table>
   
 </div>
    </div>

</body>
</html>     
                
                
                  
                




                    
               
            

       