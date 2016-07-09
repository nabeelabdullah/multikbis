

var servermax_id = 1;
var servero = 0;
var open_span = [];
open_span[01] = "sp10";
open_span[02] = "sp9";
open_span[03] = "sp8";
open_span[04] = "sp7";
open_span[05] = "sp6";
open_span[06] = "sp5";
open_span[07] = "sp4";
open_span[08] = "sp3";
open_span[09] = "sp2";
open_span[10] = "sp1";
var change_onhover;
var chat_divid = null;
var chat_servletid = "0";
var top_stack = 1;

var name_param = [];
var stack = [];
var div_id = [];
div_id[01] = "id10";
div_id[02] = "id9";
div_id[03] = "id8";
div_id[04] = "id7";
div_id[05] = "id6";
div_id[06] = "id5";
div_id[07] = "id4";
div_id[08] = "id3";
div_id[09] = "id2";
div_id[10] = "id1";

var temp_set = 0;

setTimeout(pending_chat1, 1000);
//setTimeout(continue_chat1, 1050);
setInterval(continue_chat1, 2000);
setInterval(pending_chat1, 3050);
setTimeout(onloader, 100);


function loadert()
{
  //  var v = document.getElementById('temppass').value;
   
    var x = new XMLHttpRequest();
    var url = "NewFriendsNUmbers";
    x.open("Get", url, true);
    
    x.send();
    x.onreadystatechange = function() {
        if ((x.readyState == 4) && (x.status == 200))
        {
            var data = x.responseText;
          
            var js = eval('(' + data + ')');
              
             var fr = js.f;
             var gr=js.g;
           
            if(fr!=0){
               
        document.getElementById('frreq').style.visibility="visible";
         document.getElementById('frreq').innerHTML=fr;
            }
            if(gr!=0){
               
        document.getElementById('grreq').style.visibility="visible";
         document.getElementById('grreq').innerHTML=gr;
            }
        }

    };
    
}


function makesound()
{
    var snd = new Audio("sound/facebook_chat_sound.wav"); // buffers automatically when created
    snd.play();


}
function ogoffline()
{
    window.location.replace('usego_offline');
   
   
}
function Navigate() {

    window.location.replace('');
    return false;
}
function templogout()
{

    document.getElementById('templogout').style.visibility = "visible";
    var x = new XMLHttpRequest();
    var url = "templogout";
    x.open("Get", url, true);
    x.send();
}
function templogin()
{
    var v = document.getElementById('temppass').value;

    var x = new XMLHttpRequest();
    var url = "templogin?password=" + v;
    x.open("Get", url, true);

    x.send();
    x.onreadystatechange = function() {
        if ((x.readyState == 4) && (x.status == 200))
        {
            var data = x.responseText;

            if (data == 1)
                document.getElementById('templogout').style.visibility = "hidden";
            else {
                alert("wrong password");
            }
        }

    };
}


function fortemp(A, B)
{
    //  ////////alert(chat_divid + " " + chat_servletid);

    if (temp_set == 0)
    {


        makevisible1(A, B);
        temp_set = 1;


    }
    else
    {

        makehidden1(A, B);
        temp_set = 0;

    }
}
/* this is for search header*/

var hideshow = 0;
function hide_show()
{
    if (hideshow == 0)
    {
        document.getElementById("searchheader").style.visibility = "visible";
        hideshow = 1;

    }
    else
    {
        document.getElementById("searchheader").style.visibility = "hidden";
        hideshow = 0;
    }
}
/* this is for search header*/

//window.onbeforeunload = function(){
//  
//   
//    return clicker('logouter'); 
//   
//}
function clicker(A)
{
    //alert("clicker");
    //window.location="";
    document.getElementById(A).click();
}
function makevisible1(A, B)
{
    document.getElementById(B).style.visibility = "visible";
    document.getElementById(A).style.visibility = "visible";
    if (A == 'newfr')
        f_request();
    if (A == 'myfr')
        my_request();
    if (A == 'mygr')
        my_group();

}
function makehidden1(A, B)
{

    document.getElementById(B).style.visibility = "hidden";
    document.getElementById(A).style.visibility = "hidden";

}

function make_old(A)
{
    var st = document.getElementById(A).style;
    st.visibility = "hidden";

}

