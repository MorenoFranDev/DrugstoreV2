package dao;

import connection.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Class.Product;
import Class.topVentas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class dao_product {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection.connect cn = new connect();
    private String mensaje = "";

    public String insertProduct(String name, String code, String expired, int stock, float price) {
        String sql = "INSERT INTO Product (name, price, stock, code, expired) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setInt(3, stock);
            ps.setString(4, code);
            ps.setString(5, expired);
            ps.execute();
            mensaje = "Guardado correctamente!";
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            mensaje = "Error al guardar!";

        }
        return mensaje;
    }

    public String insertProductTopSell(String name, String code, int stock) {
        String sql = "INSERT INTO TopProductSell (name, stockVendido, code) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, stock);
            ps.setString(3, code);
            ps.execute();
            mensaje = "Guardado correctamente!";
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            mensaje = "Error al guardar!";

        }
        return mensaje;
    }

    public String update(String code, String expired, int stock, float price) {
        String sql = "UPDATE Product SET price = ?, stock = ?,expired = ? WHERE code = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setInt(2, stock);
            ps.setString(3, expired);
            ps.setString(4, code);
            ps.execute();
            mensaje = "Guardado correctamente!";
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            mensaje = "Error al guardar!";

        }
        return mensaje;
    }

    public String updateTopSell(String code, int stock) {
        String sql = "UPDATE TopProductSell SET stockVendido = stockVendido+? WHERE code = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setString(2, code);
            ps.execute();
            mensaje = "Guardado correctamente!";
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            mensaje = "Error al guardar!";

        }
        return mensaje;
    }

    public List<Product> getProd(String code) {
        String sql = "SELECT stock, name, price FROM Product WHERE code = ?";
        List<Product> prod = new ArrayList();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                Product sProduct = new Product();
                sProduct.setName(rs.getString("name"));
                sProduct.setStock(rs.getInt("stock"));
                sProduct.setPrice(rs.getFloat("price"));
                prod.add(sProduct);
            }
            return prod;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            mensaje = "Error al guardar!";
        }
        return null;
    }

    public String remove(int id) {
        try {

            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            System.out.println("Error: " + e);
            mensaje = "Error al Actualizar!";

        }
        return mensaje;
    }
    
    public List searchProduct(String search) {
        String sql;
        List<Product> prod = new ArrayList();
        try {
            con = cn.getConnection();
            sql = "Select code,name,stock,price from Product where code LIKE ? or name LIKE ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, search);
            ps.setString(2, search);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product sProduct = new Product();
                sProduct.setCode(rs.getString("code"));
                sProduct.setName(rs.getString("name"));
                sProduct.setStock(rs.getInt("stock"));
                sProduct.setPrice(rs.getFloat("price"));
                prod.add(sProduct);
            }
        } catch (SQLException e) {
            prod = null;
        }
        return prod;
    }

    //1 PARA AGREGAR Y 2 PARA QUITAR
    public void updateStock(String code, int stock, int typeQuery) {
        String sql;
        sql = (typeQuery == 1) ? "UPDATE Product SET  stock = stock+? WHERE code = ?" : "UPDATE Product SET  stock = stock-? WHERE code = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setString(2, code);
            ps.execute();
           System.out.println("Correcto eliminacion de articulos");
        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
    }

    public List topSells() {
        String sql;
        List<topVentas> prodV = new ArrayList();
        try {
            con = cn.getConnection();
            sql = "Select code,name,stockVendido from TopProductSell ORDER BY stockVendido DESC LIMIT 100";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                topVentas topVent = new topVentas();
                topVent.setCode(rs.getString("code"));
                topVent.setName(rs.getString("name"));
                topVent.setVentas(rs.getInt("stockVendido"));
                prodV.add(topVent);
            }
        } catch (SQLException e) {
            prodV = null;
        }
        return prodV;
    }
    
    
    
    
}
