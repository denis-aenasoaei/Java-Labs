/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;
import entity.Album;
import entity.Artist;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author denis
 */
public class AlbumRepository {

    EntityManager em;
    public AlbumRepository() {
    }

    public AlbumRepository(EntityManager em) {
        this.em = em;
    }
    
    
    public Album getById(long id)
    {
        return em.find(Album.class, id);
    }
    public Album getByName(String name)
    {
        Album al =  (Album) em.createNamedQuery("Album.findByName").setParameter("name",name).getSingleResult();
        return al;
    }
    public Album saveAlbum(Album a)
    {
        em.getTransaction().begin();
        if(a.getId() == null)
        {
            em.persist(a);
        }
        else
        {
            em.merge(a);
        }
        em.getTransaction().commit();
        return a;
    }
    public ArrayList<Album> getByArtist(Artist a)
    {
        ArrayList<Album> albums = (ArrayList<Album>) em.createNamedQuery("Album.findByArtist").setParameter("artist_id", a.getId()).getResultList();
        return albums;
    }
}
