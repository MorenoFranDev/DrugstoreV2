package dao;

import connection.connect;
import java.sql.*;
import javax.swing.JOptionPane;

public class dao_init {
    String sql = "";
    Connection con;
    PreparedStatement ps;
    connection.connect cn = new connect();
    static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER = "root";
   static final String PASS = "";
    public void init(){
        createDB();
        createTableLocal();
        createTableProduct();
        createTablePayment();
        createTableSeller();
        createTableTicket();
        createTableTicketProduct();
        createTableTopProductSell();
        createTableBalance();
        createLocal1();
        createLocal2();
        createMethodPayment1();
        createMethodPayment2();
        createMethodPayment3();
        createMethodPayment4();
        createMethodPayment5();
    }

    public void createDB() {
        sql = "Create database drugstore";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
         System.out.println("Database exist");   	  
         
      } 
   
    }
    
    

    public void createTableProduct() {
        sql = "CREATE TABLE IF NOT EXISTS Product(name VARCHAR(100),stock int not null,price FLOAT NOT NULL,code varchar(50) PRIMARY KEY NOT NULL,expired varchar(10));";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table product create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createTableTopProductSell() {
        sql = "CREATE TABLE IF NOT EXISTS TopProductSell(name VARCHAR(100),stockVendido int not null,code varchar(50) PRIMARY KEY NOT NULL);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table ProductSell create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createTableBalance() {
        sql = "CREATE TABLE balance(  id INT PRIMARY KEY AUTO_INCREMENT,seller_dni VARCHAR(8),efectivo FLOAT not null,tarjeta FLOAT not null,tarjeta_virtual FLOAT not null,transferencia FLOAT not null,qr FLOAT not null,create_time varchar(10));";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table ProductSell create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }

    public void createTableSeller() {
        sql = "CREATE TABLE IF NOT EXISTS Seller(dni char(8) NOT NULL PRIMARY KEY,password varchar(100) not null,name varchar(50) not null);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table seller create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    
    public void createTablePayment(){
          sql = "create table IF NOT EXISTS payment(id int NOT null AUTO_INCREMENT PRIMARY KEY,name VARCHAR(30) NOT NULL);";
                try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table payment create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    
    public void createTableLocal(){
        sql = "create table IF NOT EXISTS local(id int NOT NULL PRIMARY KEY,name VARCHAR(50) NOT NULL);";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table local create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }


    public void createTableTicket(){
        sql = "create table IF NOT EXISTS ticket(id INT PRIMARY KEY NOT null AUTO_INCREMENT,locals int not null,seller_dni char(8),amount DOUBLE not null,numOperatio varchar(11),voucher varchar(12),serievoucher varchar(7),paymentMode_id int,descu float,total float not null,datesell varchar(20),FOREIGN KEY (seller_dni) REFERENCES Seller(dni),FOREIGN KEY (paymentMode_id) REFERENCES payment(id),FOREIGN KEY (locals) REFERENCES local(id));";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table ticket create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createTableTicketProduct(){
        sql = "create table IF NOT EXISTS sell_product(id_ticket int,id_code varchar(50),stock int,FOREIGN KEY (id_ticket) REFERENCES ticket(id),FOREIGN KEY (id_code) REFERENCES Product(code));";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Table ticketProduct create successfully");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createLocal1(){
        sql = "Insert into local (id,name) Values (1,'9 de julio')";
        try {
            con = cn.getConnection();
            ps = con.   prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Local 1 - Create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createLocal2(){
        sql = "Insert into local (id,name)Values (2,'Gusnisky')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Local 2 - Create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }    
    public void createMethodPayment1(){
        sql = "Insert into payment (name) Values ('Efectivo')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Method payment 1 - create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createMethodPayment2(){
        sql = "Insert into payment (name) Values ('Tarjeta')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Method payment 2 - create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createMethodPayment3(){
        sql = "Insert into payment (name) Values ('Tarjeta Virtual')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Method payment 3 - create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createMethodPayment4(){
        sql = "Insert into payment (name) Values ('Transferencia')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Method payment 4 - create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
    public void createMethodPayment5(){
        sql = "Insert into payment (name) Values ('Qr')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Method payment 5 - create");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }
}
