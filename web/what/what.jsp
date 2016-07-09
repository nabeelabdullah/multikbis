<%-- 
    Document   : what
    Created on : Nov 11, 2014, 8:01:05 PM
    Author     : NABEEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
        <link href="what.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
        <script>
           function scroller()
{
   
    if(window.scrollY<=60){
     document.getElementById('subheader1').style.visibility="hidden";}
 else
      document.getElementById('subheader1').style.visibility="visible";
}
        </script>
    </head>
    <body >
        <div style="width: 100%;height: 40px;;background-color: black;position: fixed;" id="subheader1" >
            <div style="width: 912px;height: 100%; margin: 0 auto;border: 1px solid transparent;">
                <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
            </div>
                 
        </div>
        <div id="container">
            <div style="width: 100%;height: 40px"></div>
           
            <ul>
                <li><span class="m1">Multi</span>purpose <span class="m1">K</span>nowledge <span class="m1">B</span>ased <span class="m1">I</span>nformation <span class="m1">S</span>haring is an online solution to facilitate it's user to provide a plateform to
               share their ideas and informations.It has four main modules</li>
           <li> <p><img src="../img/pointing.jpg" style="height: 20px;width: 30px;">&nbsp;Module 1:</p> <span>It is an social network module where user can make friend ,chat with them and send file to each other.User can send member request to Pre defined group and join on the basis of 50% criteria.
               Member of the group can send file to the email to all member of that particuler group and SMS to the phone of all member of that group.A member of the group can answer 
               of the question asked by any one.Any person can ask question to any of the group but only that person answer them who is the member of that paricular group
               .User can change his profile as well as his profile picture which will public for every one.
               </span></li>
               <li><span style="color:blue;">What is 50% criteria?</span><span> Any person is free to send member request to any group.This request will be broadcast to all of it's member.
                   and if 50% member of the group accept him as a member then only he/she will become the member of that group.This is the responsibility of the member of 
                   the group that they reject the request or accept it.
                   </span></li>
                   <li><p><img src="../img/pointing.jpg" style="height: 20px;width: 30px;">&nbsp;Module 2:<p></li>
                   <li>The second and greatest module of the project is <strong>Share Ideas</strong> module . In this module we provide a platform where user can share its
                   thought , knowledge and experience to every one .they can write on any topic related to there knowledge and can also attach a file 
                   related to that topic .It will be public for every one , and any of the member can see your view and can like and comment on them.Rather than this user can also like the comment of each other
                  as well as he/she can download the attached file. A user can like  any post only at once.The writer can update his post and also be able to delete them.
                 
                   </li>
                   <li><p> <img src="../img/pointing.jpg" style="height: 20px;width: 30px;">&nbsp;&nbsp;Module 3:</p></li>
                   <li>3rd module is very useful for every student it is online old book selling module .In this module you can 
                   post a free add of your book with photograph of book and can sell your book in reasonable price .you can search the book related to you
                   need .I provide four searching option
                   <li> <img src="../img/bullet.png" style="width: 10px;height: 10px;">&nbsp;&nbsp;Search with  book name ,</li>
                   <li> <img src="../img/bullet.png" style="width: 10px;height: 10px;">&nbsp;&nbsp;Search with Department name,
                     
                   </li>
                   <li><img src="../img/bullet.png" style="width: 10px;height: 10px;">  &nbsp;Search with Author name.</li>
                   <li>All searching is very fast and effective</li>
                   <li> . </li>
                   
                   <li><p> <img src="../img/pointing.jpg" style="height: 20px;width: 30px;">&nbsp;&nbsp;Module 4:</p></li>
                   <li>
                       The fourth modules is very useful for freshers to create their resume ,In this module any student can create
                       his/her resume by filling a form related to the information necessary for the the creation of resume .we provide a PDF file for
                       of it.</li>
                   
            </ul>
            
        </div>
        
        <div id="footer">
            <div style="width: 1000px; margin: 0 auto">  <hr/></div>
            <%@include file="../group_info/footer.jspf" %> 
            </div>
    </body>
</html>
