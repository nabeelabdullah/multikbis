<%-- 
    Document   : profile
    Created on : Jul 22, 2014, 9:43:36 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <link href="profile/profile.css" type="text/css" rel="stylesheet"/>
        <script src="profile/profile.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body>




        <div id="container">
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
            <div id="main">
<p style="text-align: center;font-size:18px;color: rgba(0,0,0,0.4);margin-top: 15px;"> User Profile</p>
                <form action="createprofile1" method="post">
                    
                    <table style="width:700px;margin: 0;padding: 0; margin: 0 auto;">
                        

                        <tr>
                            <td>SCHOOLING FROM</td>
                            <td>
                                <input type="hidden" value="${hash['02']}" id="h1" />
                                <input type="text"   value="${hash['02']}" name="sch_from" id="txt1" class="etxt" disabled />
                            </td>
                            <td style="width: 20px;">
                                <a class="refc"  onclick="make_enable('txt1');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt1', 'h1');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>SECONDERY FROM</td>
                            <td><input type="hidden" value="${hash['03']}" id="h2"/>
                                <input type="text" value="${hash['03']}" name="sec_from" id="txt2" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt2');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt2', 'h2');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>CONTACT(Email/Mobile No.)</td>
                            <td><input type="hidden"  value="${hash['04']}" id="h3"/>
                                <input type="text" value="${hash['04']}" name="contact" id="txt3" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt3');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt3', 'h3');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>STATUS</td>
                            <td> <input type="hidden" value="${hash['05']}" id="h4"/>
                                <input type="text" value="${hash['05']}" name="status" id="txt4" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt4');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt4', 'h4');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>AREA OF INTEREST(subject)</td>
                            <td><input type="hidden" value="${hash['06']}"  id="h5"/>
                                <input type="text" value="${hash['06']}" name="a_o_e" id="txt5" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt5');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt5', 'h5');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>COLLAGE</td>
                            <td>  <input type="hidden" value="${hash['07']}" id="h6"/>
                                <input type="text" value="${hash['07']}" name="collage" id="txt6" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt6');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt6', 'h6');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>LIVE IN</td>
                            <td><input type="hidden" value="${hash['08']}" id="h7"/>
                                <input type="text" value="${hash['08']}" name="live_in" id="txt7" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt7');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt7', 'h7');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>FOUND OFF</td>
                            <td> <input type="hidden" value="${hash['09']}" id="h8"/>
                                <input type="text" value="${hash['09']}" name="found_off" id="txt8" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt8')">Edit</a>
                                <a class="refc" onclick="make_referesh('txt8', 'h8');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>COURSE</td>
                            <td><input type="hidden" value="${hash['10']}" id="h9"/>
                                <input type="text" value="${hash['10']}" name="course" id="txt9" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt9')">Edit</a>
                                <a class="refc" onclick="make_referesh('txt9', 'h9');">Refresh</a>
                            </td>
                        </tr>
                        <tr>
                            <td>BRANCH</td>
                            <td><input type="hidden" value="${hash['11']}" id="h10"/>
                                <input type="text" value="${hash['11']}" name="branch" id="txt10" class="etxt" disabled/></td>
                            <td>
                                <a class="refc"  onclick="make_enable('txt10');">Edit</a>
                                <a class="refc" onclick="make_referesh('txt10', 'h10');">Refresh</a>
                            </td>
                        </tr>
                        <tr><td></td>
                            <td></td>
                            <td>
                                <div id="submitit" onclick="clickr('submiti');">
                                    <p id="suba">SUBMIT</p>
                                    <input type="submit" id="submiti">
                                </div>      

                            </td></tr>
                    </table>



            </div>
        </form>

    </div>
  
</body>
</html>
