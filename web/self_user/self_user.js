/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var refresher = false;
var xml2;
var xml_demo;
var global_txt=3;
function object_creator() {
    return(new XMLHttpRequest());

}
var array_userid = [];
array_userid_top = 0;
var array_postid = [];
array_postid_top = 0;





var globalevaluate;
var global_topic;
function common_maximize(user_id, post_id, evaluate,topic)
{
    
    global_topic=topic;
    array_userid[array_userid_top++] = user_id;
    array_postid[array_postid_top++] = post_id;
    // ////////////alert(array_postid[array_postid_top-1]);
    // ////////////alert(array_userid[array_userid_top-1]);
    globalevaluate = evaluate;

   if(evaluate==1)
   {
    var max = document.getElementById('maximize_self_user').style; 
    max.height = "100%";
    max.width = "100%";
    max.visibility = "visible";
    max.zIndex="500";
    document.getElementById('maximize_self_user').style.marginTop=window.scrollY+"px";
   }
   else
   {
   var max = document.getElementById('maximize_self_user_edit').style;
    max.height = "100%";
    max.width = "100%";
    max.visibility = "visible";
    max.zIndex=500;    
    document.getElementById('maximize_self_user_edit').style.marginTop=window.scrollY+"px";   
   }
    document.getElementById('html').style.overflow="hidden";
    
    
   
    var image_uploader1 = document.getElementById('image_uploader1').style;
    image_uploader1.visibility = "visible";

//    var allcookies = document.cookie;
//    //////////alert("All Cookies : " + allcookies );
//
////    if (allcookies != "")
//    {
//        //////alert("All Cookies null nahi hai : " + allcookies );   
//        // Get all the cookies pairs in an array
//        cookiearray = allcookies.split(';');
//
//        //var k=0;
//        // Now take key value pair out of this array
//        for (var i = 0; i < cookiearray.length; i++)
//        {
//            //////alert("foor loop");
//            name = cookiearray[i].split('=')[0];
//            value = cookiearray[i].split('=')[1];
//            var actual_value = value.toString();
//
//
//            ////////////alert(" ARRAY top="+array_postid[array_postid_top-1]);
//
//            if (((name.trim()) == (array_postid[array_postid_top - 1].trim())) && (evaluate == 1))
//            {
//
////                ////////alert("from cookie");
//                changer1(actual_value);
//            }
//            else {
//                   
//               // ////////alert("else inside evalu="+name);
//                if ((name == array_postid[array_postid_top - 1]) && evaluate == 2)
//                {  
//                    //////alert("changer 2 call");
//                    setter_variable = 0;
//                    changer2(actual_value);
//                    break;
//                }
//                else
//                {
//                    //////alert("setter set");
//                    setter_variable = 1;
//                }
//
//            }
//
//        } //close for loop
//       
//    }

     
        var ob =new XMLHttpRequest();
        url = "SelfFullContent?user_id=" + escape(array_userid[array_userid_top - 1]) + "&post_id=" + escape(array_postid[array_postid_top - 1]);
        ob.open("Get", url, true);
        ob.send();
        ob.onreadystatechange =function (){
                                                if ((ob.readyState ===4) && (ob.status === 200))
                                                {
                                                    
                                                    var res = ob.responseText;
                                                    if (globalevaluate == 1)
                                                    {
                                                        changer1(res);   //max
                                                    }
                                                    else
                                                    {
                                                        changer2(res);   // edit
                                                    }
                                                }
      
                                           };
    

}

function changer1(res)
{
    var image_uploader1 = document.getElementById('image_uploader1').style;
    image_uploader1.visibility = "hidden";

    var s = [];
    s = res.split("#");

    var max_inside = document.getElementById('maximize_inside_self_user').style;
    max_inside.height = "580px";
    max_inside.width = "612px";
    document.getElementById('bbc').style.visibility = "visible";
    var v = document.getElementById('bottom_maximize_self_user').style;
    v.height = "532px";
    v.width = "585px";
    v.visibility = "visible";

    document.getElementById('bottom_maximize_self_user').innerHTML = s[2];

    
}

function downloader()
{
    var url="downloader?uiid="+array_userid[array_userid_top-1]+"&piid="+array_postid[array_postid_top-1];
    window.open(url,'_blank');
    
}


