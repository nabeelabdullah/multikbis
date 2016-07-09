
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * akhtar
 */
//function object_creator() 
//{
//    return(new XMLHttpRequest());
//}
var ran=0;

function txtfocus()
{
    
    ran=parseInt((Math.random()*100000),10);
//    ////alert(ran);
//    ////alert(count+''+ran);
    document.getElementById('to_text').focus();
}
function myEvent()
{
    if(resp && count<3)
        {
           
        var st=document.getElementById("pattach_right").style;
        st.color='white';
        st.backgroundColor='#a09a9a';
        st.cursor='pointer';
        }
    
}
function yourEvent()
{
    var st=document.getElementById("pattach_right").style;
        st.color='#6c6060';
        st.backgroundColor='#ececec';
        st.cursor='default';
}
function myEvent2()
{
    if(resp)
        {
        var st=document.getElementById("spost").style;
        st.color='white';
        st.backgroundColor='#c7161c';
        st.cursor='pointer';
        st.boxShadow='1px 1px 1px 1px #9b060b' ;
        }
    
}
function yourEvent2()
{
    var st=document.getElementById("spost").style;
        st.color='#6c6060';
        st.backgroundColor='#9b060b';
        st.boxShadow='0px 0px 0px transparent' ;
}

function lihgt_opnr()
{
    var im="<img src='../../image/waitingfile.gif' height='40' width='40' style=' float: left;margin-left: 75px;'/>";
    document.getElementById('f_central').style.visibility="visible";
    document.getElementById('f_central').innerHTML=im;
    
    var p_light=document.getElementById('p_light').style;
    p_light.visibility="visible";
    
    var l_container=document.getElementById('l_container').style;
    l_container.visibility="visible";
    
    var l_header=document.getElementById('l_header').style;
    l_header.visibility="visible";
    
    var p_light=document.getElementById("l_footer").style;
    l_footer.visibility="visible";
   
       
}

var reset=true;
function close_bar()
{
   var p_light=document.getElementById('p_light').style;
    p_light.visibility="hidden";
    
    var l_container=document.getElementById('l_container').style;
    l_container.visibility="hidden";
   
    
    var l_header=document.getElementById('l_header').style;
    l_header.visibility="hidden";
   
    var l_footer=document.getElementById("l_footer").style;
    l_footer.visibility="hidden";
    
     var f_central=document.getElementById("f_central").style;
     f_central.visibility="hidden";
     location.reload();
     reset=true;
     
    
}

function file_uploader_click_2(file_id)
{
    if(resp && count<3)
    document.getElementById(file_id).click();
}


window.addEventListener("keypress",submiter);
function submiter(key){
    if(key.keyCode==13 && reset)
    {
       var text_value = document.getElementById('to_text').value;
       var text_area =document.getElementById('nptext_area').value;
        if(text_area=="" || text_value=="")
        {}
        else{
            messageSubmitter();
            }
    }
    
    
}

var valid=true;
var fileName="fileName_1";
var progressNumber="progressNumber_1";
var inside_complitness="inside_complitness_1";
var progress_bar_inner="progress_bar_inner_1";
var count=1;
var resp=true;
var xh = new XMLHttpRequest();
function fileSelected_2() 
{
if(resp)
 {
    resp=false;
    if(count==2)
   {
    fileName="fileName_"+count;
    progressNumber="progressNumber_"+count;
    inside_complitness="inside_complitness_"+count;
    progress_bar_inner="progress_bar_inner_"+count;   
   }
//    var xh = new XMLHttpRequest();
    var file = document.getElementById('fileToUpload_2').files[0];
    if(file.length === 0)
        return ;
    if (count<=2) 
    {
        
        document.getElementById("pattach").style.borderColor="rgba(0,0,0,0.05)";
        document.getElementById("pattach").insertAdjacentHTML("beforeend","<div class='pattach_left' id='p_lt"+count+"'><div id='fileName_"+count+"' class='fname'></div><div id='progressNumber_"+count+"' class='pnumber'></div><div id='complitness_2'><div id='inside_complitness_"+count+"'></div></div><div id='progress_bar_2' class='pb2'><div id='progress_bar_inner_"+count+"' class='pbarinner'></div></div><div id='progress_bar_close_2' class='pbarclose' onclick=cancelUpload('p_lt"+count+"','inside_complitness_"+count+"',"+count+");><img src='image/close.ico' height='18' width='18'/></div></div>");
        var fileSize = 0;
        if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
        var file_name = file.name;
        file_name = file_name.toString();
        var file_name_length = file_name.length;
        if (file_name_length > 13)
        {
            
            file_name = file_name.substring(0, 13);
            file_name = file_name.concat("...");
        }
        document.getElementById(fileName).innerHTML = file_name + '(' + fileSize + ')';
        fileSender(xh);
    }
    count++;
  }
}

