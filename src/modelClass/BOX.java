
package Class;

public class BOX {
    private String DNI;
    private float Efectivo;
    private float Tarjeta;
    private float Tarjeta_Virtual;
    private float Transferencia;
    private float Qr;
    private String Date;

    public BOX() {
    }

    public BOX(String DNI, float Efectivo, float Tarjeta, float Tarjeta_Virtual, float Transferencia, float Qr, String Date) {
        this.DNI = DNI;
        this.Efectivo = Efectivo;
        this.Tarjeta = Tarjeta;
        this.Tarjeta_Virtual = Tarjeta_Virtual;
        this.Transferencia = Transferencia;
        this.Qr = Qr;
        this.Date = Date;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public float getEfectivo() {
        return Efectivo;
    }

    public void setEfectivo(float Efectivo) {
        this.Efectivo = Efectivo;
    }

    public float getTarjeta() {
        return Tarjeta;
    }

    public void setTarjeta(float Tarjeta) {
        this.Tarjeta = Tarjeta;
    }

    public float getTarjeta_Virtual() {
        return Tarjeta_Virtual;
    }

    public void setTarjeta_Virtual(float Tarjeta_Virtual) {
        this.Tarjeta_Virtual = Tarjeta_Virtual;
    }

    public float getTransferencia() {
        return Transferencia;
    }

    public void setTransferencia(float Transferencia) {
        this.Transferencia = Transferencia;
    }

    public float getQr() {
        return Qr;
    }

    public void setQr(float Qr) {
        this.Qr = Qr;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
}
