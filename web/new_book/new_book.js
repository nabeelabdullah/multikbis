/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function  div_col_changer(ip)
{
    if(ip=="content_6_right")
        {
         document.getElementById("alert_no").style.visibility="visible";
        }
    document.getElementById(ip).style.backgroundColor="#F0F0F0";
}
function  div_col_unchanger(ip)
{
    if(ip=="content_6_right")
        {
         document.getElementById("alert_no").style.visibility="hidden";
        }
     document.getElementById(ip).style.backgroundColor="white";
}
function opn_max()
{
    document.getElementById('content_2_right').style.backgroundColor="#F0F0F0";
    document.getElementById('my_body').style.overflow='hidden';
    document.getElementById('maximize').style.visibility='visible';
    
    
}
function max_hider() {
    document.getElementById('inside_cont_rgt').style.visibility='hidden';
    document.getElementById('my_body').style.overflow='visible';
    document.getElementById('maximize').style.visibility='hidden';
}
function inside_cont_rgt_opn(){
    document.getElementById('inside_cont_rgt').style.visibility='visible';
}

function  con_setter(lft)
{
    max_hider();
     var con=document.getElementById(lft).innerHTML;
     if(lft==="rgt_p_1" || lft==="rgt_p_2"||lft==="rgt_p_3"||lft==="rgt_p_4")
      con="Educationals >"+con;
     document.getElementById('ip2_inside').innerHTML=con;
    
}



function fileToUpload_clk(img_)
{
    img_div=img_;
    document.getElementById('fileToUpload').click();
}

var fd2;
var counter=0;
function file_demo()
{                   
    document.getElementById(img_div).innerHTML=" <img src='../../image/waitingfile.gif' height='40' width='40' style='margin-left:30px; margin-top:20px;'>";
                        if(counter===0)
                            fd2= new FormData();
                         var filesSelected = document.getElementById("fileToUpload").files;
                         fd2.append(counter++, filesSelected[0]);
                       
                        if (filesSelected.length > 0)
                        {       
                                var fileToLoad = filesSelected[0];
                                if (fileToLoad.type.match("image.*"))
                                {
                                    var fileReader = new FileReader();
                                    fileReader.onload = function(fileLoadedEvent) 
                                    {
                                       
                                        document.getElementById(img_div).innerHTML="<img src="+fileLoadedEvent.target.result+" height='100%' width='100%'/>";
                                    };
                                    fileReader.readAsDataURL(fileToLoad);
                                }
                               
                        }
                        
}                        
    





window.addEventListener("keypress",value_takertemp);
function value_takertemp(key)
{  
    if(key.keyCode == 13)
        value_sender();      
}

