<%-- 
    Document   : resume
    Created on : Jan 3, 2015, 7:45:45 AM
    Author     : NABEEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="../../resume/resume.css" type="text/css" rel="stylesheet"/>
        <script src="../../resume/resume.js" type="text/javascript" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
    </head>
    <body onclick="universalhider();">
        <div id="lightbox">
            <div id="changename">
                <table id="nametable">
                    <tr style="padding: 0; height: 10px;">
                        <td style="padding: 0; height: 30px;"></td>
                         
                    </tr>
                     <tr>
                         <td style="padding: 0 0px 0px 10px; ">
                             <input type="text" id='nametext' placeholder="Your new Name:"/>
                         </td>
                         <td id="button">
                             <p style="text-align: center; font-size: 14px;padding: 0;color: white;"> Change</p>
                         </td>
                          
                     
                    </tr>
                    <tr>
                         <td colspan="3"></td>
                         
                    </tr>
                </table>
            </div>
        </div>
        <div style="width: 100%;height: 40px;background-color: black;position: fixed;">
            <div style=" width: 960px;height: 100%; margin: 0 auto;">
               <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
               <a href="GoHome">     <div id="gohome" >
                       <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                           <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />
                       </div>
                       <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 15px; color: white;text-align: center;"> Go Home </p>   </div>
                </div>
           </a>  
            </div>
        </div>
        <div id="container">
            
            <form action="../resume" method="post">
                <div id="personalcreden">
                    <div style="width: 100%;height: 40px;"></div>
                    <div class="myname">
                        <p style="font-size: 15px;margin-left: 40px; font-family: cursive; color: white">Personal Information</p>
                       
                    </div>
                 <!--   <div id="acedmicheader">
                        <p style="text-align: center; font-size: 14px; font-family: sans-serif;"> Personal Credentials:</p>
                    </div>-->
                    <table>
                        <tr>
                           
                            <td>  What is your Full Name:

                            </td>
                            <td>
                                <div style="background-color: transparent;position: absolute;margin-top: 17px;border: 1px solid transparent;" class="pctext"></div>
                                <p><input type="text" id="u_name" name="full_name" class="pctext" style="border-color: transparent;" value="${sessionScope.name}" >
                                </p>
                            </td>
                            <td><p style="font-size: 12px;padding: 0;margin: 0;"><!--edit--></p></td>
                        <tr>
                            <td>Father Name:</td>
                            <td><input type="text" id="f_name" name="father_name" class="pctext"></td></tr><tr>
                        <tr>
                            <td>Date Of Birth</td>
                            <td><input type="text" placeholder="dd/mm/yyyy" id="dob" name="d_o_b"  class="pctext" ></td></tr><tr>
                            <td>Nationality</td>
                            <td><input type="text" id="nat" name="nationality" class="pctext"></td></tr><tr>
                            <td>Languages known</td>
                            <td><input type="text" id="l_know" name="l_known" class="pctext"></td></tr>
                        <tr>
                            <td>Gender</td>
                            <td><p id="ppc">Female <input type="radio" id="male" name="gender" class="pcradio" value="female"/>
                                    Male&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="male" name="gender" class="pcradio" value="male"></p></td>
                        </tr>
                        <tr>
                            <td>Marital status</td>
                            <td><p id="ppc">Single&nbsp;&nbsp; <input type="radio" id="male" name="marital" class="pcradio" value="Single">
                                    Married<input type="radio" id="male" name="marital" class="pcradio" value="Married"></p></td>
                        </tr>
                        <tr><td>Permanent Address</td>
                            <td><textarea id="p_add" name="p_add" class="pctext"></textarea></td></tr>
                        <tr>
                            <td>Email Address</td>
                            <td><input type="text" id="email" name="email" class="pctext"></td></tr>
                        <tr>
                            <td>Mobile Number</td>
                            <td><input type="text" id="mobile" name="mobile" class="pctext"></td></tr>
                        <!--  <tr>
                             <td></td>
                             <td><div id="pcsave"><p style="text-align: center; font-size: 11px;color: white;">Save </p></div></td></tr>
                        -->
                    </table>
                </div>
                                <div id="acedmic" style="border-left: 1px solid black;">

                    <div id="acedmicheader">
                        <p style="font-size: 15px;margin-left: 40px; font-family: cursive; color: white"> Academic Details</p>
                    </div>
                    <table>
                        <tr>
                            <td><a style="font-size: 16px;"><strong>High School</strong></a></td>
                            <td></td>
                            <td></td></tr>
                        <tr> 
                            <td></td><td>Name of School</td>
                            <td>
                                <input type="text" id="h_s_name" name="h_s_name" class="adtext"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Year Of Admission</td>
                            <td>
                                <input type="text" id="h_s_y_o_a" name="h_s_y_o_a" class="adtext" placeholder="yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Year Of Passing</td>
                            <td>
                                <input type="text" id="h_s_y_o_p" name="h_s_y_o_p" class="adtext" placeholder="yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Marks In High School</td>
                            <td>
                                <input type="text" id="mobile" name="h_s_m_g" class="adtextm" placeholder="your gain"/>
                                /  <input type="text" id="mobile" name="h_s_m_t" class="adtextm" placeholder="Out Off"/>
                            </td>


                        </tr>
                        <tr><td colspan="3"><hr /></td></tr>
                        <tr> 
                            <td><a style="font-size: 16px;"><strong>Senior Secondry</strong></a></td><td></td>
                            <td>

                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Name of School</td>
                            <td>
                                <input type="text" id="s_s_name" name="s_s_name" class="adtext"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Year Of Admission</td>
                            <td>
                                <input type="text" id="s_s_y_o_a" name="s_s_y_o_a" class="adtext" placeholder="yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Year Of Passing</td>
                            <td>
                                <input type="text" id="s_s_y_o_p" name="s_s_y_o_p" class="adtext" placeholder="yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Percentage In Senior Secondry</td>
                            <td>
                                <input type="text" id="s_s_m_g" name="s_s_m_g" class="adtextm" placeholder="your gain"/>
                                /  <input type="text" id="s_s_m_t" name="s_s_m_t" class="adtextm" placeholder="Out Off"/>
                            </td>


                        </tr>

                        <tr><td colspan="3"><hr /></td></tr>
                        <tr> 
                            <td><a style="font-size: 16px;"><strong>Graduation Detail</strong></a></td><td></td>
                            <td>

                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Name of Collage</td>
                            <td>
                                <input type="text" id="gr_name" name="gr_name" class="adtext"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Course </td>
                            <td>
                                <select name="choose" class="adtext" id="option2">
                                    <option>Choose</option>
                                    <option>B.Tech</option>
                                    <option>BBA</option>
                                    <option>BCA</option>
                                    <option>Polytechnic</option>

                                </select>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>Branch (If Any) </td>
                            <td>
                                <select name="choosebr" class="adtext" id="option2">
                                    <option>Choose</option>
                                    <option>Computer Science and Engineering</option>
                                    <option>Mechanical Engineering</option>
                                    <option>Information Technology</option>
                                    <option>Civil Engineering</option>
                                    <option>Electrical Engineering</option>
                                    <option>Electronics Engineering</option>
                                    <option>Electrical and Electronics Engineering</option>


                                </select>
                            </td>

                        </tr>
                        <td></td><td colspan="2"><hr /></td>
                        <tr> 
                            <td></td><td>1<sup>st</sup> Year Duration</td>
                            <td>
                                <input type="text" id="gr_1_d" name="gr_1_d" class="adtext" placeholder="yyyy-yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>1<sup>st</sup> Year Marks</td>
                            <td>
                                <input type="text" id="gr_1_m_g" name="gr_1_m_g" class="adtextm" placeholder="your gain"/>
                                /  <input type="text" id="gr_1_m_t" name="gr_1_m_t" class="adtextm" placeholder="Out Off"/>
                            </td>

                        </tr>
                        <tr><td></td><td colspan="2"><hr /></td></tr>
                        <tr> 
                            <td></td><td>2<sup>nd</sup> Year Duration</td>
                            <td>
                                <input type="text" id="gr_2_d" name="gr_2_d" class="adtext" placeholder="yyyy-yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>2<sup>nd</sup> Year Marks</td>
                            <td>
                                <input type="text" id="gr_2_m_g" name="gr_2_m_g" class="adtextm" placeholder="your gain"/>
                                /  <input type="text" id="gr_2_m_t" name="gr_2_m_t" class="adtextm" placeholder="Out Off"/>
                            </td>

                        </tr>
                        <td></td><td colspan="2"><hr /></td>
                        <tr> 
                            <td></td><td>3<sup>rd</sup> Year Duration</td>
                            <td>
                                <input type="text" id="gr_3_d" name="gr_3_d" class="adtext" placeholder="yyyy-yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>3<sup>rd</sup> Year Marks</td>
                            <td>
                                <input type="text" id="gr_3_m_g" name="gr_3_m_g" class="adtextm" placeholder="your gain"/>
                                /  <input type="text" id="gr_3_m_t" name="gr_3_m_t" class="adtextm" placeholder="Out Off"/>
                            </td>

                        </tr>
                        <td></td><td colspan="2"><hr /></td>
                        <tr> 
                            <td></td><td>4<sup>th</sup> Year Duration(if result announced)</td>
                            <td>
                                <input type="text" id="gr_4_d" name="gr_4_d" class="adtext" placeholder="yyyy-yyyy"/>
                            </td>

                        </tr>
                        <tr> 
                            <td></td><td>4<sup>th</sup> Year Marks(if result announced)</td>
                            <td>
                                <input type="text" id="gr_4_m_g" name="gr_4_m_g" class="adtextm" placeholder="your gain"/>
                                /  <input type="text" id="gr_4_m_t" name="gr_4_m_t" class="adtextm" placeholder="Out Off"/>
                            </td>

                        </tr>
                        <td></td><td colspan="2"><hr /></td>
                        <!--<tr>
                              <td></td> <td></td>
                              <td><div id="pcsave"><p style="text-align: center; font-size: 11px;color: white;">Save </p></div></td></tr>
                        -->
                    </table>
                </div>
                <div id="mejorproject">
                    <div id="acedmicheader">
                        <p style="font-size: 15px;margin-left: 40px; font-family: cursive; color: white"> Major Project</p>
                    </div>
                    <table>
                        <tr>
                            <td>Title Of Project</td>
                            <td><input type="text" id="t_project" name="t_project" class="pctext"></td>
                        </tr>
                        <tr>
                            <td>Technologies Used In Project </td>
                            <td><input type="text" id="tech_project" name="tech_project" class="pctext" placeholder="abc,xyz,uvw,.."></td>
                        </tr>
                        <tr>
                            <td>Description About Project </td>
                            <td><textarea class="pctext" id="proja" name="d_project"></textarea></td>
                        </tr>
                        <tr>
                            <td>Team Size (Person involve in that project)</td>
                            <td><input type="text" id="team_project" name="team_project" class="pctext" placeholder="abc,xyz,uvw,.."></td>
                        </tr>
                        <tr>
                            <td>Your Roll In The Project</td>
                            <td><input type="text" id="roll_project" name="roll_project" class="pctext"></td>
                        </tr>
                        <!--
                         <tr>
                            <td></td>
                            <td><div id="pcsave"><p style="text-align: center; font-size: 11px;color: white;">Save </p></div></td></tr>
                        -->
                    </table>

                </div>
                <div id="summertr">
                    <div id="acedmicheader">
                        <p style="font-size: 15px;margin-left: 40px; font-family: cursive; color: white;">Summer Training</p>
                    </div>
                    <table>

                        <tr>
                            <td>
                                Industry
                            </td>
                            <td>
                                <input type="text" id="trainning_ind" name="trainning_ind" class="pctext" placeholder="Nmae of Industry"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Training  On Project or Technology
                            </td>
                            <td>
                                <input type="text" id="trainning_on" name="trainning_on" class="pctext" placeholder="Name of Project or Technogogy on work upon"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Duration
                            </td>
                            <td>
                                <input type="text" id="trainning" name="trainning_d" class="pctext" placeholder="Like 6 month or 1 year etc"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                From Date
                            </td>
                            <td>
                                <input type="text" id="trainning_from" name="trainning_from" class="pctext" placeholder="dd/mm/yyyy"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                To Date
                            </td>
                            <td>
                                <input type="text" id="trainning_to" name="trainning_to" class="pctext" placeholder="dd/mm/yyyy"/>
                            </td>
                        </tr>
                        <!--   <tr>
                              <td></td>
                              <td><div id="pcsave"><p style="text-align: center; font-size: 11px;color: white;">Save </p></div></td></tr>
                        -->
                    </table>
                    <div id="computerskill">
                        <div id="acedmicheader">
                            <p style="font-size: 15px;margin-left: 40px; font-family: cursive; color: white">Computer Skills(Optional)</p>
                        </div>
                        <table>
                            <tr>
                                <td>Operating System Known</td>
                                <td>
                                   <div id="divos" class="pctext" style="border: 1px solid rgba(0,0,0,.4);" onclick="visible('n1')"> </div>
                                   <input type="hidden" id="c_skill_os" name="c_skill_os" class="pctext"  onclick="visible('n1')" onkeypress=" return false;"/>
                                    <div id="n1"  >
                                        <input type="checkbox" onclick="selecterOS('1');" class="cb"/> Windows <br />
                                        <input type="checkbox" onclick="selecterOS('2');" class="cb"/> Linux <br />
                                        <input type="checkbox" onclick="selecterOS('3');" class="cb"/> Mac  <br /> 
                                        <input type="checkbox" class="cb"/> Windows <br />
                                          
                                    </div>
                                    <!--<input type="text" id="c_skill_os" name="c_skill_os" class="pctext" placeholder="e.i Windows,Linux,Mac etc"/>
                                    -->
                                    </td>
                            </tr>
                            <tr>
                                <td>Programming Languages Known</td>
                                <td> <div id="divpr" class="pctext" style="border: 1px solid rgba(0,0,0,.4);" onclick="visible('n2')"> </div>
                                    <input type="hidden" id="c_skill_pr" name="c_skill_pr" onclick="visible('n2')" class="pctext"/>
                                    <div id="n2" onclick="visiblehelper('n2');" >
                                        <input type="checkbox" onclick="selecterPR('1');" class="cb"/> JAVA <br />
                                        <input type="checkbox" onclick="selecterPR('2');" class="cb"/> J2EE <br />
                                        <input type="checkbox" onclick="selecterPR('3');" class="cb"/> C <br /> 
                                        <input type="checkbox" onclick="selecterPR('4');" class="cb"/> C++ <br />
                                        <input type="checkbox" onclick="selecterPR('5');" class="cb"/>.NET <br /> 
                                        <input type="checkbox" onclick="selecterPR('6');" class="cb"/>php <br />
                                        <input type="checkbox" onclick="selecterPR('7');" class="cb"/> SQL <br /> 
                                        <input type="checkbox" onclick="selecterPR('8');" class="cb"/> Jquery<br /> 
                                        <input type="checkbox" onclick="selecterPR('9');" class="cb"/>CSS <br />
                                        <input type="checkbox" onclick="selecterPR('10');" class="cb"/> JavaScript <br /> 
                                    
                                          
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>IDE Known</td>
                                <td><input type="text" id="c_skill_ide" name="c_skill_ide" class="pctext" placeholder="e.i Eclipse,NetBeans etc"/></td>
                            </tr>
                            <tr>
                                <td>Database Known</td>
                                <td><input type="text" id="c_skill_db" name="c_skill_db" class="pctext" placeholder="e.i oracle,MySql etc"/></td>
                            </tr>
                            <tr><tr>
                                <td colspan="2"><hr /></td></tr>
                            <td colspan="2">
                                <div id="submit" onclick="clickr('submitme')"><p style="text-align: center; font-size: 16px;" >Save And Create PDF </p></div>
                            </td>

                            </tr>
                        </table> 
                    </div>
                </div>
                <input type="submit" id="submitme" style="visibility: hidden;"/>
            </form>
        </div>
    </body>
</html>