function colorec()
{
    // document.getElementById("cover").style.visibility = "visible";

}
var furl, fid;
function send_file(id, name, to)
{
    // document.getElementById("filecontainer").style.visibility = "visible";
    document.getElementById("filespan").innerHTML = name;
    if (to == "f")
    {

    }
    if (to == "g")
    {

    }
    // colorec('cover');
}
function makewhite(A)
{
    document.getElementById(A).style.color = "white";
}
function makeblack(A)
{
    document.getElementById(A).style.color = "black";
}
function valuechanger(A)    //this function set the value of div on which mouse_onHOVER
{
    change_onhover = A;

}

function param1(A, B)
{

    stack[top_stack] = A;
    name_param[top_stack] = B;
    document.getElementById(open_span[top_stack]).innerHTML = name_param[top_stack];

}

function open1(A, B)         // A is id ,B is name
{
    //////alert("open"+A+"  "+B);
    var reopen = re_openor(A);

    if (reopen == 0)
    {

        param1(A, B);
        if (chat_divid != null)
            minimize();


        document.getElementById(div_id[top_stack]).style.visibility = "visible";
        document.getElementById("startchat").style.visibility = "visible";
 $("#startchat").show();
        chat_servletid = stack[top_stack];
        chat_divid = div_id[top_stack];
        document.getElementById("chatsp").innerHTML = name_param[top_stack];
        top_stack++;
        document.getElementById(chat_divid).style.backgroundColor = "black";//"#9b060b";// "#045152"; //"yellow";
        // document.getElementById(chat_divid).style.backgroundImage="url('../img/test30.jpg')";
    }
    else
    {
        change_onhover = reopen;
        maximize();
    }
}

function minimize()
{
    document.getElementById("startchat").style.visibility = "hidden";
     $("#startchat").hide();
    document.getElementById(chat_divid).style.backgroundColor = "#7f7f7f";//"#84C884";//"#ADDE95";//"lightslategray";
    document.getElementById("chatmiddle").innerHTML = null;
    chat_servletid = "0";
}

function maximize()
{
    document.getElementById(chat_divid).style.backgroundColor = "#7f7f7f";//"lightslategray";
    document.getElementById(div_id[change_onhover]).style.backgroundColor = "black";//"#045152"; //"yellow";
    // document.getElementById(div_id[change_onhover]).style.background="url('../img/test30.jpg')";
    chat_servletid = stack[change_onhover];
    chat_divid = div_id[change_onhover];
    document.getElementById("chatsp").innerHTML = name_param[change_onhover];
    document.getElementById("startchat").style.visibility = "visible";
    $("#startchat").show();
    document.getElementById("chatmiddle").innerHTML = null;
    received_chat();



}



function setter()
{
    change_onhover = matcher(chat_divid);
    cut_chat();
}


function cut_chat()                                       //this is used to closed the chat
{
    var h = 0;

    if (div_id[change_onhover] == chat_divid)
    {
        chat_servletid = "0";

        document.getElementById("startchat").style.visibility = "hidden";
         $("#startchat").hide();
        h = 1;
    }
    document.getElementById(div_id[change_onhover]).style.visibility = "hidden";
    document.getElementById(chat_divid).style.backgroundColor = "#7f7f7f";//"lightslategray";

    arranger();

    var match = matcher(chat_divid);
    if (change_onhover < match)
    {
        chat_divid = div_id[match - 1];
        chat_servletid = stack[match - 1];

    }
    top_stack--;
    var m = change_onhover;

    while (m < top_stack)
    {
        document.getElementById(div_id[m]).style.visibility = "visible";
        m++;
    }
    if (h == 0)
        document.getElementById(chat_divid).style.backgroundColor = "black"; //"yellow";


}



function matcher(A)             //this function return the array location on which 'A stored'
{
    var t = 1;

    while (t < top_stack)
    {
        if (div_id[t] == A)
            break;
        t++;
    }
    return t;
}




function arranger()           //this function re-arrange the content of stack
{

    var n = top_stack - change_onhover - 1;
    var m = change_onhover;
    var i = 1;
    while (i <= n)
    {
        name_param[m++] = name_param[m];
        m--;
        stack[m++] = stack[m];
        document.getElementById(div_id[m]).style.visibility = "hidden";
        document.getElementById(open_span[m - 1]).innerHTML = name_param[m - 1];
        i++;
    }

}


