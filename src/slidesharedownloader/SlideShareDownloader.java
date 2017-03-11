/*
 *Ishu Sharma (http://iishu.in,  if you watching this thats means you've cracked my file :D
* Howvever i dont know how to licence it but its illegal i guess :D
*if you enjoy this atlease share my website http://iishu.in

 */
package slidesharedownloader;

/**
 *
 * @author Ishu Sharma
 */
import Implement.Get;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SlideShareDownloader {

    
    public static void main(String[] args) throws IOException {
        System.out.println("******************************************************************************");
        System.out.println("* SlideShareDownloader Library Developed by - Ishu sharma                    *");
        System.out.println("* For any bug report please report at ishubot@gmail.com                      *");
        System.out.println("* Social : http://iishu.in , http://h4ckshell.iishu.in   fb:ishu.mafia.007   *");
        System.out.println("******************************************************************************");
          System.out.println("Getting Data Ready wait...");
            System.out.println("....");
        System.out.println("Enter the url to download (with http or https protocol)");
        
        Scanner scan = new Scanner(System.in);
         String folder_name = null;
        String url = scan.nextLine();
        String[]  url_reg = url.split("/");
        if((url_reg[0].equals("http:") ||url_reg[0].equals("https:")) && url_reg[2].equals("www.slideshare.net")  ){
         
            if(url_reg.length>=4){
               folder_name=url_reg[4];
           }else{
                 folder_name=url_reg[3]; 
            }
            
        }else{
            System.out.println("BAD URL :( ");
            System.exit(0);
        }
       
     
        
        System.out.println("wait....");
     Document doc = Get.getAPI(url);
     Elements container = doc.getElementsByClass("slide_image");
    if(container.size()!=0){
        File dir = new File(folder_name);
            dir.mkdir();
            
    }
  String directory = System.getProperty("user.dir")+"\\"+folder_name;

  int counter =1;
     for(Element elem:container){
         String image_url = elem.attr("data-full");
        new Get().imageGrabber(directory, image_url,counter);
       counter++;
     } 
     
    System.out.println("All done Bud ;) Enjoy");
   Runtime.getRuntime().exec("explorer "+directory);


     
    }
    
}
