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
    public static ArrayList<Album> findByArtist(int artistId)
    {
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            String sql = "Select * from albums where artist_id = " + artistId;
            var rs = stmt.executeQuery(sql);
            Artist ar = new Artist();
            ArrayList<Album> albums = new ArrayList<>();
            while(rs.next())
            {
                albums.add(new Album(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            return albums;
        } catch (SQLException ex) {
            System.out.println("Error while trying to get album\n" + ex.getMessage() );
        }
        return null;
    }
}