function changer2(res)
{
    var s = [];
    s = res.split("#");
    //alert("!!="+s[0]+"!!=\n"+s[1]+"!!=\n"+s[2]);
    var image_uploader1 = document.getElementById('image_uploader1').style;
    image_uploader1.visibility = "hidden";

    

    var max_inside = document.getElementById('maximize_inside_self_user_edit').style;
    max_inside.height = "570px";
    max_inside.width = "605px";
    max_inside.visibility = "visible";

    document.getElementById('close_EXIT_self_user_edit').style.visibility = "visible";

    var v = document.getElementById('bottom_maximize_self_user_edit').style;
    v.height = "460px";
    v.width = "565px";
    v.visibility = "visible";

    document.getElementById('ta_td_2').innerHTML = "<p style='margin: 0;padding: 0;margin-top: 5px;margin-left: 5px;'>"+global_topic+"</p>";
   
    var textarea = document.getElementById('self_user_textarea').style;
    textarea.height = "460px";
    textarea.width = "560px";
    textarea.visibility = "visible";
    document.getElementById('self_user_textarea').innerHTML = s[2];


    var submitdiv = document.getElementById('self_user_post_submit_div').style;
    submitdiv.height = "40px";
    submitdiv.width = "561px";
    submitdiv.visibility = "visible";

    var file_uploader_bar = document.getElementById('file_uploader_bar').style;
    file_uploader_bar.height = "28px";
    file_uploader_bar.width = "560px";
    file_uploader_bar.visibility = "visible";

    var self_user_post_submit_div_container = document.getElementById('self_user_post_submit_div_container').style;
    self_user_post_submit_div_container.height = "38px";
    self_user_post_submit_div_container.width = "560px";
    self_user_post_submit_div_container.visibility = "visible";


}


function abcclose_self_user() {
    var image_uploader1 = document.getElementById('image_uploader1').style;
    image_uploader1.visibility = "hidden";

    var max = document.getElementById('maximize_self_user').style;
    max.height = "0";
    max.width = "0";
    max.zIndex="0";
    max.visibility="hidden";
    document.getElementById('html').style.overflow="visible";

    var max_inside = document.getElementById('maximize_inside_self_user').style;
    document.getElementById('bottom_maximize_self_user').innerHTML = "";
    document.getElementById('bottom_maximize_self_user').style.visibility = "hidden";
    document.getElementById('bbc').style.visibility = "hidden";
    max_inside.height = "0";
    max_inside.width = "0";
   
    var file_uploader_bar = document.getElementById('file_uploader_bar').style;
    file_uploader_bar.height = "0";
    file_uploader_bar.width = "0";
    file_uploader_bar.visibility = "hidden";

}


function closeEdit() {
    var max = document.getElementById('maximize_self_user').style;
    max.height = "0";
    max.width = "0";
    max.zIndex="0";
    max.visibilityy = "hidden";
    
    document.getElementById('html').style.overflow="visible";

    var submitdiv = document.getElementById('self_user_post_submit_div').style;
    submitdiv.height = "0";
    submitdiv.width = "0";
    submitdiv.visibility = "hidden";


    var textarea = document.getElementById('self_user_textarea').style;
    textarea.height = "0";
    textarea.width = "0";
    textarea.visibility = "hidden";
    document.getElementById('self_user_textarea').innerHTML = "";


    var bottom_maximize = document.getElementById('bottom_maximize_self_user_edit').style;
    bottom_maximize.height = "0";
    bottom_maximize.width = "0";
    bottom_maximize.visibility = "hidden";


    var max_inside = document.getElementById('maximize_inside_self_user_edit').style;
    max_inside.height = "0";
    max_inside.width = "0";
    max_inside.visibility = "hidden";



    var max = document.getElementById('maximize_self_user_edit').style;
    max.height = "0";
    max.width = "0";
    max.visibility = "hidden";
    document.getElementById('close_EXIT_self_user_edit').style.visibility = "hidden";
    if (refresher == true)
            
            {
                refresher == false;
                location.reload();
            }


}



    function _color_changer(id1,id2,id3)
    {
      
       
       document.getElementById(id1).style.backgroundColor="#D3D3D3";
       document.getElementById(id2+1).style.backgroundColor="#D3D3D3";
       document.getElementById(id3+2).style.backgroundColor="#D3D3D3";
    }
    function _color_dechanger(id1,id2,id3)
    {
       
      
        document.getElementById(id1).style.backgroundColor="#F5F5F5";
        document.getElementById(id2+1).style.backgroundColor="#F5F5F5";
        document.getElementById(id3+2).style.backgroundColor="#F5F5F5";
    }    




