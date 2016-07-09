/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nabeel_temp;


import java.util.Date;


public class work {
    
    static work w=null;
    public static work objectCreater()
    {
        if(w==null)
            w=new work();
        return w;
    }
    private work()
    {}
    public static void main(String asd[])
    { 
        work k=new work();
       // System.out.println(k.chat_id_genrator("1306AAAAYt"));
      //  String m="nabeel";
        //System.out.println("m");
        String m=k.chat_id_genrator("140930abcdf");
        System.out.println(m);
        
     
    }
    
  public  String chat_id_genrator(String old)
    {
       
        String lid=old.substring(0, 2);
        String rid=old.substring(2);
        return genralizeIDGenrater(old,10);

    }
  
  
  
   
   
   
   public String span_id_genrator(String u_id)
   {
       return "sp"+u_id;
       
   }
   
   public String user_id_creater(String id)
   {
       String lid=id.substring(0,2);
       String rid=id.substring(2);
       return lid+genralizeIDGenrater(rid, 10);
   }
   
   
   
   
   public String id_creater(String id)
   {
        return user_id_creater(id);
   }
   
   
   
   public String genralizeIDGenrater(String id,int size)
   {     
       char a[] = new char[size];
        for (int i = 0; i < size; i++) {
            a[i] = id.charAt(i);
           
        }
        int i = size-1;

        while (true) {
            if (a[i] != 'z') 
            {    
                if(a[i] == '9')
                a[i]=(char) (a[i]+39);
               
                a[i]++;
                break;
                
            } else {
                a[i] = '0';
            }
            i--;
            if (i < 0) {
                break;
            }
        }
        Character c;
        c = new Character(a[0]);
        String  m = c.toString();
       
        for (i = 1; i < size; i++) {
            c = new Character(a[i]);
            m = m + c.toString();
        }
       
        return m;
   }

   public String friend_table_id(String id)
   {
       String lid=id.substring(0,2);
       String rid=id.substring(2);
       return lid+genralizeIDGenrater(rid, 10);
   }
   
}

    

