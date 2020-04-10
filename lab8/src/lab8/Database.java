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
    private static java.sql.Connection connection;
    private Database()
    {
        
    }
    public static Database getInstance()
    {
        if(database==null)
        {
            database = new Database();
            connect();
            
        }
        return database;
    }
    
    private static void connect()
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
    
    public ArrayList<String> executeSelectQuery(String query)
    {
        ArrayList<String> rowsReturned = new ArrayList<>();
        try {
            
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            var metaDataRS = rs.getMetaData();
            while(rs.next())
            {
                for(int i=1; i<metaDataRS.getColumnCount(); i++)
                {
                    rowsReturned.add(rs.getObject(i).toString());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Couldn't select " + ex.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
            return rowsReturned;
    }
    public void executeCreateArtistQuery(String tableName, ArrayList<String> columns, ArrayList<String> values)
    {
        try {
            
            Statement stmt=connection.createStatement();
            StringBuilder query = new StringBuilder();
            query.append("Insert into ").append(tableName).append(" ( ");
            for(String s : columns)
            {
                query.append(s).append(",");
            }
            query.setLength(query.length()-1);
            
            query.append(") values ( ");
            for(String s:values)
            {
                query.append("'").append(s).append("'").append(",");
            }
            
            query.setLength(query.length()-1);
            query.append(")");
            System.out.println(query.toString());
            stmt.execute(query.toString());
            connection.commit();
        }
        catch (SQLException ex) {
            System.out.println("Error inserting " + values + " into table " + tableName + "\n" + ex.getMessage());
        }
    }
        public void executeCreateAlbumQuery(String name, int artistId, int releaseYear)
    {
        try {
            
            Statement stmt=connection.createStatement();
            System.out.println("Insert into albums (name, artist_Id,release_year) values ('" +name +"',"+artistId + ", "+releaseYear + ");");
            stmt.execute("Insert into albums(name, artist_Id,release_year) values ('" +name +"',"+artistId + ", "+releaseYear + ")");
            
            connection.commit();
        }
        catch (SQLException ex) {
            System.out.println("Error inserting albums \n" + ex.getMessage());
        }
    }
}
