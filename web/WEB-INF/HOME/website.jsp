<%-- 
    Document   : index
    Created on : 17 Mar, 2014, 12:02:18 PM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <link href="../../home/website.css" type="text/css" rel="stylesheet">  
        <script src="../../home/website.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Ragister with multiKBIS to use the feature and share your idea!">
        <link rel="shortcut icon" href="favicon.ico" />
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS Signup</title>
    </head>
    <body onload="text_focus();">
        
        <%
        boolean k=false;
        String spam="",alert="";
        if(request.getAttribute("evaluator").toString().equals("0"))    
        {
        spam=request.getAttribute("spam").toString();
        k=true;
        }
        %>
        <img src="../../image/true2.png" style="visibility: hidden ;position: absolute;">
        <img src="../../image/alert.ico" style="visibility: hidden ;position: absolute;">
        <div id="top">
            <div id="top_container">
                <div id="logo">
                    <b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b>
                </div><!--End of logo-->
             
                   <a href="/">
                 <div style="height: 23px;width: 70px;background-color: #00796B;margin: 5px; float: right;color: white;padding: 2px; border-radius: 1px;border: 1px solid whitesmoke;font-weight: bold;cursor: pointer;"><p style="margin: 0;padding: 0;text-align: center;margin-top: 2px;font-family: 'Hind', sans-serif;font-size: 14px;">Login</p>
            </div>
                 </a>  
            </div>
        </div>
        <div id="container">
           
            <div id="features">
                 <form action="account" id="myform" method="post" > 
                        <ul style="float: right; margin-right: 60px;">
                            <div style=" height: 400px; width: 50px;  float: right">
                                <div class="imgdiv">
                                   
                                </div>
                                <div class="imgdiv">
                                    <img src="../../image/alert.ico" id="first" class="img"/>
                                </div>
                                <div class="imgdiv">
                                    <img src="../../image/alert.ico" id="second" class="img"/>
                                </div>
                                <div class="imgdiv">
                                    <img src="../../image/alert.ico" id="m3" class="img"/>
                                </div>
                                <div id="sixth" class="imgdiv" style="margin-top: 12px;" >
                                    <img src="../../image/alert.ico"  class="img"/>
                                </div>
                             
                            </div></ul>
                    <ul class="info">  
                        <li class="login_li" id="login_header_reg">Register with MultiKBIS</li>
                        <li class="login_li">
                            <input type="text" name="a1" placeholder="Enter Firstname" class="ifieldr" id="name1" onblur="accountvalidator1('name1', 'newspan1','first');"/>
                            <input type="text" name="a2" placeholder="Enter Lastname" class="ifieldr" id="rname"  onblur="accountvalidator2('rname', 'newspan1','first');"/>
                        </li>
                        <li>
                            <span id="newspan1" class="newspan" style="color: red;"></span>
                        </li>                       
                    </ul>
                    <ul class="info">   
                        <li class="login_li">
                            <input type="text" name="a3" placeholder="Enter Email" class="ifieldrl" id="ename" onblur="accountvalidator3('ename', 'newspan2','second');"/>
                            <div class="input12" ></div>
                        </li>
                         <li>
                             <span id="newspan2" class="newspan" style="color: red;"><% if(k){%><%= spam %> <%}%></span>
                        </li>
                    </ul>
                    <ul class="info">
                        <li class="login_li">
                            <input type="text" name="a5" placeholder="Enter Institution" class="ifieldrl" id="iname"  onblur="accountvalidator7('iname', 'newspan4','fourth');"/>                  
                            <div class="input12" id="fourth"></div>
                        </li>
                        <li>
                            <span id="newspan4" class="newspan" style="color: red;"></span>
                        </li>
                    </ul>
                    <ul class="info">
                        <li class="login_li">
                            <input type="password" name="a7" placeholder="Enter Password" class="ifieldr" id="pname"  onblur="accountvalidator5('pname', 'newspan6','sixth');" />
                            <input type="password" name="a8"  placeholder="Re-Enter Password" class="ifieldr" id="rpname"  onblur="accountvalidator6('pname', 'rpname', 'newspan6','sixth');" onkeyup="abc_inputpass('pname', 'rpname','sixth');"/>
                            <div class="input12" id="sixth"></div>
                           
                        </li>
                        <li>
                            <span id="newspan6" class="newspan" style="color: red;"></span>
                        </li>
                    </ul>
                    
                    <ul id="dropdown">
                        <li class="login_li" style="font-family: 'Hind', sans-serif;font-size: 15px;margin-top: 10px;"><p style="margin: 0;padding: 0;margin-top:2px;margin-right: 5px;float: left;">Birthday:</p> 
                            <select name="day" class="down" id="option1">
                                <option>day</option>
                               <% for(int i=1;i<=31;i++){%>
                                <option><%= i %></option>
                                <%}%>      
                            </select>
                            <select name="month" class="down" id="option2">
                                <option>month</option>
                                <option>January</option>
                                <option>February</option>
                                <option>March</option>
                                <option>April</option>
                                <option>May</option>
                                <option>June</option>
                                <option>July</option>
                                <option>August</option>
                                <option>September</option>
                                <option>October</option>
                                <option>November</option>
                                <option>December</option>  
                            </select>
                            <select name="year" class="down" id="option3">
                                <option>year</option>
                                <% for(int j=1960;j<=2000;j++){%>
                                <option><%= j %></option>
                                <%}%>
                            </select>
                        </li>
                    </ul>
                    <ul id="radio">
                        <li class="login_li" >
                            <input type="radio" name="aa" value="female" id="radio1" /> Female  
                            <input type="radio" name="aa" value="male"  id="radio1"/>Male
                        </li>   
                    </ul>
                    <ul>
                        <div id="tc">
                            <p style="margin: 0;padding: 0;"><input type="checkbox" name="check_box" id="check_box"/></p>
                            <p id="tc_para" onclick="window.open('term_condition/term_condition.jsp','_blank');">I accept the term and condition?</p>
                        </div>
                        <li>
                        <div style="height: 130px; width: 430px ;background-color: transparent;float: left;margin-top: 10px;margin-bottom: 15px;">
                            <%
                            ReCaptcha c = ReCaptchaFactory.newReCaptcha(
                                            "6LdlHOsSAAAAAM8ypy8W2KXvgMtY2dFsiQT3HVq-", 
                                            "6LdlHOsSAAAAACe2WYaGCjU2sc95EZqCI9wLcLXY", false);
                            out.print(c.createRecaptchaHtml(null, null));
                            %>
                        </div>
                        </li>
                        <li class="login_li">
                            <div class="sfieldreg" onclick="abcdef();" style="color: white;">Register</div>
                        </li>
                    </ul>
                    <div id="response">
                        <span id="span3"> </span>  
                    </div>
                    <input type="submit" style="visibility: hidden;" id="ragistered_submit">
                </form>
               
             
            </div><!--End of features-->
            
        </div><!--End of container-->
        <div  style="width: 100%; height: 100px; position: absolute; margin-top: 100px; border-color: transparent;">
            <%@include  file="../../group_info/footer.jspf" %>
                     </div>
    </body>
</html>