function re_openor(A)
{
    var re_temp = 0;
    var i;
    for (i = 1; i < top_stack; i++)
    {
        if (stack[i] == A)
        {
            re_temp = i;
            break;
        }
    }
    return re_temp;
}



function ajax_js()
{
    var url = "remainingfrieng_haldler?name=" + name;   // "newjsp1.jsp";//"ajaxserv";
    //alert(url);
    var xlr = new XMLHttpRequest();
    xlr.open("Get", url, true);
    xlr.send(null);
    xlr.onreadystatechange = function()
    {


        if (xlr.readyState == 4)
        {
            if (xlr.status == 200)
            {

                var x = xlr.responseText;
      // alert(x);
                document.getElementById("left").insertAdjacentHTML("beforeend", x);

            }


        }

    };

}




function mesenger(string)
{
    var result = [];
    var item = 0;
    var str = string;
    var temp = 0;
    var seprator = 26;
    var length = string.length;
    while (temp < length)
    {
        result[item++] = str.substring(0, seprator);
        str = str.substring(seprator);
        temp += seprator;
    }
    var returner =result[0];
    for (var t = 1; t < result.length; t++)
    {
        returner += "<br/>" + result[t];
    }

    return returner;

}
function fromchat(A)
{
   var ret=   "<div class='fromyou' >"+
            
                                
                                   " <div class='fromchatimg' >"+
                "<div class='fromchatimgin' >"+
                    "<img src='../img/lpointer.png' style='width: 100%;height: 100%;'/>"+
                "</div>"+
            "</div>"+
                "<div class='fromchatcontent' >"+
                "<p  class='fromchatcontentp' >"+A+
                "</p>"+
           " </div>"+
       " </div>";
       return ret;
               
}
function youchat(A)
{
    
    var ret=                    "<div class='fromyou' >"+
            
                                    "<div class='youchatcontent' >"+
                "<p  class='fromchatcontentp' >"+A+
                "</p>"+
           " </div>"+
                                   " <div class='fromchatimg' >"+
                "<div class='fromchatimgin' >"+
                    "<img src='../img/rpointer.png' style='width: 100%;height: 100%;'/>"+
                "</div>"+
            "</div>"+
       " </div>";
               
        
       return ret;
            
                                    
}

function send_chat(A)
{
    var c = document.getElementById(A).value;
   //c = mesenger(c);
    // messageAssebler(0,c,c.length);
    //c= c.value;
    
    
    
    var v = "<p class='youchat'>";
    var yu = "YOU   :";
    
    var divider = "<div class='chat_devider'></div>";
    var p = youchat(c);//"<div class='chatpara'> <p class='fupara' style='color: #16c2f6;'>you: </p>" + c + "</div><hr/>";
    document.getElementById("chatmiddle").insertAdjacentHTML("beforeend", p);
    //document.getElementById("chatmiddle").insertAdjacentHTML("beforeend", divider);
    var url = "com.website.friend.main.CHAT?msg=" + c + "&r_id=" + chat_servletid + "&name=" + document.getElementById("chatsp").innerHTML;
    
    xlrc = new XMLHttpRequest();
    xlrc.open("Get", url, true);

    document.getElementById("chatmiddle").scrollTop = "1000000000";
    document.getElementById("sendchattext").value = "";
    xlrc.send(null);

}
function abc_c()
{


    if (xlrc.readyState == 4)
    {
        if (xlrc.status == 200)
        {

            var x = xlrc.responseText;
            //////////alert(x);
        }


    }

}

var srcollset = 1;
function settimer()
{
    setTimeout(scrollsetter, 2000);
}

function scrollsetter()
{
    srcollset = 1;
}
function scrollercaller()
{

    //if (srcollset === 1)
        scroller();
}

var one_time = false;
function scroller()
{
    srcollset = 0;
   // settimer(scrollsetter, 2000);
    if (one_time === false)
    {

        document.getElementById("left").scrollTop;
        one_time = true;
    }


     var h = document.getElementById("left").scrollHeight;
     var t = document.getElementById("left").scrollTop;
    
     if((t+621)>(h-10))
     {
        // alert("aa");
         ajax_js();
     }

}





