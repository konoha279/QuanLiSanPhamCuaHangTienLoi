/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ASUS
 */
public class DBConnect {
    public static DBConnect Instance = null;
    
    public static String DBname = "OOP";
    String USER ="sa";
    String PASS ="123456";
    
    public static DBConnect getInstance()
    {
        if (Instance == null)
            Instance = new DBConnect();
        
        return Instance;
    }
    Connection con = null;
    
    public Connection getBConnect() throws SQLException
    {
        try {
            String URL="jdbc:sqlserver://127.0.0.1:1433;databaseName="+DBname;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println("Connect Fail!");
        }
        return con;
    }
  
    public void TruyVan(String sql)
    {
        try {
            Connection connect = getInstance().getBConnect();
            
            Statement st;
            try {
                st = connect.createStatement();
                st.executeQuery(sql);
                
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi!", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
        }
            
    }
    
    public void ReadFile() throws FileNotFoundException
    {
        File data = new File("Data.dat");
        Scanner myReader = new Scanner(data);
        while (myReader.hasNextLine())
        {
            USER = myReader.nextLine();
            PASS = myReader.nextLine();
        }
    }   
}
