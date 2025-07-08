/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YumExpress.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ashmi
 */
public class DbConnection {
    private static Connection conn;
    static{
        try{
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "yumexpress", "admin");
            JOptionPane.showMessageDialog(null, "Connected to DB Successfully..!");
        }
        catch(SQLException se1){
            JOptionPane.showMessageDialog(null, "Error... Cannot connect to DB...!");
            se1.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
        }
        catch(SQLException se2){
            JOptionPane.showMessageDialog(null, "Error... Cannot close the connection...!");
            se2.printStackTrace();
        }
    }
}