//start setting---------------------------------------------------------------------
function veiw_setting_bar(id)
{
    var setting_container = document.getElementById(id).style;
    setting_container.height = "88px";
    setting_container.width = "100px";
    setting_container.visibility = "visible";
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function close_setting_bar(id) {
    //////////////alert("close hua");
    var setting_container = document.getElementById(id).style;
    setting_container.height = "0";
    setting_container.width = "0";
    setting_container.visibility = "hidden";

}
//delete onent
function delete_temp(piid)
{
    var a=piid+"container";
    var v=document.getElementById(a).style.visibility
    if(v=="hidden")
    {
    document.getElementById(a).style.visibility="visible";
    }
    else
    {
     document.getElementById(a).style.visibility="hidden";   
    }
      
}



function delete_comment(post_id) {
    var a=post_id+"container";
    document.getElementById(a).style.visibility="hidden";
    var xml_comment =new XMLHttpRequest();
    var url = "DeletePost?piid=" + escape(post_id);
    xml_comment.open("POST", url, true);
    xml_comment.send();
    xml_comment.onreadystatechange = function ()
                                            {
                                               
                                                if ((xml_comment.readyState=== 4) && (xml_comment.status === 200))
                                                {
//                                                    
//                                                    var res=xml_comment.responseText;
//                                                    //alert("from "+res);
                                                    location.reload(true);
                                                }


                                            };

}
function comment_changer() {

   

}


//
//function file_uploader_click(file_id)
//{  ////////////alert(123);
//    document.getElementById(file_id).click();
////    var file_uploader_bar=document.getElementById('file_uploader_bar');
////file_uploader_bar.style.visibility="visible";
////    
//}

var xhr;
var fd;
var file_value;
function fileSelected()
{
    var file = document.getElementById('fileToUpload').files[0];
    ////////////alert("file size is="+document.getElementById('fileToUpload').value);
    if (file) {
        var fileSize = 0;
        if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
        // reduce length----------
        var file_name = file.name;
        file_name = file_name.toString();
        var file_name_length = file_name.length;
        if (file_name_length > 10)
        {

            file_name = file_name.substring(0, 6);
            file_name = file_name.concat("...");
        }

        document.getElementById('fileName').innerHTML = file_name + '(' + fileSize + ')';

    }
}

function messageSender() {
    var xhr_1;
    
    var text_area = document.getElementById('self_user_textarea').innerHTML;
    xhr_1 = new XMLHttpRequest();
        var url1 = "EditPost?p_id=" + escape(array_postid[array_postid_top - 1])+ "&text_area_value=" + escape(text_area); 
        xhr_1.open("Post", url1, true);
        xhr_1.send();
        xhr_1.onreadystatechange = function (){
                                            if (xhr_1.status === 200 && xhr_1.readyState === 4)
                                            {
                                                
                                                var data = xhr_1.responseText;
                                                location.reload(true);
                                            }

                                              };

    


}


window.addEventListener("keypress",txt_listener);
function txt_listener(key)
{
    if(key.keyCode===13)
    {
       var foo=document.getElementById('inputsearch').value; 
                    if(foo!="")
                    {
                     itext_sender();
                    }
    }
    
}

function itext_sender()
{
   var itxt=document.getElementById('inputsearch').value;
   if(itxt==""){}
   else
   {
        global_txt=itxt;
        var url="SelfButton?itxt="+escape(itxt);
        var llm=new XMLHttpRequest();
        llm.open("POST",url,true);
        llm.send();
        llm.onreadystatechange=function (){     

                                            if((llm.status==200) && (llm.readyState==4))
                                            {
                                              var res=llm.responseText;
                                              //////////alert(res);
                                              document.getElementById("content").innerHTML=res;
                                            }
        
   
   
                                     };
   }
}


var win_h;
function height_setter(){
    //////////alert("hello");
    global_txt=3;
    win_h=window.innerHeight;
}

var first_time=true,f=true;;
function _scroller(){
    //alert(window.scrollY);
    var qql;
    var sc_top=document.getElementById("mybody").scrollTop;
    var sc_height=document.getElementById("mybody").scrollHeight;
     if(first_time===true)
         {
             document.getElementById("mybody").scrollTop=0;
             first_time=false;
             return;
         }
         
    if(sc_top+win_h>=sc_height-40)        
    {
    qql=new XMLHttpRequest();
    var ul="SelfUserScroll?itxt="+escape(global_txt);
        //alert(ul);
    qql.open("POST",ul,true);
    qql.send();
    qql.onreadystatechange=function (){
                                        if((qql.status===200)&&(qql.readyState===4))
                                        {  
                                            var res=qql.responseText;
                                           // alert(res);
                                            document.getElementById("content").insertAdjacentHTML("beforeend", res);
                                        }
                                        
                                      };
                                
    }                           
}

    