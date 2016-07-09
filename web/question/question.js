/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var data;
var content;
//function temp()
//{    ////alert(v);
//    var assemble;
//    
//
//    var d = "<div class='second'>" +
//            "<img src='img/images0.jpeg' class='qustion_img'>" +
//            "</div>";
//
//
//    var e = "<p class='textp'>" + content + "</p>";
//    var a = "<a class='asked_by'>asked by you</a>" + "<a class='answerp'>no answer</a>";
//    assemble = d + e + a;
//    var v = "<div class='mydiv'>" + assemble + "</div>";
//    //  //alert(v);
//    document.getElementById("container").insertAdjacentHTML("beforeend", v);
//
//
//
//}

function onloader()
{
   setTimeout(ontime, 1000);
}
function goback()
{
    window.location.replace('GoHome');
}
function ontime()
{
//     document.getElementById('cke_46').style.height=0;
//     document.getElementById('cke_46').style.width=0;
//     document.getElementById('cke_46').innerHTML="";
     document.getElementById('cke_46').style.visibility="hidden";
     
}
function opennewtabforprofile(id, nam)
{
    var url = "simpleprofilepage_handler?user_id=" + id + "&name=" + nam;

    //  var win = window.open(url, '_blank');
    var win = window.open(url, '_self');

    win.focus();
}

//function content()
//{
//  data="<ul>";
//  var d= document.getElementById("textvalue").value;
//  var k=d.split('\n');
//  var i=0;
//  for(i=0;i<k.length;i++)
//  {
//      data=data+"<li>"+k[i]+"</li>";
//  }
//  data=data+"</ul>";
//  content=data;
//  data= data.replace(/\s\s/g, '&nbsp;&nbsp;');
// 
//}
var xlr;
function callajax(g_id)
{
    document.getElementById("gid").value=g_id;
    document.getElementById("submitme").click();
}
function callajaxold(g_id)
{
    content();
    data= data.replace(/&/g, 'AND');   
    var url = "qustionstorage?group_id=" + g_id + "&content=" + data;
    
    document.getElementById("clickme").style.visibility="hidden";
    document.getElementById("forimg").style.visibility="visible";
    xlr = new XMLHttpRequest();
    xlr.open("Get", url, true);
    xlr.send(null);
    xlr.onreadystatechange = abcajax;
  
}
function scroller()
{
   
    if(window.scrollY<=60){
     document.getElementById('subheader1').style.visibility="hidden";}
 else
      document.getElementById('subheader1').style.visibility="visible";
}
function temp()
{
    alert(window.scrollY);
}
function abcajax()
{
    ////alert("dddd");
    
    
    if (xlr.readyState == 4)
    {
        if (xlr.status == 200)
        {
             var res=xlr.responseText;
            ////alert(res);
        if(res=='done')
            temp();
       document.getElementById("clickme").style.visibility="visible";
       document.getElementById("forimg").style.visibility="hidden";
   

        }
    }
    }
    function answer_opener(q_id,g_id)
    {
        ////alert(";ool");
        var url="answerhandler?q_id="+q_id+"&group_id="+g_id+"&top="+document.getElementById("mybody").scrollTop;
        var win = window.open(url, '_self');
        // win.focus();
        return url;
    }
