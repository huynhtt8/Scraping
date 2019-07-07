import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main {

    //sua tai day
    public static String urlListProduct = "https://www.robotshop.com/en/pic-microcontrollers.html";
    public static String nameList = "pic-microcontrollers";
    public static int indexId = 262;
    public static int categoryId = 5;
    public static void main(String[] args) {

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {

            GetLinkProduct getLinkProduct = new GetLinkProduct();

            List<String> Urls  = getLinkProduct.getLink(urlListProduct);
            int i = 1;
            for (String searchUrl : Urls) {
//                String searchUrl = "https://www.robotshop.com/en/bluno-arduino-uno-ble-bluetooth-4-microcontroller.html";
                HtmlPage page = client.getPage(searchUrl);
                List<URL> imgs = new ArrayList<URL>();
                List<HtmlElement> productImgs = (List<HtmlElement>) page.getByXPath("//ul[@id='scroller']/li/a/img");

                String pathImages= "";
                int j=1;
                for (HtmlElement productImg : productImgs) {
                    URL imageUrl = new URL((((HtmlElement) productImg )).getAttribute("data-thumb-src1281"));
                    imgs.add(imageUrl);
                    System.out.println(imageUrl);

                    BufferedImage image =null;
                    try{

                        URL url = imageUrl;
                        // read the url
                        image = ImageIO.read(url);

                        String path = nameList+  "\\"+ i + "\\" + j +  ".jpg";
                        pathImages = pathImages + " " + path;
                        File file = new File("D:\\Code\\img\\"+path);
                        file.getParentFile().mkdirs();
                        ImageIO.write(image, "jpg",file);
                        j++;
                    }catch(IOException e){
                        e.printStackTrace();
                    }



                }
                System.out.println(pathImages);
                String[] paths = pathImages.split(" ");

                System.out.println("-------------------------------------------------------------------------------");

                HtmlElement nameHtml = (HtmlElement) page.getFirstByXPath("//div[@class='productNameTop']/h1");

                String name = nameHtml.asText();
                System.out.println(name);
                System.out.println("-------------------------------------------------------------------------------");

                List<HtmlElement> dess = (List<HtmlElement>) page.getByXPath("//div[@class='productShortDescription']/ul/li");



                String descriptions = "";
                for (HtmlElement des : dess) {
                    String description =  des.asText();
                    descriptions = descriptions + "htt98" + description;
                    System.out.println(description);
                }

                System.out.println("-------------------------------------------------------------------------------");

                HtmlElement priceHtml = (HtmlElement) page.getFirstByXPath("//div[@class='price-box']/span/span");

                String price = priceHtml.asText();
                String[] parts = price.split("\\$");
                String part1 = parts[0];
                String part2 = parts[1];
                double price1 = Double.parseDouble(part2);
                System.out.println(price1);
                System.out.println("-------------------------------------------------------------------------------");

                Product product = new Product(i+indexId,descriptions,name,nameList,price1,pathImages);

                System.out.println(product.toString());
                MySQLAccess mySQLAccess = new MySQLAccess();
                mySQLAccess.readDataBase(product);
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}
