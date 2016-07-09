/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function hide_show()
{
    document.getElementById("changimgdiv").style.visibility = "visible";
}
function clickr(A)
{
    ////alert("hiii");
    document.getElementById(A).click();
    var v = document.getElementById("fileu").value;
    ////alert(v);
    document.getElementById("files").innerHTML = v;
   // //alert(v);
}



function file_uploader_click(file_id)
{  

    var f = document.getElementById(file_id);
    f.value = "";
    f.click();

}

var xhr;
var fd;

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
        if (file_name_length > 10)
        {
            file_name = file_name.substring(0, 10);
            file_name = file_name.concat("...");
        }

        document.getElementById('fileName').innerHTML = file_name + '(' + fileSize + ')';
    }
}


function fileSelected() {
   // //alert("nabeel");
    document.getElementById('uploading').innerHTML = "";
    document.getElementById('uploading').innerHTML = "uploading...";
    var file = document.getElementById('fileToUpload').files[0];
    if (file) {
        var fd = new FormData();

        fd.append("fileToUpload", document.getElementById('fileToUpload').files[0]);

        xhr = new XMLHttpRequest();
        xhr.upload.addEventListener("progress", uploadProgress, false);

        xhr.addEventListener("load", uploadComplete, false);

        xhr.addEventListener("error", uploadFailed, false);

        xhr.addEventListener("abort", uploadCanceled, false);

        var url = "FileUpload";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("enctype", "multipart/form-data");

        xhr.send(fd);
        xhr.onreadystatechange = mytemp;

    }
}
//
 var data;
function mytemp()
{
    if (xhr.status == 200 && xhr.readyState == 4)
    {
        data = xhr.responseText;
        
      // alert(data);
//        var v = "<img src='" + data + "' id='divimg'/>";
        document.getElementById('photodiv').innerHTML = "";
        document.getElementById('photodiv').innerHTML = "<img src='../../img/aj1.gif' id='divimg' style='width:10px;'/>";
        setTimeout(imgwaiter,2000);
       
        document.getElementById('uploading').innerHTML = "";
        document.getElementById('uploading').innerHTML = "done";
    }
}
function imgwaiter()
{
        var v = "<img src='" + data + "' id='divimg'/>";
        
        document.getElementById('photodiv').innerHTML = "";
      
        document.getElementById('photodiv').innerHTML = v;
}
function uploadProgress(evt) {

    if (evt.lengthComputable) {

        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';

        var progress_bar_inner = document.getElementById('progress_bar_inner');
        progress_bar_inner.style.width = Math.round(evt.loaded * 100 / evt.total) + '%';
    }
    else {
        document.getElementById('progressNumber').innerHTML = 'unable to compute';
    }
}

function uploadComplete(evt) {

    document.getElementById('inside_complitness').innerHTML = "Complete";

}

function uploadFailed(evt) {

    document.getElementById('inside_complitness').innerHTML = "Failed";
}

function uploadCanceled(evt) {
    document.getElementById('inside_complitness').innerHTML = "Canceled";


}