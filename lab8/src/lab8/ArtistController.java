/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class ArtistController {
    public static void create(String name, String country)
    {
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            String sql = "Insert into artists(name, country) values ('" + name + "', '" + country + "')"; 
            stmt.execute(sql);
            db.connection.commit();
        } catch (SQLException ex) {
            System.out.println("Couldn't insert into artists");
        }
        
    }
    public static void findByName( String name)
    {
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            String sql = "Select * from artists where name like'%" + name+"%'";
            var rs = stmt.executeQuery(sql);
            var metaDataRS = rs.getMetaData();
            while(rs.next())
            {
                for(int i=1; i<metaDataRS.getColumnCount(); i++)
                {
                    System.out.println(rs.getObject(i).toString());
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
