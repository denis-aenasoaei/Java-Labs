/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class Database {
    
    private static Database database = null;
    public java.sql.Connection connection;
    private Database()
    {
        
    }
    public static Database getInstance()
    {
        if(database==null)
        {
            database = new Database();
            database.connect();
            
        }
        return database;
    }
    
    private void connect()
    {
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            connection=DriverManager.getConnection(  
            "jdbc:oracle:thin:@localhost:1521:xe","dbadmin","sql");
            System.out.println("Connected!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
