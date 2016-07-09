/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var t=[4];
var btm=2;
var t_top=2;
var one=1;

function img_chgr(uiid,biid,valid)
{
    if(one==1)
        {
            t[0]="<img src='Full_book_image_manager?uiid="+uiid+"&biid="+biid+"&vall=0' height='100%' width='100%'/>";   
            t[1]="<img src='Full_book_image_manager?uiid="+uiid+"&biid="+biid+"&vall=1' height='100%' width='100%'/>";   
            t[2]="<img src='Full_book_image_manager?uiid="+uiid+"&biid="+biid+"&vall=2' height='100%' width='100%'/>";   
            t[3]="<img src='Full_book_image_manager?uiid="+uiid+"&biid="+biid+"&vall=3' height='100%' width='100%'/>";   
        one=10;
        }
   
    if(valid==="1")
        {
                if(btm>3)
                btm=0;
                document.getElementById("photo_lft_2").innerHTML=document.getElementById("photo_rgt_2").innerHTML; 
                document.getElementById("photo_rgt_2").innerHTML=t[btm];
                btm=btm+1;
          
        }
        else
        {    
                if(t_top>3)
                t_top=0;
                document.getElementById("photo_rgt_2").innerHTML=document.getElementById("photo_lft_2").innerHTML; 
                document.getElementById("photo_lft_2").innerHTML=t[t_top];
                t_top=t_top+1; 
           
        }
}