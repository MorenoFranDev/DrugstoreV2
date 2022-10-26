package connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class connect {

    Connection con;

    public Connection getConnection() {
        try {
            String db = "jdbc:mysql://localhost:3306/drugstore";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(db, user, password);
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el servidor");
        }
        return null;
    }
}
