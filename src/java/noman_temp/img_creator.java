
package noman_temp;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import org.apache.taglibs.standard.extra.spath.Path;
 
/**
 * This program demonstrates how to resize an image.
 *
 * @author www.codejava.net
 *
 */
public class img_creator {
 
    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
     static img_creator ic;
     String path;//="D:\\MultiKBIS.com";//"/var/lib/openshift/5453203ee0b8cd12ca0001a4/app-root/data/MultiKBIS.com";//
    
    img_creator()
    {
     utility ut=utility.objectCreator();
     path=ut.utility_reader("path");
//        System.err.println(path);
    }
   
     public static img_creator objectCreater()
    {
        if(ic==null)
            ic=new img_creator();
    return ic;
    }
    
    
    
    
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
 
    /**
     * Resizes an image by a percentage of original size (proportional).
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }
 
    /**
     * Test resizing images
     */
    public boolean img_creator(String u_id) {
        
        String inputImagePath =path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"profile"+File.separator+"profile.jpg";
        String inputImagePathout1 =path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"profile"+File.separator+"medium.jpg";
        String inputImagePathout2 =path+File.separator+"MEMBER"+File.separator+u_id+File.separator+"profile"+File.separator+"small.jpg";
        System.out.println(inputImagePath);
     
        try {
            
            img_creator.resize(inputImagePath,inputImagePathout2, 40, 40);
            img_creator.resize(inputImagePath,inputImagePathout1, 130, 110);
 
           
         
 
          
          
         
 
        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    
        return true;
    }
    
    
    
    public static void main(String[] args) {
        img_creator ic=img_creator.objectCreater();
        ic.img_creator("UI0000000008");
    }
}
