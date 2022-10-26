package dao;

import connection.connect;
import java.sql.*;

import javax.swing.JOptionPane;

public class dao_seller {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection.connect cn = new connect();
    public String Mensaje = "";

    public String Create(String dni, String password, String name) {
        String sql = "INSERT INTO Seller (dni,password,name) VALUES (?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.execute();
            Mensaje = "Creado correctamente!";
        }catch(SQLException e){
            System.out.println(e);
            Mensaje = "No se puedo crear correctamente!";
        }
        return Mensaje;
    }

    public String Update(String dni, String name, String password, int range) {

        return null;
    }

    public String delete(String dni, String password, int range) {

        return null;
    }

    public Object Authenticate(String dni, String password) {
        String sql = "SELECT * FROM Seller WHERE dni = ? AND password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, password);
            rs = ps.executeQuery();
            Object[] obj = new Object[2];
            if (rs.next()) {
                obj[0] = rs.getString(1);
                obj[1]= rs.getString(3);
                return obj;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error interno");
            return null;
        }
    }

}