function received_chat()
{
    //var c = document.getElementById(A).value;

    var url = "sendmsg?s_id=" + chat_servletid;

    var xlrct = new XMLHttpRequest();
    xlrct.open("Get", url, true);
    xlrct.send(null);
    xlrct.onreadystatechange = function()
    {

        if (xlrct.readyState == 4)
        {
            if (xlrct.status == 200)
            {

                var x = xlrct.responseText;

                document.getElementById("chatmiddle").insertAdjacentHTML("beforeend", x);
            }


        }

    };

}


function continue_chat1()                 //this functiom check a new talk send by open sender
{
    var url = "com.website.friend.main.continuechat?s_id=" + chat_servletid;

    var xmlcc1 = new XMLHttpRequest();
    xmlcc1.open("Get", url, true);
    xmlcc1.send(null);
    xmlcc1.onreadystatechange = function()
    {


        if (xmlcc1.readyState == 4)
        {
            if (xmlcc1.status == 200)
            {

                var x1 = xmlcc1.responseText;
                if (x1 != "")
                {
                    makesound();

                    document.getElementById("chatmiddle").insertAdjacentHTML("beforeend", x1);
                    document.getElementById("chatmiddle").scrollTop = "1000000000";
                }

            }


        }

    };

}



var pxml;
function pending_chat1()
{

    var url = "com.website.friend.main.newpendingchat?current=" + chat_servletid;
    //////alert(url);
    pxml = new XMLHttpRequest();
    pxml.open("Get", url, true);

    pxml.onreadystatechange = pendingc;
    pxml.send(null);

}
function pendingc()
{

    if (pxml.readyState == 4)
    {
        if (pxml.status == 200)
        {


            var x = pxml.responseText;
            //////alert(x);
            var js = eval('(' + x + ')');


            for (var x in js)
            {
                var id = js[x].s_id;
                var name = js[x].s_name;
                if (id != null && id != chat_servletid)
                {
                    // makesound();
                    open1(id, name);


                }

            }

        }
    }
}


/* this function show the searched friend */
var xflr;
var f_friend_name;
var fonetime = true;
function f_request()
{
    var x = "<img src='img/aj1.gif' style='width:20px ;height:10px; margin-top:6px; margin-left:60px; '/>";

    document.getElementById("con_newfr1").innerHTML = "";
    var d = document.getElementById("searchtext").value;
    if (d != "" && d != " ")
    {
        fonetime = true;
        f_friend_name = d;
        var url = "friendrehandler?name=" + d;
        xflr = new XMLHttpRequest();

        xflr.open("Get", url, true);
        // document.getElementById("con_newfr1").insertAdjacentHTML("beforeend", x);
        xflr.onreadystatechange = friendrequest_f1;
        xflr.send(null);
        //document.getElementById("loadingdiv2").style.visibility = "visible";

    }
    else
        document.getElementById("con_newfr1").insertAdjacentHTML("beforeend", "ONLY SPACE NOT ALLOWED");

}
function fsetterresetter()
{
    ftimersetter = true;
}
var ftimersetter = true;

function f_scroll_caller()
{
    //if (ftimersetter == true)
        f_scroll();
}


function f_scroll()
{
    if (fonetime)
    {
        document.getElementById("newfr").scrollTop = "0";
        fonetime = false;
    }
    var h = document.getElementById("newfr").scrollHeight;
    var t = document.getElementById("newfr").scrollTop;
    
     if((t+611)>(h-10))
     {
       
           f_friend_scroll();
     }

}
function f_friend_scroll()
{      // ////alert("nabeel");
    var url = "friendrescroller?name=" + f_friend_name;
    ////alert(url);
    xflr.open("Get", url, true);
    xflr.send(null);
    xflr.onreadystatechange = friendrequest_f1;


}







function friendrequest_f1()
{


    if (xflr.readyState == 4)
    {
        if (xflr.status == 200)
        {
            //document.getElementById("loadingdiv2").style.visibility = "hidden";
            var x = xflr.responseText;
            ////alert("nabeel"+x);
            //   document.getElementById("con_newfr1").innerHTML = "";
            document.getElementById("con_newfr1").insertAdjacentHTML("beforeend", x);

        }


    }

}
/* this function show the searched friend */


