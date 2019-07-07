import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.ArrayList;
import java.util.List;

public class GetLinkProduct {

    public List<String> getLink(String searchUrl) {

        List<String> urls = new ArrayList<String>();

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {

//            searchUrl = "https://www.robotshop.com/en/arduino-microcontroller.html";
            HtmlPage page = client.getPage(searchUrl);

            List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//div[@class='thumbnailCatTop']") ;
            if(items.isEmpty()){
                System.out.println("No items found !");
            }else{
                for(HtmlElement item : items){
                    HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//a[@class='product-image']"));
                    String itemUrl =  itemAnchor.getHrefAttribute();
                    System.out.println(itemUrl);
                    urls.add(itemUrl);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return urls;
    }
}
