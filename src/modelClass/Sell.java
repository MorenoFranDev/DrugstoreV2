package Class;

import java.util.Date;

public class Sell {

    private int locals;
    private char seller_dni;
    private float amount;
    private String numOperation = "";
    private String voucher = "";
    private String paymentId = "";
    private Date dateSell;

    public Sell() {
    }

    public Sell(int locals, char seller_dni, float amount, Date dateSell) {
        this.locals = locals;
        this.seller_dni = seller_dni;
        this.amount = amount;
        this.dateSell = dateSell;
    }

    public int getLocals() {
        return locals;
    }

    public void setLocals(int locals) {
        this.locals = locals;
    }

    public char getSeller_dni() {
        return seller_dni;
    }

    public void setSeller_dni(char seller_dni) {
        this.seller_dni = seller_dni;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(String numOperation) {
        this.numOperation = numOperation;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getDateSell() {
        return dateSell;
    }

    public void setDateSell(Date dateSell) {
        this.dateSell = dateSell;
    }
    
    
}
