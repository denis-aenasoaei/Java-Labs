/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.ArrayList;

/**
 *
 * @author denis
 */
public class AlbumController {
    public static void create(String name, int artistId, int releaseYear)
    {
        Database db = Database.getInstance();
        db.executeCreateAlbumQuery(name, artistId,releaseYear);
    }
    public static void  findByArtist(int artistId)
    {
        Database db = Database.getInstance();
        ArrayList<String> res = new ArrayList<>();
        res = db.executeSelectQuery("Select * from albums where artist_id=" + artistId);
        for(String r : res)
        {
            System.out.println(r);
        }
    }
}
