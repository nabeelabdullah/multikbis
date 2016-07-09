/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function unfriend_handler(A)
{
    var xml = new XMLHttpRequest();
    var url = "unfriend?f_id=" + A;
    xml.open("Get", url, true);
    xml.send();
    document.getElementById("unfriend").innerHTML = "";
    document.getElementById("imgv").style.visibility = "visible";
    xml.onreadystatechange = function()
                             {
                                    if ((xml.status == 200) & (xml.readyState == 4))
                                    {
                                        var data;
                                        var v = xml.responseText;
                                        if (v == "1")
                                            data = "Unfriend done";
                                        if (v == "0")
                                            data = "you was not friend";
                                        document.getElementById("unftd").innerHTML = "";
                                        document.getElementById("unftd").innerHTML = "<a style='color:blue;font-size:14px;'>" + data + "</a>";

                                    }
                             };
}
