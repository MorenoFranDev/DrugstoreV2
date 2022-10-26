package Class;


public class BoxPayment {

    private float Efectivo;
    private float Tarjeta;
    private float Tarjeta_virtual;
    private float Transferencia;
    private float Qr;

    public BoxPayment() {
    }

    public BoxPayment(float Efectivo, float Tarjeta, float Tarjeta_virtual, float Transferencia, float Qr) {
        this.Efectivo = Efectivo;
        this.Tarjeta = Tarjeta;
        this.Tarjeta_virtual = Tarjeta_virtual;
        this.Transferencia = Transferencia;
        this.Qr = Qr;
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

    public float getTarjeta_virtual() {
        return Tarjeta_virtual;
    }

    public void setTarjeta_virtual(float Tarjeta_virtual) {
        this.Tarjeta_virtual = Tarjeta_virtual;
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
    
    
}
