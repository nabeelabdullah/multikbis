/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function text_focus(){
    document.getElementById('name1').focus();
    
}
var xml2;
var res=1;


   function  abcdef()
   {
       
   var a1=document.getElementById("name1").value;
   
   var b=document.getElementById("rname").value;
    
   var c=document.getElementById("ename").value;
   
   var d="0000000000";//document.getElementById("mobile").value;
   var e=document.getElementById("iname").value;
    
   var f="NILL";//document.getElementById("cname").value;

   var g=document.getElementById("pname").value;
 
   var h=document.getElementById("rpname").value;
  
   var i=document.getElementById("option1").value;
    
   var j=document.getElementById("option2").value;
    
   var k=document.getElementById("option3").value;
   
   var l=document.getElementById("radio1").value;    
   
   var val2=document.getElementById('check_box').checked;
     
   
   if(a1=="" ||b==""||c==""||d==""||e==""||f==""||g==""||h==""||i==""||j==""||k==""||l==""||val2==false)
   {  //alert("if chala");
       document.getElementById("servletresponse").style.visibility="visible";
       document.getElementById("span4").innerHTML="KINDLY CHECK THE FIELDS";
   }
   else{
       document.getElementById("ragistered_submit").click();

   
       }
   }

 
 var img="<img src='image///alert.ico' height='100%' width='100%'/>";
 function accountvalidator1(A,B,C)
{       
    var s= document.getElementById(A);
    var filter=/^[[a-z]||[A-Z]][a-z]*[A-Z]*/;
    if(s.value=="")
    {
    document.getElementById(B).innerHTML="FIRST NAME SHOULD NOT BE EMPTY"; 
    document.getElementById(C).style.visibility="visible";
    document.getElementById(A).style.border=" 1px solid red";
    return false;
   
    }
    
     else
    {
        if (!filter.test(s.value)) {

            document.getElementById(B).innerHTML = "ENTER A VALID FIRST NAME";
             document.getElementById(C).style.visibility="visible";
            return false;
        }
    else
    {
        document.getElementById(B).innerHTML=""; 
        document.getElementById(C).style.visibility="hidden";
    }
    } 
    
}


//last name
 function accountvalidator2(A,B,C)
{       
     
    var s= document.getElementById(A);
    var filter=/^[[a-z]||[A-Z]][a-z]*[A-Z]*/;
    if(s.value=="")
    {
     
    document.getElementById(B).innerHTML="LAST NAME SHOULD NOT BE EMPTY"; 
    document.getElementById(C).style.visibility="visible";
     document.getElementById(A).style.border=" 1px solid red";
    return false;
   
    }
    
     else
    {
        if (!filter.test(s.value)) {

            document.getElementById(B).innerHTML = "ENTER VALID LAST NAME";
            document.getElementById(C).style.visibility="visible";
            return false;
        }
    else
    {
        document.getElementById(B).innerHTML=""; 
        document.getElementById(C).style.visibility="hidden";
    }
    } 
    
}
//Email
var a;
 function accountvalidator3(A,B,C)
{       
     
   var s= new String(document.getElementById(A).value).trim();
   var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (s == "")
    {
        document.getElementById(B).innerHTML = "EMAIL SHOULD NOT BE EMPTY";
        document.getElementById(C).style.visibility="visible";
        document.getElementById(A).style.border=" 1px solid red";
        
    }

    else
    {
        if (!filter.test(s)) {

            document.getElementById(B).innerHTML = "ENTER VALID EMAIL ADDRESS";
            document.getElementById(C).style.visibility="visible";

            return false;
        }
    else
    {    
         
        a=new XMLHttpRequest();
        var b=document.getElementById(A).value;
        var url="ajaxcreateaccount?email="+escape(b);
        a.open("Get",url,true); 
            ////alert(11);
        a.send();
        a.onreadystatechange=email1;
    }
    } 
    
}
//ajax email
function email1()
{  ////alert(12);
    if(a.readyState==4&&a.status==200){ 
        var c=a.responseText;
        document.getElementById("newspan2").innerHTML=c;
        document.getElementById("second").style.visibility="visible";
    
    }
    
}



