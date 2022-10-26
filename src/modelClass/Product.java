package Class;


public class Product {
    private String name;
    private float price;
    private int stock;
    private String code;
    private String expired;

    public Product(String name, float price, int stock, String code, String expired) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.code = code;
        this.expired = expired;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
}
