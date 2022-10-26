package dao;

import Class.BOX;
import connection.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dao_product_seller {

    Connection con;
    PreparedStatement ps;
    connection.connect cn = new connect();
    ResultSet rs;

    public void create(int sell_id, String codeProduct,int stock) {
        String sql = "INSERT INTO sell_product (id_ticket,id_code,stock) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sell_id);
            ps.setString(2, codeProduct);
            ps.setInt(3, stock);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int lastbalance() {
        String sql = "SELECT  max(id) from balance";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
        return 0;
    }

    public Object[] getLasBalance(){
        Object[] obj = new Object[2];
        int id =  lastbalance();
     String sql = "SELECT seller_dni, create_time from balance where id = ?";   
     try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj[0] =rs.getString(1);
                obj[1] =rs.getString(2);
            }
            return obj;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void CreateTableBalance(String dni, String date) {
        String sql = "INSERT INTO balance (seller_dni,efectivo,tarjeta,tarjeta_virtual,transferencia,qr,create_time) values (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setFloat(2, 0);
            ps.setFloat(3, 0);
            ps.setFloat(4, 0);
            ps.setFloat(5, 0);
            ps.setFloat(6, 0);
            ps.setString(7, date);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateTableBalance(Float amount, String Sql, String Date, String name) {
        String sql = "UPDATE balance SET" + Sql + "+? where create_time = ? && seller_dni = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setFloat(1, amount);
            ps.setString(2, Date);
            ps.setString(3, name);
            ps.execute();
            System.out.println("Guardado exitoso! UPDATE TABLE BALANCE");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List listBox(String search){
        List<BOX>  boxCont = new ArrayList();
        try{
            System.out.println(search);
            String sql = "SELECT * FROM balance where create_time LIKE ? or seller_dni LIKE ? LIMIT 100";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,search);
        ps.setString(2,search);
        rs = ps.executeQuery();
        while(rs.next()){
            BOX box = new BOX();
            box.setDNI(rs.getString("seller_dni"));
            box.setEfectivo(rs.getFloat("efectivo"));
            box.setTarjeta(rs.getFloat("tarjeta"));
            box.setTarjeta_Virtual(rs.getFloat("tarjeta_virtual"));
            box.setTransferencia(rs.getFloat("transferencia"));
            box.setQr(rs.getFloat("qr"));
            box.setDate(rs.getString("create_time"));
            boxCont.add(box);
        }
    }catch(SQLException e){
            System.out.println(e);
            }
        return boxCont;
    }
    
    
}
