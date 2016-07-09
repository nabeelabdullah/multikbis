/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var hideshow=0;
function hide_show()
{
   if(hideshow==0)
   { 
       document.getElementById("passdiv").style.visibility = "visible"; 
       document.getElementById("aimg").style.visibility = "visible"; 
       hideshow=1;
      
   }
   else
   {   
       document.getElementById("passdiv").style.visibility = "hidden"; 
       document.getElementById("aimg").style.visibility = "hidden"; 
       hideshow=0;
   }
}
var xml_c;
function change_pass()
{   document.getElementById("imgd").style.visibility="visible";
    var url="";
    xml_c_c=new XMLHttpRequest();
    xlm.open("Get",url,true);
    xml_c.onreadystatechange=c_p;
    xml_c.send(null);
 }
 function c_p()
 {   
     if((xml_c.readyState=4)&&(xml_c.state==200))
     {   
         var m=xml_c.responceText;
     }
 }
 
 function make_enable(A)
 { 
     document.getElementById(A).style.border="1px solid rgba(0,0,0,0.07)";
     document.getElementById(A).disabled=false;
      document.getElementById(A).focus;
    
 }
 function make_referesh(A,B)
 {
     var v=document.getElementById(A);//.value;
     var w=document.getElementById(B).value;
     v.value=w;
     document.getElementById(A).disabled=true;
     document.getElementById(A).style.border="0  black solid";
  }
 function clickr(A)
 {   universal_enable();
   //  //alert(A);
     document.getElementById(A).click();
 }
 function universal_enable()
 {
     var v="txt";
     for(var i=1;i<=10;i++)
     {
         document.getElementById(v+i).disabled=false;
     }
 }