
package Class;
public class topVentas {

    private String code;
    private String name;
    private int ventas;

    public topVentas() {
    }

    public topVentas(String code, String name, int ventas) {
        this.code = code;
        this.name = name;
        this.ventas = ventas;
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

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    
    
}