function fileSender(xh)
{
    
                                var fd2 = new FormData();
                                fd2.append("fileToUpload_2", document.getElementById('fileToUpload_2').files[0]);
                                xh.upload.addEventListener("progress", uploadProgress_2, false);
                                xh.addEventListener("load", uploadComplete_2, false);
                                xh.addEventListener("error", uploadFailed_2, false);
                                xh.addEventListener("abort", uploadCanceled_2, false);
                                var url = "NewPostFile?random=" + escape(ran);  
                                xh.open("POST", url, true);
                                xh.setRequestHeader("enctype", "multipart/form-data");
                                xh.send(fd2);
                                xh.onreadystatechange = function ()
                                {
                                    
                                    if (xh.status == 200 && xh.readyState == 4)
                                    {   
                                        var data = xh.responseText;
                                        //////alert(data);
                                        
                                    }

                                };
                           

                             
}


function messageSubmitter()
{
   
    reset=false;
    for (instance in CKEDITOR.instances) {
                    CKEDITOR.instances[instance].updateElement();
                }
    var text_value = document.getElementById('to_text').value;
    var text_area =document.getElementById('nptext_area').value;
                    if(text_area=="" || text_value=="")
                    {}
            else
            {
                   if(resp)
                   {
                        
                         lihgt_opnr();
                                var url = "NewPost?random=" + escape(ran) + "&text_area_value=" + escape(text_area) + "&text_value=" + escape(text_value);
                                //////alert(url);
                                var xhs = new XMLHttpRequest();
                                xhs.open("Post", url, true);
                                xhs.send();
                                xhs.onreadystatechange = function ()
                                {
                                    if (xhs.status == 200 && xhs.readyState == 4)
                                        {   
                                            
                                            var data = xhs.responseText;
                                            //////alert(data);
                                            document.getElementById('f_central').innerHTML="";  //to hide gif
                                            if(data=="1")
                                            {
                                                //////alert(1);
                                            document.getElementById('f_central').innerHTML="<p style='margin-left:30px;text-align: center;color:black; margin-top: 10px;font-family: 'Hind', sans-serif;font-size: 20px;'>Post has been sent</p>"; 
                                            }
                                            else
                                            {
                                                //////alert(2);
                                               document.getElementById('f_central').innerHTML="<p style='margin-left:30px;text-align: center;color:black; margin-top: 10px;font-family: 'Hind', sans-serif;font-weight: bold;font-size: 20px;'> An Error Occured</p>";  
                                            }
                                        } 
                                };

                            
                    }
                    
         }
    

}


function cancelUpload(A,id,which)
{
    
    if(!resp)
        {
            ////alert(1);
        uploadCanceled_2('abort');
        document.getElementById(A).style.opacity= '.4';
        document.getElementById(id).innerHTML = "Canceled";
        }
        else{
                ////alert(2);
                var xr=new XMLHttpRequest();
                var url="UploadCancel?which="+escape(which);
                xr.open("post",url,true);
                xr.send();
                ////alert(url);
                xr.onreadystatechange=function ()
                {
                     ////alert(10);
                    if(xr.readyState==4 && xr.status==200)
                        {
                            ////alert(20);
                            var data=xr.responseText;
                            
                            if(data=="1")
                                {
                                    uploadCanceled_2('abort');
                                    document.getElementById(A).style.opacity= '.4';
                                    document.getElementById(id).innerHTML = "Canceled";  
                                }
                        }
                };
        }
}



function uploadProgress_2(evt) {
    resp=false;
    document.getElementById(inside_complitness).innerHTML = "Progress";
    if (evt.lengthComputable) {

        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById(progressNumber).innerHTML = percentComplete.toString() + '%';

        var progress_bar_inr = document.getElementById(progress_bar_inner);
        progress_bar_inr.style.backgroundColor='#00cccc';
        progress_bar_inr.style.width = Math.round(evt.loaded * 100 / evt.total) + '%';
    }
    else {
        //document.getElementById(progressNumber).innerHTML = 'unable to compute';
    }
}

function uploadComplete_2(evt) {
    /* This event is raised when the server send back a response */
    resp=true;
    document.getElementById(inside_complitness).innerHTML = "Completed";
    ////////////////alert(evt.target.responseText);
}

function uploadFailed_2(evt) {
    // //////////////alert("There was an error attempting to upload the file.");
    resp=true;
    document.getElementById(inside_complitness).innerHTML = "Failed";
}

function uploadCanceled_2(evt) {
    ////alert("cancel");
    xh.abort();
    resp=true;
    
   
    //////////////alert("The upload has been canceled by the user or the browser dropped the connection.");

}

