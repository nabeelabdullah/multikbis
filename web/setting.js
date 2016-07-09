/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function submit()
{

    var old = document.getElementById("old").value;
    var newpassword = document.getElementById("newpassword").value;
    var reinter = document.getElementById("reinter").value;
    if (old == "" || newpassword == "" || reinter == "")
    {
        document.getElementById("chsp").innerHTML = "<a style='color:red'>All field required</a>";
    }
    else if (newpassword === reinter)
    {
        var xml = new XMLHttpRequest();
        xml.open("Get", "ChangePassword?new=" + newpassword + "&old=" + old, true);
        document.getElementById("submitbutton").value = "submitting...";
        document.getElementById("submitbutton").onClick = function () {
        };
        xml.onreadystatechange = function () {
            if (xml.status == 200)
                if (xml.readyState == 4)
                {
                    
                    var responce = eval('(' + xml.responseText + ')');
                  
                    if (responce.status === "done")
                        document.getElementById("chsp").innerHTML = "<a style='color:green'>Password changed successfull</a>";
                    else if (responce.status === "passwordnotmatch")
                        document.getElementById("chsp").innerHTML = "<a style='color:red'>Password incurrect</a>";
                    else if (responce.status === "logout")
                        document.getElementById("chsp").innerHTML = "<a style='color:red'>You are log out</a>";
                    else
                        document.getElementById("chsp").innerHTML = "<a style='color:red'>Fail!</a>";
                    document.getElementById("submitbutton").value = "Submit";
                    document.getElementById("submitbutton").onClick = function () {
                        submit();
                    };
                }
        };
        xml.send();

    }
    else
        document.getElementById("chsp").innerHTML = "<a style='color:red'>Password not match</a>";

}