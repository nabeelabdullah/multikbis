/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var xmlr
function request_cc(V, I)
{
    var url = "confcnl?value=" + V + "&f_id=" + I;

    xmlr = new XMLHttpRequest();
    xmlr.open("Get", url, true);
    xmlr.send(null);
    document.getElementById("c1").innerHTML = "";
    document.getElementById("c2").innerHTML = "";
    document.getElementById("imgv").style.visibility = "visible";
    xmlr.onreadystatechange = onready;

}
function onready()
{
    if ((xmlr.status == 200) & (xmlr.readyState == 4))
    {
        var data;
        var v = xmlr.responseText;

        if (v == "0")
            data = "you have canceled this request before";
        if (v == "2")
            data = "you have confurmed this request before";
        if (v == "4")
            data = "you are now friend";
        if (v == "5")
            data = "request cancel Successful";

        document.getElementById("submitit").innerHTML = "";
        document.getElementById("submitit").innerHTML = "<a style='color:blue;font-size:16px;'>" + data + "</a>";


    }
}