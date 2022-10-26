
package logic;

import Class.cartshop;
import java.util.List;


public class service {
     //Function sell for ticket
    public void actualize() {
        List<cartshop> prod = Drugstore.content;
        for (int i = 0; i < prod.size(); i++) {
            String code = String.valueOf(prod.get(i).getCode());
            int stock = prod.get(i).getQuantity();
            //type query is 2 remove stock product
            prodPdo.updateTopSell(code, stock);
            prodPdo.updateStock(code, stock, 2);
            int id_ticket = ticketDao.idMaxSell();
            SellerProd_doa.create(id_ticket, code,stock);
        }
    }

    public void payment(String DNI, float amount, String currentTime, int paymentMode,float desc,float total) {
        boolean ticket = ticketDao.createTicket(DNI, 1, amount, null, null, null, paymentMode, currentTime,desc,total);
        //if ticket true, sell operation complet
        if (ticket){
        this.actualize();
        this.loadBalance(DNI,amount,paymentMode);
        }

    }

    
    //insert balance or create new balance actual
    void loadBalance(String dni,Float amount,int method){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(dt);
        Object[] obj = SellerProd_doa.getLasBalance();
        String seller = (String) obj[0];
        String date = (String) obj[1];
        try{
        if(date.equalsIgnoreCase(currentTime) && seller.equalsIgnoreCase(dni)){
        String Method = this.findMethodString(method);
        SellerProd_doa.UpdateTableBalance(amount,Method,currentTime,dni);
        }else{
            SellerProd_doa.CreateTableBalance(dni, currentTime);
            String Method = this.findMethodString(method);
            SellerProd_doa.UpdateTableBalance(amount,Method,currentTime,dni);
        }}catch(Exception e){
            SellerProd_doa.CreateTableBalance(dni, currentTime);
            String Method = this.findMethodString(method);
            SellerProd_doa.UpdateTableBalance(amount,Method,currentTime,dni);
            
        }
        
        
    }
    
    //TypeQuery is 1 for add stock product
    public String updateStock(String code, int stock) {
        prodPdo.updateStock(code, stock, 1);
        return "Stock agregado";
    }

    public int findMethod(String value) {
        String[] array = {"None", "Efectivo", "Tarjeta", "Tarjeta Digital", "Transferencia", "Qr"};
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return -1;
    }
    
    public String findMethodString(int value) {
        String[] array = {"None", "efectivo", "tarjeta", "tarjeta_virtual", "transferencia", "qr"};
        for (int i = 0; i < array.length; i++) {
            if (i == value) {
                return " "+array[i]+"="+array[i]+" ";
            }
        }
        return null;
    }

}