/* this function show the requested friend */
var xflrn;
function my_request()
{

    document.getElementById("con_myfr").innerHTML = "";
document.getElementById('frreq').style.visibility="hidden";
    var url = "myfriendreqhandeler";//"ajaxserv";
    var x = "<img src='img/aj1.gif' style='width:20px ;height:10px; margin-top:6px; margin-left:60px; '/>";
    document.getElementById("con_myfr").insertAdjacentHTML("beforeend", x);
    xflrn = new XMLHttpRequest();

    xflrn.open("Get", url, true);

    xflrn.onreadystatechange = myfriendrequest_f1;
    xflrn.send(null);
}

function myfriendrequest_f1()
{


    if (xflrn.readyState == 4)
    {
        if (xflrn.status == 200)
        {
            document.getElementById("con_myfr").innerHTML = "";

            var x = xflrn.responseText;

            document.getElementById("con_myfr").insertAdjacentHTML("beforeend", x);

        }


    }

}
/* this function show the request friend */





function my_group()
{
    var url = "grouprequesthandler";
    
    var xglrn = new XMLHttpRequest();

    xglrn.open("Get", url, true);
    document.getElementById("con_mygr").innerHTML = "";
    xglrn.send(null);


    xglrn.onreadystatechange = function()
    {
        if ((xglrn.readyState == 4) && (xglrn.status == 200))
        {
             document.getElementById('grreq').style.visibility="hidden";
            var x = xglrn.responseText;
            // alert(x);
            document.getElementById("con_mygr").insertAdjacentHTML("beforeend", x);
        }
        ;
    }

}





/*  for event listener */
var reset_value = 0;
function reseter(A)
{
    reset_value = A;
    //  ////alert(reset_value);
}
var chatreset = true;
window.addEventListener("keypress", dealWithKeyboard, false);
window.addEventListener("keyup", chatreseter, false);
function chatreseter(key)
{
    if (reset_value == 1)
        chatreset = true;
}


function dealWithKeyboard(key)
{
    //////alert("keys"+" "+key.keyCode);
    if (key.keyCode == 13)
    {

        if (reset_value == 1)
        {
            if (chatreset == true)
            {
                send_chat("sendchattext");
                chatreset = false;
            }
        }
        else if (reset_value == 3)
            searchfriend();
        else if (reset_value == 2)
            makevisible1('newfr', 'con_newfr1');
        else if (reset_value == 4)
            searchgroup();
    }


}
/*  for event listener */

/* Z-INDEX MANAGER */
function z_index_mg(A, B)
{
    document.getElementById(A).style.zIndex = "2";
    document.getElementById(B).style.zIndex = "1";


}
/* Z-INDEX MANAGER */

/* this function used to send the friend req.to seaeched peaple */


function frequest_sender(A)
{
//    var insert = "<div class='fsendbutton'>" +
//            " <img src='img/done.jpg' class='cimg'/> " +
//            "<p class='cvp' id='chatting' style='font-size:14px; color:blue; ' > <b>REQUEST SEND </b></p>   </div> ";

    var url = "searchedfriend?f_id=" + A;
    var tinsert = "<img src='img/aj1.gif' style='width:20px ;height:10px; margin-top:6px; margin-left:10px; '/>";
    var fxml = new XMLHttpRequest();

    fxml.open("Get", url, true);


    var fxml_id = "foot" + A;

    document.getElementById(fxml_id).innerHTML = "";
    document.getElementById(fxml_id).insertAdjacentHTML("beforeend", tinsert);
    fxml.send(null);
    fxml.onreadystatechange = function()
    {


        if (fxml.readyState == 4)
        {
            if (fxml.status == 200)
            {
                var v = fxml.responseText;
                //  alert(v);
                var data;
                if (v == "nf")
                    data = "REQUEST SEND";
                else if (v == "af")
                    data = "ALREADY FRIEND";//"ALREADY FRIEND";
                else if (v == "ap")
                    data = "ALREADY REQUEST PENDING";

                var insert = "<div class='fsendbutton'>" +
                        " <img src='img/done.jpg' class='cimg'/> " +
                        "<p class='cvp' id='chatting' style='font-size:14px; color:blue; ' > <b>" + data + "</b></p>   </div> ";
                document.getElementById(fxml_id).innerHTML = "";
                document.getElementById(fxml_id).insertAdjacentHTML("beforeend", insert);
            }
        }
    };



}

