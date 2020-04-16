/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import javax.persistence.EntityManager;
import entity.Artist;
/**
 *
 * @author denis
 */
public class ArtistRepository {
    EntityManager em;

    public ArtistRepository(EntityManager em) {
        this.em = em;
    }
    
    public Artist getById(long id)
    {
        return em.find(Artist.class, id);
    }
    public Artist getByName(String name)
    {
        Artist ar =  (Artist) em.createNamedQuery("Artist.findByName").setParameter("name",name).getSingleResult();
        return ar;
    }
    public Artist saveArtist(Artist a)
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
}
