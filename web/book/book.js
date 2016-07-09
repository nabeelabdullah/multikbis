/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function iu_sender()
{
    alert(123);
    window.Open("http://www.integraluniversity.ac.in/","_blank");
}


function input_enable()
{
    var selector=document.getElementById('selector').style;
    selector.visibility="visible";   
    
}

var global;
var search_text;
var check=false;
function value_valid(valued){
    check=true;
    if(valued==1)
    {
        
        global="title";
        document.getElementById('search_text').placeholder="ENTER BOOK TITLE";
        document.getElementById('search_text').focus();
        document.getElementById('selector').style.visibility="hidden";
       
    }
    if(valued==2)
    {
       
        global="author";
        document.getElementById('search_text').placeholder="ENTER AUTHOR NAME";
        document.getElementById('search_text').focus();
        document.getElementById('selector').style.visibility="hidden";
       
    }
    if(valued==3)
    {  
        
        global="catagory";
        document.getElementById('search_text').placeholder="ENTER CATAGORY";
        document.getElementById('search_text').focus();
        document.getElementById('selector').style.visibility="hidden";
       
    }
    
}

window.addEventListener("keypress",value_takertemp);
function value_takertemp(key)
{  
    if(key.keyCode == 13)
        value_taker1();      
}

function value_taker1(){
    search_text=document.getElementById('search_text').value;
    if(search_text=="")
    {
        return ;
    }
    if((search_text!="") &&(check==true))
    {
        
        document.getElementById('search_text').placeholder="";
        document.getElementById('selector').style.visibility="hidden";
        var url="SearchingBook?search_text="+escape(search_text)+"&global="+escape(global);
        //alert(url);
        var xml1=new XMLHttpRequest();
        xml1.open("POST",url,true);
        xml1.send();
        xml1.onreadystatechange=function(){
                                                
                                                if((xml1.readyState===4) && (xml1.status===200))
                                                {
                                                    
                                                    var res=xml1.responseText;
                                                    document.getElementById('container').innerHTML=res;
                                                   
                                                }
                                         };
         }

    }



var win_h;
function height_setter(){
    check=false;
    win_h=window.innerHeight;
}

var first_time=true,f=true;;
function _scroller(){
    
if(check===true)
{    
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
    var qql=new XMLHttpRequest();
    var url="Book_search?search_text="+escape(search_text)+"&global="+escape(global);
     //alert(url);
    qql.open("POST",url,true);
    qql.send();
    qql.onreadystatechange=function (){
                                        if((qql.status===200)&&(qql.readyState===4))
                                        {  
                                            var res=qql.responseText;
                                            document.getElementById("container").insertAdjacentHTML("beforeend",res);

                                        }
                                        
                                      };
                                
    }                           
}

}