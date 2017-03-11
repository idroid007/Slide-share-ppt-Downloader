
package Implement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document; 
public class Get {
    public static Document getAPI(String url) throws IOException{
        
        return Jsoup.connect(url).get();
    }
      public void imageGrabber(String folder,String url,int counter) throws MalformedURLException, IOException{
       URL url_image = new URL(url);
        BufferedImage img = ImageIO.read(url_image);
        File file = new File(folder+"\\"+counter+".jpg");
        ImageIO.write(img, "jpg", file);
        img.flush();
        
    }
}