/* this function used to send the friend req.to seaeched peaple */

/* this fun. conferm or cancle the request*/


function request_cc(V, I)
{
    var insert = "<img src='img/aj1.gif' style='width:20px ;height:10px; margin-top:6px; margin-left:10px; '/>"; //"<div  class='fbuttonjs'>"+

    var url = "confcnl?value=" + V + "&f_id=" + I;
    //alert(url);
    var xmlr1 = new XMLHttpRequest();
    xmlr1.open("Get", url, true);

    var xmlr_id = "ccf" + I;
    document.getElementById(xmlr_id).innerHTML = "";
    document.getElementById(xmlr_id).insertAdjacentHTML("beforeend", insert);
    xmlr1.send(null);
    xmlr1.onreadystatechange = function() {



        if (xmlr1.readyState == 4)
        {
            if (xmlr1.status == 200)
            {
                var insert = "<div  class='fbuttonjs'>" +
                        "<img src='img/done.jpg' class='cimg'/> " +
                        " <p style='font-size:16px;color:blue; margin-top:2px;'> DONE </p> </div>";


                document.getElementById(xmlr_id).innerHTML = "";
                document.getElementById(xmlr_id).insertAdjacentHTML("beforeend", insert);
            }
        }
    };

}

/* this fun. conferm or cancle the request*/

/*this is for search friengand group in list*/
var sfxml;
var name = "";
function searchfriend()//searchgroup()
{
    var v = document.getElementById("searchfriendinput").value;
    var url = "searchfrieng_and_group?name=" + v;

    name = v;
    sfxml = new XMLHttpRequest();
    sfxml.open("Get", url, true);
    document.getElementById("left").innerHTML = "";
    document.getElementById("searchfrienddiv").innerHTML = "";
    document.getElementById("searchfrienddiv").innerHTML = "<img src='../img/search_loader.gif' class='searchimg'/>";
    sfxml.onreadystatechange = searchfriend1;
    sfxml.send(null);

}
function searchfriend1()
{
    if ((sfxml.readyState == 4) && (sfxml.status == 200))
    {
        var val = sfxml.responseText;
        document.getElementById("searchfrienddiv").innerHTML = "";

        document.getElementById("searchfrienddiv").innerHTML = "<img src='img/search.png' class='searchimg'/>";
        document.getElementById("left").insertAdjacentHTML("beforeend", val);
    }
}

/*this was for search friengand group in list*/

/*----------------------------*/



var sgxml;
function searchgroup()
{
    var v = document.getElementById("searchgroupinput").value;
    var url = "searched_group?group_name=" + v;
    sgxml = new XMLHttpRequest();
    sgxml.open("Get", url, true);
    document.getElementById("right").innerHTML = "";
    document.getElementById("searchgroupdiv").innerHTML = "";
    document.getElementById("searchgroupdiv").innerHTML = "<img src='../img/search_loader.gif' class='searchimg'/>";
    sgxml.onreadystatechange = searchgroup1;
    sgxml.send(null);

}
function searchgroup1()
{
    if ((sgxml.readyState == 4) && (sgxml.status == 200))
    {
        var val = sgxml.responseText;
        document.getElementById("searchgroupdiv").innerHTML = "";
        document.getElementById("searchgroupdiv").innerHTML = "<img src='img/search.png' class='searchimg'/>";
        document.getElementById("right").insertAdjacentHTML("beforeend", val);
    }
}



/*------------------------------*/



function opennewtabforprofile(id, nam)
{
    var url = "profilehandler?user_id=" + id + "&name=" + nam;

    //  var win = window.open(url, '_blank');
    var win = window.open(url, '_self');

    win.focus();
}
function opennewtabforsendreqpro(id, nam)
{
    var url = "sendreqprofilehandler?user_id=" + id + "&name=" + nam;

    var win = window.open(url, '_blank');

    win.focus();
}
function opennewtabforconcleprofile(id, nam)
{
    var url = "conclehandler?user_id=" + id + "&name=" + nam;

    var win = window.open(url, '_blank');

    win.focus();
}
function openprofiletab()
{
    var url = "updateprofile_handler";
    // var win=window.open(url,'_blank');
    var win = window.open(url, '_self');
    win.focus();
}
function createprofile()
{
    var url = "createprofile_handler";
    var win = window.open(url, '_self');//'_blank');
    //window.location.replace(url)
    win.focus();
}


