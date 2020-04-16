/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class AlbumController {
    public static void create(String name, int artistId, int releaseYear)
    {
        try {
            Database db = Database.getInstance();
            Statement stmt= db.connection.createStatement();
            stmt.execute("Insert into albums(name, artist_Id,release_year) values ('" +name +"',"+artistId + ", "+releaseYear + ")");
            db.connection.commit();
        } catch (SQLException ex) {
            System.out.println("Couldn't insert into albums\n" + ex.getMessage());
        }
        
    }
    public static void  findByArtist(int artistId)
    {
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            String sql = "Select * from albums where artist_id = " + artistId;
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
            System.out.println("Error while trying to get album\n" + ex.getMessage() );
        }
    }
}
