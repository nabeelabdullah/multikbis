function sendmsq()
{
   // //alert("asd");
    var name=document.getElementById("name").value;
    var mail=document.getElementById("mail").value;
    var msg=document.getElementById("msg").value;
    var t=0;
    if(checkEmail()==true)
        t=1;
    var dataxml=new XMLHttpRequest();
    var url="http://multikbismail-nomannabeel.rhcloud.com/feedback?name="+name+"&mail="+mail+"&msg="+msg;  //"../../feedback?name="+name+"&mail="+mail+"&msg="+msg;//
  //  //alert(url);
    dataxml.open("POST",url,true);
   
   if((name!="")&&(msg!="")&&(t==1))
    {
    document.getElementById("loading").style.visibility="visible";
    document.getElementById("fspam").innerHTML="feedback sending please wait...";
    dataxml.send();
    }
    else
        //alert("some field missing");
   
    dataxml.onreadystatechange=function(){   
      //  //alert(dataxml.readyState+" "+dataxml.status);
    if((dataxml.readyState==4))
    
    { 
      
        if(!dataxml.responseText==1)
        {
            document.getElementById("loading").style.visibility="hidden";
            document.getElementById("fspam").innerHTML="feedback send";
        }
        else
        {
            document.getElementById("loading").style.visibility="hidden";
            document.getElementById("fspam").innerHTML="feedback not  send due to some error";
        }
        
    }
   
    }
//  //alert("t ="+t);
    
    
}

function checkEmail() {
    

    var email = document.getElementById('mail');
   
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (email.value == "")
    {
        return false;
    }

    else
    {
        if (!filter.test(email.value)) {

          //  document.getElementById(B).innerHTML = "email address not valid";

            return false;
        }
        else
        {
           // document.getElementById(B).innerHTML = "";
            return true;

        }
    }
}