setInterval(online_offline, 3000);
var on_off;
function online_offline()
{


    var url = "onoff_manager";
    on_off = new XMLHttpRequest();
    on_off.open("Get", url, true);
    on_off.send(null);
    on_off.onreadystatechange = online_offline1;

}
function online_offline1()
{

    if (on_off.readyState == 4)
    {
        if (on_off.status == 200)
        {
            var v = on_off.responseText;
            // ////alert(v);
            var js = eval('(' + v + ')');
            //////alert(v);
            onloader();
            for (var val in js)
            {   //////alert(val);
                document.getElementById(js[val]).style.visibility = "visible";
            }

        }
    }
}

function onloader()
{
    //body_load();
    // ////alert("onload");
    var w = document.getElementsByClassName("rgimg");
    var i = 0;
    for (i = 0; i < w.length; i++)
    {
        w[i].style.visibility = "hidden";
    }
}
//function universal_hidder()
//{
//     ////alert("chala");
//  var v=  document.getElementsByClassName("alhider");
//  
// var i=0;
// for(i=0;i<v.length;i++)
// {
//     v[i].style.visibility="hidden";
// }
//}
function file_manegment()
{
    document.getElementById("cover").style.visibility = "visible";
    document.getElementById().style.visibility = "visible";
    document.getElementById().style.visibility = "visible";
    document.getElementById().style.visibility = "visible";
    document.getElementById().style.visibility = "visible";
    document.getElementById().style.visibility = "visible";
}


var srcdiv;
function grouprequest_sender(group_id, srcdiv_id)
{
    // alert(srcdiv_id);
    srcdiv = srcdiv_id;
    document.getElementById(srcdiv_id).innerHTML = "";
    document.getElementById(srcdiv_id).innerHTML = "<img src='../../img/aj1.gif' style='width:20px ;height:10px; margin-top:6px; margin-left:10px; '/>";
    var url = "grouprequest?group_id=" + group_id;//+ "&member_id=" + user_id;
    ////alert(url);
    var gxml = new XMLHttpRequest();
    gxml.open("Get", url, true);
    gxml.send(null);
    gxml.onreadystatechange = function()
    {
        if ((gxml.status == 200) && (gxml.readyState == 4))
        {
            var v = gxml.responseText;
            // alert(v);
            var m = "<img src='../../img/done.jpg' style='width:20px ;height:20px;float:left'/>";
            document.getElementById(srcdiv).innerHTML = "";
            document.getElementById(srcdiv).innerHTML = "<p class='groupresponcespan'>" + m + "<span  >" + v + "</span></p>";
        }
    };

}


function sendtogroup(value, group_id, sender_id, div_id)
{

    var gxml = new XMLHttpRequest();
    var url = "grouprequestmaneger?value=" + value + "&group_id=" + group_id + "&sender_id=" + sender_id;
    //alert(url);
    gxml.open("Get", url, true);
    gxml.send(null);
    document.getElementById(div_id).innerHTML = "";
    document.getElementById(div_id).innerHTML = "<img src='../../img/aj1.gif' style='width:20px ;height:10px; margin-top:6px; margin-left:10px; '/>";
    gxml.onreadystatechange = function() {
        if ((gxml.status == 200) && (gxml.readyState == 4))
        {
            document.getElementById(div_id).innerHTML = "";
            var nd = "<div  class='gbuttonC' > " +
                    "<img src='../../img/done.jpg' class='gsfimf'/> " +
                    "<p class='gsfpara'>DONE</p></div> ";

            document.getElementById(div_id).innerHTML = nd;

        }
    };
}


function scrollerviewer(x)
{//////alert(x);
    document.getElementById(x).style.overflowY = "scroll";
}
function scrollhider(x)
{
    document.getElementById(x).style.overflow = "hidden";
}
function questiontab(g_id)
{
    var url = "questionhandler?g_id=" + g_id;
    var win = window.open(url, '_self');
    win.focus();
}

