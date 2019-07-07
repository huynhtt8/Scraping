import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
public class SaveImg {
        public static void main(String[] args )
        {
            BufferedImage image =null;
            try{

                URL url =new URL("https://www.robotshop.com/media/catalog/product/cache/image/625x625/9df78eab33525d08d6e5fb8d27136e95/b/l/bluno-arduino-uno-ble-bluetooth-4-microcontroller_1.jpg");
                        // read the url
                        image = ImageIO.read(url);

                File file = new File("D:\\Code\\img\\arduino\\1\\1.jpg");
                file.getParentFile().mkdirs();
                ImageIO.write(image, "jpg",file);

            }catch(IOException e){
                e.printStackTrace();
            }
        }
}