//mobile no
 function accountvalidator4(A,B,C)
{       
     
    var s= document.getElementById(A);
    var filter=/^[0-9]{10}$/;
   if(s.value=="")
			
    {
     
    document.getElementById(B).innerHTML=" NUMBER SHOULD NOT BE EMPTY"; 
    document.getElementById(C).innerHTML=img;
    document.getElementById(A).style.border=" 1px solid red";
   
    }
    
     else
    {
        if (!filter.test(s.value)) {

            document.getElementById(B).innerHTML = "ENTER VALID MOBILE NUMBER";
            document.getElementById(C).innerHTML=img;

            return false;
        }
    else
    {
        document.getElementById(B).innerHTML=""; 
        document.getElementById(C).innerHTML="";
    }
   
     }

}

//password
function accountvalidator5(A,B,C)
{       
     
    var s= document.getElementById(A);
    
   if(s.value=="")
			
    {
     
    document.getElementById(B).innerHTML="PASSWORD SHOULD NOT BE EMPTY"; 
    document.getElementById(C).innerHTML="";
    document.getElementById(C).innerHTML="<img src='../../image/alert.ico' class='img' style='visibility: visible'/>";
    document.getElementById(A).style.border=" 1px solid red";
    }
    
     else
    {
       document.getElementById(B).innerHTML=""; 
       document.getElementById(C).innerHTML="";
   
     }

}

//var img_true="<img src='image/true.png' height='80' width='50'/>";
function abc_inputpass(A,B,C){
    
    
    var x=document.getElementById(A).value;
    var z=document.getElementById(B).value;
    //alert("1st="+x+"2nd="+z);

         if(x===z)
         {
         document.getElementById(C).innerHTML="<img src='../../image/true2.png' class='img' style='visibility: visible'/>";
         }
        else
        {  
             document.getElementById(C).innerHTML="<img src='../../image/alert.ico' class='img' style='visibility: visible'/>";  
        }
       
}
 

//re check password
function accountvalidator6(A,C,B,D)
{       
     
    var s1= document.getElementById(A).value;
    var s2= document.getElementById(C).value;
    document.getElementById(D).innerHTML="";
    
   if(s2=="")
			
    {
    document.getElementById(B).innerHTML="PASSWORD SHOULD NOT BE EMPTY"; 
    document.getElementById(C).style.border=" 1px solid red";
    document.getElementById(D).innerHTML="<img src='../../image/alert.ico' class='img' style='visibility: visible'/>";
   
    }
    
     else
    {
        if(s1!=s2)
        {
            document.getElementById(B).innerHTML="RE-ENTER PASSWORD IS INVALID";
            document.getElementById(D).innerHTML="<img src='../../image/alert.ico' class='img' style='visibility: visible'/>";
      
        }
        else{
             document.getElementById(B).innerHTML=""; 
             document.getElementById(D).innerHTML="";
        }
     }
     

}
 
 
  //institute

 function accountvalidator7(A,B)
{       
     
    var s= document.getElementById(A).value="INTEGRAL UNIVERSITY";
    var filter=/^[[a-z]||[A-Z]][a-z]*[A-Z]*/;
    if(s.value=="")
    {
     
    document.getElementById(B).innerHTML="INSTITUTE SHOULD NOT BE EMPTY"; 
    document.getElementById(C).style.border=" 1px solid red";
    return false;
   
    }
    
     else
    {
        if (!filter.test(s.value)) {

            document.getElementById(B).innerHTML = "ENTER VALID INSTITUTE";

            return false;
        }
    else
    {
        document.getElementById(B).innerHTML=""; 
    }
    } 
    
}


//city
 function accountvalidator8(A,B)
{       
     
    var s= document.getElementById(A).value="LUCKNOW";
    var filter=/^[[a-z]||[A-Z]][a-z]*[A-Z]*/;
    if(s.value=="")
    {
     
    document.getElementById(B).innerHTML="CITY SHULD NOT EMPTY"; 
    return false;
   
    }
    
     else
    {
        if (!filter.test(s.value)) {

            document.getElementById(B).innerHTML = "ENTER VALID CITY";

            return false;
        }
    else
    {
        document.getElementById(B).innerHTML=""; 
    }
    } 
    
}
