package com.ahmadee.everyfarmerIntern;
import java.sql.*;

public class Office_Management {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Employers employer = new Employers();
//        employer.updateBank("Union", 4);
        Department dept = new Department();
        dept.fetchData("offices");
        dept.updateColumnData("employees", "bank", "UBA", 8 , "employee_id");
    }
}

class Clients{
    public int addClient(String firstname, String lastname, String address, String state) throws SQLException, ClassNotFoundException {
        String uri = "jdbc:mysql://localhost:3306/office_info_sys?serverTimezone=UTC";
        String username = "root";
        String password = "manchesterUNITED1";
        String query = "INSERT into clients(firstname, lastname, address, state) VALUES (?, ?, ?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(uri,username,password);
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1,firstname);
        pst.setString(2, lastname);
        pst.setString(3, address);
        pst.setString(4, state);
        int rows = pst.executeUpdate();
        pst.close();
        conn.close();
        return rows;
    }
    public int removeClient(int id) throws ClassNotFoundException, SQLException {
        String uri = "jdbc:mysql://localhost:3306/office_info_sys?serverTimezone=UTC";
        String username = "root";
        String password = "manchesterUNITED1";
        String query = "DELETE from clients WHERE client_id = "+id+" ";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(uri,username,password);
        PreparedStatement pst = conn.prepareStatement(query);
        int row = pst.executeUpdate();
        pst.close();
        conn.close();
        return row;
    }
}

class Employers{
    public int updateBank(String value, int id) throws ClassNotFoundException, SQLException {
        String uri = "jdbc:mysql://localhost:3306/office_info_sys?serverTimezone=UTC";
        String username = "root";
        String password = "manchesterUNITED1";
        String query = "UPDATE employers SET bank = ? WHERE employer_id = ? ";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(uri,username,password);
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, value);
        pst.setInt(2, id);
        int colData = pst.executeUpdate();
        pst.close();
        conn.close();
        return colData;
    }
}

class Department{
    public void fetchData(String tableName) throws ClassNotFoundException, SQLException {
        String uri = "jdbc:mysql://localhost:3306/office_info_sys?serverTimezone=UTC";
        String username = "root";
        String password = "manchesterUNITED1";
        String query = "select * from "+tableName+" ";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(uri,username,password);
        Statement stm = conn.createStatement();
        ResultSet data = stm.executeQuery(query);
        while (data.next()){
            if(tableName == "offices" || tableName == "payment_method"){
                System.out.println(data.getInt(1)+ " " +data.getString(2)+ " ");
            }else{
                System.out.println(data.getInt(1)+ " " +data.getString(2)+ " " +data.getString(3));
            }
        }
        stm.close();
        conn.close();
    }
    public int updateColumnData(String tableName, String colName,String newTableValue,int targetId, String tableIdName) throws ClassNotFoundException, SQLException {
        String uri = "jdbc:mysql://localhost:3306/office_info_sys?serverTimezone=UTC";
        String username = "root";
        String password = "manchesterUNITED1";
        String query = "UPDATE "+tableName+" SET "+colName+" = ? WHERE "+tableIdName+" = ? ";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(uri,username,password);
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, newTableValue);
        pst.setInt(2, targetId);
        int colData = pst.executeUpdate();
        pst.close();
        conn.close();
        return colData;
    }
}