function value_sender()
{
    var a,b,c,d,e,f,g;
    
    
     a=document.getElementById('ip1').value;
     b=document.getElementById('ip2_inside').innerHTML;
     c=document.getElementById('ip3').value;
     d=document.getElementById('ip4').value;
     e=document.getElementById('ip5').value;
     f=document.getElementById('ip8').value;
     g=document.getElementById('ip6').value;
     h=document.getElementById('ip9').value;
   
         if(a==="")
         {
             document.getElementById('content_1_right').style.backgroundColor="#FFDCDC";
             return ;
         }
         if(b==="")
         {
             document.getElementById('content_2_right').style.backgroundColor="#FFDCDC";
             return ;
         }
         if(c==="")
         {
             document.getElementById('content_3_right').style.backgroundColor="#FFDCDC";
             return ;
         }
         if(b==="")
         {
             document.getElementById('content_4_right').style.backgroundColor="#FFDCDC";
             return ;
         }
         if(e==="")
         {
             document.getElementById('content_5_right').style.backgroundColor="#FFDCDC";
             return ;
         }
          if(f==="")
         {
             document.getElementById('content_8_right').style.backgroundColor="#FFDCDC";
             return ;
         }
          if(g==="")
         {
             document.getElementById('content_6_right').style.backgroundColor="#FFDCDC";
             return ;
         }
          if(h==="")
         {
             document.getElementById('content_9_right').style.backgroundColor="#FFDCDC";
             return ;
         }
       document.getElementById('res_light').style.marginTop=scrollY+"px";
       document.getElementById('res_light').style.visibility="visible";
       document.getElementById('gif').innerHTML="<img src='img/waitingfile.gif' height='100%' width='100%'/>";
       document.getElementById('my_body').style.overflow='hidden';
    var xml2=new XMLHttpRequest();
    var validator=2;
    if(counter>0)
        {
        counter=0;
        validator=1;
        xml2.upload.addEventListener("progress", uploadProgress_2, false);
        xml2.addEventListener("load", uploadComplete_2, false);
        xml2.addEventListener("error", uploadFailed_2, false);
        xml2.addEventListener("abort", uploadCanceled_2, false);
        var url="NewBook?title="+escape(a)+"&catagory="+escape(b)+"&author="+escape(c)+"&price="+escape(d)+"&des="+escape(e)+"&mail="+escape(f)+"&mob="+escape(g)+"&address="+escape(h)+"&validator="+escape(validator);
        xml2.open("POST", url, true);
        xml2.setRequestHeader("enctype", "multipart/form-data");
        xml2.send(fd2);
        xml2.onreadystatechange=function()                      
                               {
                                    if(xml2.status===200 && xml2.readyState===4)
                                    {
                                        f2d=null;
                                    var res=xml2.responseText;
                                    var ig=[];
                                    ig=document.getElementsByClassName("img");
                                     for( var i=0;i<ig.length;i++)
                                     {
                                         ig[i].innerHTML="<p style='text-align: center; margin-top: 20px;'><img src='../../image/book.png' height='40' width='50'/></p>'";
                                     }
                                    document.getElementById('gif').innerHTML="";
                                    document.getElementById('my_body').style.overflow='visible';
                                    document.getElementById('res_light').style.visibility="hidden";

                                    }
       
                                };
     
        }
       else
       {
       var url="NewBook?title="+escape(a)+"&catagory="+escape(b)+"&author="+escape(c)+"&price="+escape(d)+"&des="+escape(e)+"&mail="+escape(f)+"&mob="+escape(g)+"&address="+escape(h)+"&validator="+escape(validator);;
       xml2.open("POST",url,true);
       xml2.send();
       xml2.onreadystatechange=function()                      
                               {
                                    if(xml2.status===200 && xml2.readyState===4)
                                    {
                                        f2d=null;
                                    var res=xml2.responseText;
                                    var ig=[];
                                    ig=document.getElementsByClassName("img");
                                     for( var i=0;i<ig.length;i++)
                                     {
                                         ig[i].innerHTML="<p style='text-align: center; margin-top: 20px;'><img src='../../image/book.png' height='40' width='50'/></p>'";
                                     }
                                    document.getElementById('gif').innerHTML="";
                                    document.getElementById('my_body').style.overflow='visible';
                                    document.getElementById('res_light').style.visibility="hidden";

                                    }
       
                                };


       }          
}

function uploadProgress_2(evt) {
    document.getElementById('inside_complitness_2').innerHTML = "Progress";
    if (evt.lengthComputable) {

        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber_2').innerHTML = percentComplete.toString() + '%';

        var progress_bar_inner = document.getElementById('progress_bar_inner_2');
        progress_bar_inner.style.backgroundColor='#00cccc';
        progress_bar_inner.style.width = Math.round(evt.loaded * 100 / evt.total) + '%';
    }
    else {
        document.getElementById('progressNumber_2').innerHTML = 'unable to compute';
    }
}

function uploadComplete_2(evt) {
    /* This event is raised when the server send back a response */
    document.getElementById('inside_complitness_2').innerHTML = "Complete";
    //////////alert(evt.target.responseText);
}

function uploadFailed_2(evt) {
    // ////////alert("There was an error attempting to upload the file.");
    document.getElementById('inside_complitness_2').innerHTML = "Failed";
}

function uploadCanceled_2(evt) {
    document.getElementById('inside_complitness_2').innerHTML = "Canceled";
    ////////alert("The upload has been canceled by the user or the browser dropped the connection.");

}

