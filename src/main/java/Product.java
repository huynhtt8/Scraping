import java.net.URL;
import java.util.List;

public class Product {

    private int productId;

    private String productDescription;

    private String productName;

    private String category;

    private double productPrice;

    private String images;

    public Product() {
    }

    public Product(int productId, String productDescription, String productName, String category, double productPrice, String images) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.productName = productName;
        this.category = category;
        this.productPrice = productPrice;
        this.images = images;
    }

    @Override
    public String toString() {
        return "Crawler.Product{" +
                "productId=" + productId +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", productPrice=" + productPrice +
                ", images='" + images + '\'' +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