function uploadProgress(evt) {

    if (evt.lengthComputable) {

        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('showpercent').innerHTML = percentComplete.toString() + '%';

        var progress_bar_inner = document.getElementById('progress_bar_inner');
        progress_bar_inner.style.width = Math.round(evt.loaded * 100 / evt.total) + '%';
    }
    else {
        document.getElementById('showpercent').innerHTML = 'unable to compute';
    }
}


//
//
//


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var globleid;
var type;
function filesender(id, name, val)
{
    globleid = id;
    type = val;

    document.getElementById('tpdiv').style.visibility = "visible";
    document.getElementById('namespan').innerHTML = name;
   // document.getElementById('ss').innerHTML = "Not now,But very soon!";
}

function clickr(A)
{
    // document.getElementById(A).click();
}
function file_uploader_click(file_id)
{

    var f = document.getElementById(file_id);
    f.value = "";
    f.click();

}
function name_giver()
{

    var file = document.getElementById('fileToUpload').files[0];

    if (file) {
        var fileSize = 0;
        if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

        var file_name = file.name;
        file_name = file_name.toString();
        var file_name_length = file_name.length;
        if (file_name_length > 20)
        {
            file_name = file_name.substring(0, 20);
            file_name = file_name.concat("...");
        }

        document.getElementById('filenamep').innerHTML = file_name + '(' + fileSize + ')';
    }
}

var xhrt;
function fileSelected() {
    // //alert("nabeel");

    var file = document.getElementById('fileToUpload').files[0];
    if (file) {
        if(file.size<=1024*1024){
        document.getElementById('imgg').style.visibility = "visible";
        document.getElementById('showpercent').innerHTML = "";
        document.getElementById('ss').innerHTML = "File sending plz wait.";
        var fd = new FormData();

        fd.append("fileToUpload", document.getElementById('fileToUpload').files[0]);

        xhrt = new XMLHttpRequest();
        xhrt.upload.addEventListener("progress", uploadProgress, false);

        xhrt.addEventListener("load", uploadComplete, false);

        xhrt.addEventListener("error", uploadFailed, false);

        xhrt.addEventListener("abort", uploadCanceled, false);
        var sub = document.getElementById('textd').value;
        var url = "fileuploadformail?subject=" + sub + "&to=" + globleid + "&type=" + type;
        xhrt.open("POST", url, true);
        xhrt.setRequestHeader("enctype", "multipart/form-data");

        xhrt.send(fd);
        xhrt.onreadystatechange = myfileresponce;
        }
        else
        {
            document.getElementById('ss').innerHTML = "File size must be less than 1MB";
        }
            
    }
    else
    {
        document.getElementById('ss').innerHTML = "Please choose file";
    }
}

function uploadProgress(evt) {

    if (evt.lengthComputable) {

        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        if(percentComplete==100)
        {
            document.getElementById('imgg').style.visibility = "hidden";
            document.getElementById('ss').innerHTML = "";
            document.getElementById('ss').innerHTML = "File has been sent";
            document.getElementById('showpercent').innerHTML = "";
        }
        document.getElementById('showpercent').innerHTML = percentComplete.toString() + '%';

        //var progress_bar_inner = document.getElementById('progress_bar_inner');
        progress_bar_inner.style.width = Math.round(evt.loaded * 100 / evt.total) + '%';
    }
    else {
        document.getElementById('showpercent').innerHTML = 'unable to compute';
    }
}

function myfileresponce()
{
    if (xhrt.readyState == 4 && xhrt.status == 200)
    {
        var m = xhrt.responseText;
      //  alert(m);
        document.getElementById('imgg').style.visibility = "hidden";
        document.getElementById('ss').innerHTML = "";
        document.getElementById('ss').innerHTML = "File has been sent";
        document.getElementById('showpercent').innerHTML = "";
    }
}
function closer(A)
{

    document.getElementById(A).style.visibility = "hidden";
}
function uploadComplete(evt) {

    // document.getElementById('inside_complitness').innerHTML = "Complete";

}

function uploadFailed(evt) {

    // document.getElementById('inside_complitness').innerHTML = "Failed";
}

function uploadCanceled(evt) {
    // document.getElementById('inside_complitness').innerHTML = "Canceled";


}