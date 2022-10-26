package logic;

import Class.BOX;
import Class.Product;
import Class.cartshop;
import Class.topVentas;
import dao.dao_product;
import dao.dao_product_seller;
import drugstore.Drugstore;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class table {

    private dao_product prodDao = new dao_product();
    private dao_product_seller prodSellDao = new dao_product_seller();
    
    //Table product cart shop (MAIN)
    public float setTable(JTable tablePselect) {
        float PriceTotal = 0;
        DefaultTableModel tablem;
        String[] title = {"Codigo", "Nombre", "Cantidad", "Precio"};
        tablem = new DefaultTableModel(null, title);
        Object[] object = new Object[6];
        for (cartshop product : Drugstore.content) {
            object[0] = product.getCode();
            object[1] = product.getName();
            object[2] = product.getQuantity();
            object[3] = Float.toString((float) product.getPrice());
            PriceTotal += product.getPrice() * product.getQuantity();
            tablem.addRow(object);
        }
        tablePselect.setModel(tablem);
        return PriceTotal;
    }
    
    
    
    
    //Deler product in table product cart shop (MAIN)
    public void deletProduct(String codeDel) {
        List<cartshop> prod = Drugstore.content;
        for (int i = 0; i < prod.size(); i++) {
            String code = String.valueOf(prod.get(i).getCode());
            Drugstore.content.remove(i);
            }
        }
    
    
    
    //Print all product from table in search
    public void listProduct(JTable table, String searchname) {
        List<Product> prod = prodDao.searchProduct(searchname);
        DefaultTableModel model;
        String[] title = {"Codigo", "Nombre", "Stock", "Precio"};
        model = new DefaultTableModel(null, title);
        Object[] object = new Object[4];
        for (int i = 0; i < prod.size(); i++) {
            object[0] = prod.get(i).getCode();
            object[1] = prod.get(i).getName();
            object[2] = prod.get(i).getStock();
            object[3] = prod.get(i).getPrice();
            model.addRow(object);
        }
        table.setModel(model);
    }
    
    
    //Print all product from table in top vents
    public void setTableSells(JTable tablePselect) {
        List<topVentas> prod = prodDao.topSells();
        DefaultTableModel tablem;
        String[] title = {"Codigo", "Nombre", "Cantidad Vendida"};
        tablem = new DefaultTableModel(null, title);
        Object[] object = new Object[3];
        for (int i = 0; i < prod.size(); i++) {
            object[0] = prod.get(i).getCode();
            object[1] = prod.get(i).getName();
            object[2] = prod.get(i).getVentas();
            tablem.addRow(object);
        }
        tablePselect.setModel(tablem);
    }
    
    public void setTableBox(JTable tablePselect,String search) {
        List<BOX> prod = prodSellDao.listBox(search);
        DefaultTableModel tablem;
        String[] title = {"Seller", "Efectivo", "Tarjeta","Tarjeta Virtual","Transferencia","Qr","Fecha"};
        tablem = new DefaultTableModel(null, title);
        Object[] object = new Object[7];
        for (int i = 0; i < prod.size(); i++) {
            object[0] = prod.get(i).getDNI();
            object[1] = prod.get(i).getEfectivo();
            object[2] = prod.get(i).getTarjeta();
            object[3] = prod.get(i).getTarjeta_Virtual();
            object[4] = prod.get(i).getTransferencia();
            object[5] = prod.get(i).getQr();
            object[6] = prod.get(i).getDate();
            tablem.addRow(object);
        }
        tablePselect.setModel(tablem);
    }

    
    
    
    
}
