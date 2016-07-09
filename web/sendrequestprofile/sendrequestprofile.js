var fxml;
function frequest_sender(A)
{
    var url = "searchedfriend?f_id=" + A;

    fxml = new XMLHttpRequest();

    fxml.open("Get", url, true);
    

   
    document.getElementById("reqfriend").innerHTML = "";
    
    document.getElementById("imgv").style.visibility = "visible";
   
    fxml.send(null);
    fxml.onreadystatechange = myfriendrequest_f1;
  
}
function myfriendrequest_f1()
{
 
    if ((fxml.status == 200) & (fxml.readyState == 4))
    {
        var data;
        var v = fxml.responseText;
        if (v == "nf")
            data = "Request Send";
        if (v == "af")
            data = "You are already friend";
        if (v == "ap")
            data = "Already Request Pending";
        document.getElementById("submitit").innerHTML = "";
        document.getElementById("submitit").innerHTML = "<a style='font-size:15px; color: blue'>" + data + "</a>"

    }
}