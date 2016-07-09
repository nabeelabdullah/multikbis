/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
setInterval(imageChanger,2000);
function abcsubmit(A){  
   // alert("leeeelll");
    var us=document.getElementById("username").value;
     var up=document.getElementById("password").value;
     var dw=window.innerHeight;
     var dh=window.innerWidth;
     document.getElementById("bh").value=dw-3;
     document.getElementById("bw").value=dh-4;
     //alert(dw+"  "+dh);
    //var url="userlogin?username="+us+"&password="+up+"&bh="+dw;
    //alert(url);
   // window.open(url,'_self');
  document.getElementById(A).click();
  }
function txtFocus()
{
    
    document.getElementById("username").focus();  
}
function  loginSubmit(hiddensubmit2)
{
   // alert()
   document.getElementById(hiddensubmit2).click();
    
}
var image=1;
function imageChanger()
{
    document.getElementById("whatis").style.backgroundImage=" url('../aboutImage/"+image+".png')";
    if(image<6)
        image=image+1;else
            image=1;
    
}