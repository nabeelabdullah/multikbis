/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function onsubmitclick()
{
    var p = document.getElementById("p").value;
    var q = document.getElementById("rp").value;
    if(p=="" || q=="")
        {
            document.getElementById("myspan").innerHTML="Fields shoud not be Empty";
            return ;
        }
    if (p !== q)
    {
        document.getElementById("myspan").innerHTML="Re-Enter password is not same";
    }
    else 
    {
        document.getElementById("sub").click();
    }

}
