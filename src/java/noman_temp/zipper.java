/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noman_temp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 *
 * @author akhtar
 */
public class zipper {
    
   private byte input[];
   private byte output[];
   private byte output2[];
   private byte temp[];
   private int compressdata_lenth;
    static zipper z=null;
    public static zipper objectCreater()
    {
        if(z==null)
            z=new zipper();
        return z;
    }

    public byte[] contentent_zipper(String cont)
    {
      
        System.out.println("strrlen="+cont.length());
        System.out.println(cont);
        int strrlen=cont.length();
        try {
            input = cont.getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                                                       Logger.getLogger(zipper.class.getName()).log(Level.SEVERE, null, ex);
                                                      }
        output=new byte[4000];
        Deflater compress=new Deflater();
        compress.setInput(input);
        compress.finish();
        compressdata_lenth=compress.deflate(output);
        output2=new byte[compressdata_lenth];   
        int i=0;
        while(i<compressdata_lenth) 
        {
            output2[i]=output[i];
            i+=1;
        }
        
        System.out.println("compressdata_lenth"+compressdata_lenth);
         return output2;
        
    }
    
    
    public void contentent_unzipper(byte []bb)
    {
     Inflater decompress=new Inflater();
    decompress.setInput(bb, 0,bb.length);
            byte []result=new byte[bb.length];
        try {
            System.out.println("1");
            int resultlen=decompress.inflate(result, 0, bb.length);
            System.out.println("2");
            String re=new String(result,0,resultlen,"UTF-8");
            System.out.println("final result="+re);
            }catch(UnsupportedEncodingException c){c.printStackTrace();}catch(DataFormatException v){v.printStackTrace();}
       
        
    }   
        
    //temp=uz_cont.getBytes();
//    Inflater decompress=new Inflater();
//    decompress.setInput(, 0,compressdata_lenth);
//    byte []result=new byte[2000];
//        try {
//            int resultlen=decompress.inflate(result);
//            
//            String re=new String(result,0,resultlen,"UTF-8");
//            System.out.println("final result="+re);
//        
//            } catch (DataFormatException ex) {
//                                             Logger.getLogger(zipper.class.getName()).log(Level.SEVERE, null, ex);
//                                             }
//            catch (UnsupportedEncodingException ex) {
//                                                    Logger.getLogger(zipper.class.getName()).log(Level.SEVERE, null, ex);
//                                                 }
//       
//        decompress.end();
        
    


public static void main(String akhtar[])
{        FileOutputStream fos = null;
         FileInputStream fis;
    zipper z=new zipper();
       try {
            fis=new FileInputStream ("D:\\a.text");
            fos=new FileOutputStream ("D:\\a.text");
       
    byte bb[]=z.contentent_zipper("nonns sjnsn skjnjd jndu djud jdnndd ud jdn ddnnd dd fnfn ffn fnufn fjnnfin  ffihfui fuhu fniu"); 
    String ss=new String(bb);
    System.out.println("value is="+ss);
    
    for(int i=0;i<bb.length;i++) 
    {
         fos.write(bb[i]);
         System.out.println(bb[i]);
         
    }
    fos.close();
//           int g=0;
//           StringBuffer sb=new StringBuffer();
//           while ((g= f.read())!=-1 )
//           {               
//              sb.append(g);
//           }
//           
//           String h=sb.toString();
//           System.out.println("sb is ="+h);
//           byte b[]=h.getBytes();
//    
//     z.contentent_unzipper(b);
     } catch (IOException ex) {
           Logger.getLogger(zipper.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    
    
    
    
    
    
    
    
    
    
    
///System.out.println("ou len="+bb.length);
////     System.out.println("hiiiiiiiiiii");
////        for(int i=0;i<300;i++) 
////        System.out.print(bb[i]=z.output[i]);
//    Inflater decompress=new Inflater();
//    decompress.setInput(bb, 0,bb.length);
//            byte []result=new byte[2000];
//        try {
//            System.out.println("1");
//            int resultlen=decompress.inflate(result, 0, bb.length);
//            System.out.println("2");
//            String re=new String(result,0,resultlen,"UTF-8");
//            System.out.println("final result="+re);
//            }catch(UnsupportedEncodingException c){c.printStackTrace();}catch(DataFormatException v){v.printStackTrace();}
//    
//    
//    
//    
//    
//    
//    
    
}














}