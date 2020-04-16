/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistenceUtil;
import entity.Album;
import entity.Artist;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author denis
 */
public class AlbumManager {

    public static void main(String[] args) {
        Artist artist1 = new Artist(new BigDecimal(1), "Eminem");
        Artist artist2 = new Artist(new BigDecimal(2), "2pac");
        
        Album al1 = new Album(new BigDecimal(1), "MM", BigInteger.valueOf(2016), artist1);
        Album al2 = new Album (new BigDecimal(2),"GG", BigInteger.valueOf(1986), artist2);
        Album al3 = new Album(new BigDecimal(3),"MM2", BigInteger.valueOf(2018),artist1);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        var em = emf.createEntityManager();
        
        
        AlbumRepository alR = new AlbumRepository(em);
        ArtistRepository arR = new ArtistRepository(em);
        
        alR.saveAlbum(al1);
        alR.saveAlbum(al2);
        alR.saveAlbum(al3);
        
        arR.saveArtist(artist1);
        arR.saveArtist(artist2);
        
        Artist artist3 = arR.getByName("Eminem");
        Artist artist4 = arR.getById(2);
        
        System.out.println(artist3.toString());
        
        ArrayList<Album> albums = alR.getByArtist(artist1);
        for(var a : albums)
        {
            System.out.println(a.toString());
        }
        
    }
    
}
