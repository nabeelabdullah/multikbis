/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var value;
function opennewtabforprofile(id, nam)
{
    var url = "simpleprofilepage_handler?user_id=" + id + "&name=" + nam;

    //  var win = window.open(url, '_blank');
    var win = window.open(url, '_self');

    win.focus();
}
function gohome()
{ //var url="";
    window.open("GoHome","_self");
}
function questionpage(q_id)
{
    var url="questionhandler?g_id="+q_id+"&top="+window.screenTop;;
    window.open(url,"_self");
}
function scroller()
{
   
    if(window.scrollY<=60){
     document.getElementById('subheader1').style.visibility="hidden";}
 else
      document.getElementById('subheader1').style.visibility="visible";
}
function temp()
{   // //alert(v);
//    var assemble;
//
//
//    var d = "<div class='second'>" +
//            "<img src='img/images1.jpeg' class='qustion_img'>" +
//            "</div>";
//
//
//    var e = "<p>" + document.getElementById("textvalue").value;
//    +"</p>";
//    var a = "<a class='asked_by'>answered by you</a>";//+"<a class='answerp'>no answer</a>";
//    assemble = d + e + a;
//    var v = "<div class='mydiv'>" + assemble + "</div>";
//    //  //alert(v);
//    document.getElementById("container").insertAdjacentHTML("beforeend", v);
//
//

}
//function content()
//{
//    data = "<ul>";
//    var d = document.getElementById("textvalue").value;
//    var k = d.split('\n');
//    var i = 0;
//    for (i = 0; i < k.length; i++)
//    {
//        data = data + "<li>" + k[i] + "</li>";
//    }
//    data = data + "</ul>";
//    value = data;
//    data = data.replace(/\s\s/g, '&nbsp;&nbsp;');
//
//}
var xlr;
function callajax(g_id, q_id) {


    document.getElementById("gid").value = g_id;
    document.getElementById("qid").value = q_id;

    document.getElementById("submitme").click();

}
function callajaxold(g_id, q_id)
{
    for (instance in CKEDITOR.instances) {
        CKEDITOR.instances[instance].updateElement();
    }

    var newdata = document.getElementById("textvalue").value;

    var url = "answerstorage?group_id=" + g_id + "&content=" + newdata + "&q_id=" + q_id;
    alert(url);
    xlr = new XMLHttpRequest();
    xlr.open("Get", url, true);
    xlr.send(null);
    xlr.onreadystatechange = abcajax;

}
function abcajax()
{
    ////alert("dddd");


    if (xlr.readyState == 4)
    {
        if (xlr.status == 200)
        {
            var res = xlr.responseText;
            ////alert(res);
            if (res == 'done')
                temp();

            //document.getElementById("clickme").style.visibility="visible";
            // document.getElementById("forimg").style.visibility="hidden";

        }
    }
}