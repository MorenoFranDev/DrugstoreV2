package dao;

import connection.connect;
import java.sql.*;
import javax.swing.JOptionPane;


public class dao_ticket {
Connection con;
ResultSet rs;
    PreparedStatement ps;
    connection.connect cn = new connect();
    public boolean createTicket(String dni, int local, float amount, String numOperation, String voucher,String serieVoucher ,int paymentMode, String date,float desc,float total) {
        boolean resp;
        String sql = "INSERT INTO ticket (locals, seller_dni, amount, numOperatio, voucher, serieVoucher, paymentMode_id,descu,total,dateSell) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps =con.prepareStatement(sql);
            ps.setInt(1,local);
            ps.setString(2,dni);
            ps.setFloat(3,amount);
            ps.setString(4,numOperation);
            ps.setString(5,voucher);
            ps.setString(6,serieVoucher);
            ps.setInt(7,paymentMode);
            ps.setFloat (8,desc);
            ps.setFloat(9,total);
            ps.setString(10,date);
            ps.execute();
            resp =true;
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en crear ticket");   
            resp = false;
        }
        return resp;
    }
    
    public int idMaxSell(){
        int resp = -1;
        String sql = "SELECT  max(id) from ticket";
        try{
            con = cn.getConnection();
            ps =con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                resp = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al obtener numero de ticket");
            resp = -1;
        }
        return resp;
    }
}
