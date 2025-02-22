/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.uitility;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Admin
 */
public class DBcontext {

    public static String USER = "sa01";
    public static String PASS = "sa123456";

    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=Sport_Shop";
    static{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection(){
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    } 
    public static ResultSet query(String sql,Object... args){
        try {
            PreparedStatement stmt = getStmt(sql,args);
            return stmt.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static PreparedStatement getStmt(String sql,Object... args) throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement pstm =null;
        if(sql.trim().startsWith("{")){
            pstm = connection.prepareCall(sql);
        }else{
            pstm = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i+1, args[i]);
        }
        return pstm;
    }
    public static void main(String[] args) {
        Connection cn = getConnection();
        try{
            
            if(cn!= null){
                System.out.println("Kết nối thành công");
            }else{
                System.out.println("Lỗi kết nối");
                System.exit(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
