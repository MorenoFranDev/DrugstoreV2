package Class;

public class cartshop {
private String code;
private String name;
private double price;
private int Quantity;

    public cartshop() {
    }

    public cartshop(String code, String name, double price, int Quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.Quantity = Quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }


    
}
