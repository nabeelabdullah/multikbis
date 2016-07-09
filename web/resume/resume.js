/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var os=[], pr=[],nameOS=[],namePR=[];
nameOS[1]="Windows";
nameOS[2]="Linux";
nameOS[3]="Mac";

namePR[1]="java";
namePR[2]="j2ee";
namePR[3]="c";
namePR[4]="c++";
namePR[5]=".net";
namePR[6]="php";
namePR[7]="sql";
namePR[8]="jquery";
namePR[9]="css";
namePR[10]="javascript";


var topos=0;
function clickr(A)
{
    
    document.getElementById(A).click();
}
vhosvalue=0;

function visible(A)
{
   if(vhosvalue==0){
    document.getElementById(A).style.visibility="visible";
    vhosvalue=1;}
    else
    {
        document.getElementById(A).style.visibility="hidden";
         vhosvalue=0;
        
    }

}
toppr=0;
function selecterPR(A)
{ 
    var find=ifExist(pr,A);
   
    if(find!=0)
    pr[find]=0;
    else
    pr[++toppr]=A;
    reseter(pr,'c_skill_pr',namePR,'divpr');
}

function selecterOS(A)
{ 
    var find=ifExist(os,A);
   
    if(find!=0)
    os[find]=0;
    else
    os[++topos]=A;
    reseter(os,'c_skill_os',nameOS,'divos');
}
function ifExist(ost,A)
{
    exist=0;
    var top=ost.length-1;
    for(var i=1;i<=top;i++)
    {
        if(ost[i]===A)
        exist=i; 
    }
    return exist;
}
function reseter(ost,textid,name,divname)
{
    var m="",first=false;
    var top=ost.length-1;
    
    for(var d=1;d<=top;d++)
        if(ost[d]!=0)
       { 
        if(first==false)
        {
             m=name[ost[d]];
             first=true;
         }
    else
        m+=","+name[ost[d]];
    }
    document.getElementById(textid).value=m;
    document.getElementById(divname).innerHTML=m;
  
}
function visiblehelperclose(A)
{
    alert("hello");
    document.getElementById(A).style.visibility="visible";
}
function universalhiderclose()
{ alert("hbody");
    document.getElementById('n1').style.visibility="hidden";
    document.getElementById('n2').style.visibility="hidden";
}
function checkvalidater(A)
{
   var d= document.getElementById(A).checked ;
   if(d!==true)
        document.getElementById('cskillinvalidate').style.visibility="visible";
    else
    {
         document.getElementById('cskillinvalidate').style.visibility="hidden";
    }
}
function fillCS(A)
{
   var d= document.getElementById(A).checked ;
    
   if(d!==true)
   {
     if(A==='cskos')
       document.getElementById('divos').style.visibility="hidden";;
    
      if(A==='cskps')
       document.getElementById('divpr').style.visibility="hidden";;
    
      if(A==='cskide')
       document.getElementById('c_skill_ide').disabled=true;
    
      if(A==='cskds')
       document.getElementById('c_skill_db').disabled=true;
    
       if(A==='skill_enable')
       {   
       document.getElementById('skilltext').disabled=true;}
    
}
    else
    {
        if(A==='cskos')
       document.getElementById('divos').style.visibility="visible";;
    
     if(A==='cskps')
       document.getElementById('divpr').style.visibility="visible";;
    
      if(A==='cskide')
       document.getElementById('c_skill_ide').disabled=false;
    
      if(A==='cskds')
       document.getElementById('c_skill_db').disabled=false;
    
      if(A==='skill_enable'){
           
       document.getElementById('skilltext').disabled=false;}
    
    
    }
}