<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link href="../../resume/newresume.css" rel="stylesheet" type="text/css"/>
        <script src="../../resume/resume.js" type="text/javascript" ></script>
        <script src="../../resume/ckeditor/ckeditor.js" type="text/javascript"></script>
        <LINK REL="SHORTCUT ICON" href="../../image/logo.jpg">
        <title>MultiKBIS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>

    <body> 



        <div style="width: 100%;height: 40px;background-color: black;position: fixed;">
            <div style=" width: 1100px;height: 100%; margin: 0 auto;">
                <img src="imagepass?path=${sessionScope.user_img}" width="100" height="100" style="height: 38px ;width: 38px;border-radius: 45px; float: left;margin-right: 30px;"/>  
                <div style="float: left;margin-top: 5px;"><b style="margin-top: 10px;;font-family: cursive;color: #16c2f6; text-align: center;font-size: 18px;"><span style="font-family: sans-serif; font-size: 15px;">Multi</span>KBIS</b></div>
                <a href="GoHome">     <div id="gohome" >
                        <div style="width: 40px ;height: 100%; float: left;background-color: transparent;">
                            <!--   <img src="../../img/538708-home_512x512.png" style="width: 29px;height: 29px; margin-top: 6px;margin-left: 5px;" />-->
                        </div>
                        <div style="width: 80px ;height: 100%;float: left;">  <p style="font-family: sans-serif;font-size: 12px; color: white;text-align: center;"> Go Home </p>   </div>
                    </div>
                </a>  
            </div>
        </div>

        <div style="width: 100%;height: 40px;"></div>

        <div style="width: 1050px; height: 100%; margin: 0 auto;background-color: white;;font-size: 14px;padding: 20px 20px;box-shadow: 0 0 4px brown">
            <form action="../resume" method="get">
                <div style="width: 500px;height: auto;float: left;background-color: white;padding: 10px 10px;">
                    <div id="acedmicheader">
                        <p style="font-size: 13px;margin-left: 40px; font-family: cursive; color: black;"> Personal Information</p>
                    </div>
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
                    <div style="width: 500px;height: auto;float: left;font-family: sans-serif;font-size: 14px;">
                        <div id="acedmicheader">
                            <p style="font-size: 13px;margin-left: 40px; font-family: cursive; color: black;">Major Project</p>
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
                    <div style="float: left;width: 500px;height: auto;font-size: 14px;">
                        <div id="acedmicheader">
                            <table>
                                <tr> <td>
                                        <input type="checkbox" name="c_skill_enable" value="yes" id="csk" onclick="checkvalidater('csk');"/>
                                    </td>
                                    <td>
                                        <p style="font-size: 13px;margin-left: 40px; font-family: cursive; color: black;"> Computer Skill</p>
                                    </td>

                                </tr>
                            </table>
                        </div>

                        <div style="">
                            <div id="cskillinvalidate" style="width: 500px;;height: 176px;; background-color: rgba(255,255,255,.5);position: absolute;"></div>
                            <table style="border:1px solid black;">
                                <tr>
                                    <td style="width: auto;margin:0;padding: 0;">  <input type="checkbox" name="cskos" value="yes" id="cskos" onclick="fillCS('cskos');"/></td>
                                    <td>Operating System Known</td>
                                    <td>
                                        <div id="divos" class="pctext" style="border: 1px solid rgba(0,0,0,.4); visibility: hidden;" onclick="visible('n1')"> </div>
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
                                <tr> <td style="width: auto;margin:0;padding: 0;">  <input type="checkbox" id="cskps" name="cskps" value="yes" onclick="fillCS('cskps');"/></td>
                                    <td>Programming Languages Known</td>
                                    <td> <div id="divpr" class="pctext" style="border: 1px solid rgba(0,0,0,.4);visibility: hidden;" onclick="visible('n2')"> </div>
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
                                <tr> <td style="width: auto;margin:0;padding: 0;">  <input type="checkbox" id="cskide" name="cskide" value="yes" onclick="fillCS('cskide');"/></td>
                                    <td>IDE Known</td>
                                    <td><input type="text" id="c_skill_ide" name="c_skill_ide" class="pctext" placeholder="e.i Eclipse,NetBeans etc" disabled="true"/></td>
                                </tr>
                                <tr> <td style="width: auto;margin:0;padding: 0;">  <input type="checkbox" name="cskds" id="cskds" onclick="fillCS('cskds');"/></td>
                                    <td>Database Known</td>
                                    <td><input type="text" id="c_skill_db" name="c_skill_db" class="pctext" placeholder="e.i oracle,MySql etc" disabled="true"/></td>
                                </tr>

                            </table>
                        </div>
                    </div>

                    <div style="float: left;width: 500px;height: auto;font-size: 14px;">
                        <div id="acedmicheader">
                            <table>
                                <tr> <td>
                                        <input type="checkbox" name="skill_enable" value="yes" id="skill_enable" onclick="fillCS('skill_enable');"/>
                                    </td>
                                    <td>
                                        <p style="font-size: 13px;margin-left: 40px; font-family: cursive; color: black;">Skills</p>
                                    </td>

                                </tr>
                            </table>
                        </div>
                        <textarea id="skilltext" name="skilltext"></textarea>
                        <script> CKEDITOR.replace('skilltext');</script>

                    </div>
                </div>


                <div style="font-family: sans-serif;font-size: 13px; float: left;width: 500px;background-color: white; padding: 10px 10px;">
                    <DIV>   <div id="acedmicheader">
                            <p style="font-size: 13px;margin-left: 40px;  color: black;;margin-bottom: 10px;"> Academic Details</p>
                        </div>
                        <table>
                            <tr>
                                <td><a style="font-size: 14px;"><strong>High School</strong></a></td>
                                <td></td>
                                <td></td></tr>
                            <tr> 
                                <td></td><td>Name of School</td>
                                <td>
                                    <input type="text" id="h_s_name" name="h_s_name" class="adtext"/>
                                </td>

                            </tr>
                            <tr> 
                                <td></td><td>Duration</td>
                                <td>
                                    <input type="text" id="h_s_y_o_a" name="h_s_y_o_a" class="adtext" placeholder="yyyy"/> /
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
                                <td><a style="font-size: 14px;"><strong>Senior Secondry</strong></a></td><td></td>
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
                                <td></td><td>Duration</td>
                                <td>
                                    <input type="text" id="s_s_y_o_a" name="s_s_y_o_a" class="adtext" placeholder="yyyy"/> /
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
                                <td><a style="font-size: 14px;"><strong>Graduation Detail</strong></a></td><td></td>
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
                                    <select name="choosebr" class="adtext" id="option2" >
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
                    <div style="width: 100%; height: auto; float:  left;">

                        <div id="acedmicheader">
                            <p style="font-size: 13px;margin-left: 40px; font-family: cursive; color: black;">Summer Training</p>
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
                    </div>
                    <hr/>
                    <div id="submit" onclick="clickr('submitme')" style="float: left;margin-top: 50px;">

                        <div style="width: 100%; height: 100%; margin-left: 100px;"> <div style="width: 40px ;margin-right: 10px;;height: 100%; float: left;">
                                <img src="../../img/adobe-pdf-logo.png" width="100%" height="100%"/>
                            </div><div style="width: auto; height: 100%; float: left;"><p style="text-align: center; font-size: 16px;" >Save And Create PDF </p></div>
                        </div>  </div>
                </div>


                <div id="mejorproject">


                </div>
                <input type="submit" id="submitme" style="visibility: hidden;"/>
            </form>

        </div>

    </body>
</html>
