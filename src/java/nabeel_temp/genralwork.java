/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabeel_temp;

/**
 *
 * @author NABEEL
 */
public class genralwork {
    static genralwork gw=null;
    public static genralwork bojectCreater()
    {
        if(gw==null)
            gw=new genralwork();
        return gw;
    }
private genralwork(){}
    public static void main(String hh[]) {
        //nameFormater("nabeel abdullah ansari");
      //  System.out.println(nameFormater("nabeel abdullah ansari"));
    }

    public  String nameFormater(String name) {
        name = name.toLowerCase();
        String returner = "";
        String newname[] = name.split(" ");
        int l = newname.length;
        for (int i = 0; i < l; i++) {
            String m = new Character(newname[i].charAt(0)).toString().toUpperCase();
            returner += m + newname[i].substring(1) + " ";
        }
        return returner;
    }

}
