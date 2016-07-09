/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var uid=[];
var pid=[];
var up_max=0;
var setter=false;
var global_txt=3;

function objectCreator()
{
    return new XMLHttpRequest();
}
function  txt_sender(too,foo)
{
    uid[0]=too;
    pid[0]=foo;
    setter=true;
    window.addEventListener("keypress",c_sender);
}
function txt_setter(){
    setter=false;
}

function c_sender(key)
{  
    var tx=document.getElementById(pid[0]).value;
    if(key.keyCode===13 && setter==true && tx!="")
    {
        setter=false;
//        var p=pid[0];
//        alert(p);
//        p=p+"txt";
//        alert(p);
var z=pid[0]+"cmt_f";
var w=document.getElementById(z).innerHTML;
var h=parseInt(w);
document.getElementById(z).innerHTML=h+1;
        document.getElementById(pid[0]+"txt").innerHTML="<img src='../../image/uploader2.gif' height='100%' width='100%'>";
    var mml=objectCreator();
        var url="new_comment?txt_val="+escape(tx)+"&uid="+escape(uid[0])+"&pid="+escape(pid[0]);
        //alert(url);
        mml.open("GET",url,true);
        mml.send();
        mml.onreadystatechange=function()
{ 
   
    if((mml.readyState===4) && (mml.status===200 ))
    { 
     var res=mml.responseText;
    
     document.getElementById(pid[0]+"txt").innerHTML="";
     document.getElementById(pid[0]+"txt").blur();
//   document.getElementById('beforeend').insertAdjacentHTML("beforebegin",res);
     document.getElementById(pid[0]+"cmt").insertAdjacentHTML("afterbegin",res);
    
    }
    
}   ;    
    }
        
}

var n_setter=false;
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
        var url="PostButton?itxt="+escape(itxt);
        var llm=objectCreator();
        llm.open("POST",url,true);
        llm.send();
         //alert(url);
        llm.onreadystatechange=function (){     

                                            if((llm.status==200) && (llm.readyState==4))
                                            {
                                              var res=llm.responseText;
                                              //alert(res);
                                              document.getElementById("container").innerHTML=res;
                                            }
        
   
   
                                     };
   }
}

function like_sender(piid,uiid){
       
        var y=piid+"like_text";
        var o=document.getElementById(y).style.color;
        var s=o;
    if(s=="red"){}
    else{
        document.getElementById(y).style.color="red";
        var t=piid+"like";
        var z=document.getElementById(t).innerHTML;
        var u=parseInt(z);
        var p=u+1;
        document.getElementById(t).innerHTML=p;
        var l="like_post?piid="+escape(piid)+"&uiid="+escape(uiid);
    var nnl=objectCreator();
        nnl.open("POST",l,true);
        nnl.send();
        nnl.onreadystatechange=function (){
                                      if((nnl.status===200)&& (nnl.readyState===4))
                                            {
                                               
                                               
                                               var rws=nnl.responseText;
                                              // alert(rws);
                                               
                                            } 
                                      
                                     };
        }                             
                                     
}



function cmt_like_sender(uiid,piid,ciid)
{
    var z=ciid.trim()+"cmt_likes";
    var k=ciid.trim()+"cmt_likes_para";
    var i=document.getElementById(k).style.color;
    if(i=="red"){ }
    else{       
                var t=document.getElementById(z).innerHTML;
                var u=parseInt(t);
                var p=u+1;
                document.getElementById(z).innerHTML=p;
                document.getElementById(k).style.color="red";
                
                var r="like_comment?uiid="+escape(uiid)+"&piid="+escape(piid)+"&ciid="+escape(ciid);
//                alert(r);
            var ppl=objectCreator();
                ppl.open("POST",r,true);
                ppl.send();
                ppl.onreadystatechange=function(){
                                                    if((ppl.readyState===4) && (ppl.status===200))
                                                    {
                                                        var u=ppl.responseText;
                                                        
                                                    }


                                                 };
    
    
    
    }
    
}   

var win_h;
function height_setter(){
   // alert("hello");
    global_txt=3;
    win_h=window.innerHeight;
}

var first_time=true,f=true;;
function _scroller(){
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
    qql=objectCreator();
    var ul="post_scroll?itxt="+escape(global_txt);
    qql.open("POST",ul,true);
    qql.send();
    qql.onreadystatechange=function (){
                                        if((qql.status===200)&&(qql.readyState===4))
                                        {  
                                            var res=qql.responseText;
                                            //alert(res);
                                            document.getElementById("container").insertAdjacentHTML("beforeend",res);

                                        }
                                        
                                      };
                                
    }                           
}



    
