/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author denis
 */
public class Lab8 {

    
    public static void main(String[] args) {
//        ArtistController.create("Uzi", "Panty");
//        ArtistController.create("Eminem", "murica");
        
        Artist ar1 = ArtistController.findByName("Eminem");
        Artist at2 = ArtistController.findByName("Uzi");
        
//        AlbumController.create("Best", 1, 2020);
//        AlbumController.create("Mf", 1, 2015);
        
        ArrayList<Album> uziAlbums= AlbumController.findByArtist(1);
        
//        AlbumController.create("MNM", 2, 2016);
//        AlbumController.create("Bester", 2, 2019);
        
        ArrayList<Album> emAlbums = AlbumController.findByArtist(2);
       
        uziAlbums.addAll(emAlbums);
        //ChartController.create("Ro", uziAlbums);
        
        emAlbums.addAll(uziAlbums);
//        ChartController.create("USA", emAlbums);
        
        Chart c1 = ChartController.getById(1);
        Chart c2 = ChartController.getById(2);
        
        ArrayList<Chart> charts = new ArrayList<>();
        
        charts.add(c1); charts.add(c2);
        
        displayRankings(charts);
        
    }
    
    public static void displayRankings(ArrayList<Chart> charts)
    {
        HashMap<Album, Integer> albumsFreq = new HashMap<>();
        
        for(Chart c : charts)
        {
            for(int i=0;i<c.albums.size(); i++)
            {
                albumsFreq.putIfAbsent(c.albums.get(i),0);
            }
        }
        for(Chart c : charts)
        {
            for(int i=0;i<c.albums.size(); i++)
            {
                albumsFreq.replace(c.albums.get(i), albumsFreq.get(c.albums.get(i)) + i) ;
            }
        }
        
        while(!albumsFreq.isEmpty())
        {
            Entry<Album, Integer> min = null;
            
            for(var entry : albumsFreq.entrySet())
            {
                if(min == null || min.getValue() > entry.getValue())
                {
                    min = entry;
                }
            }
            
            System.out.println(min.getKey().toString());
            albumsFreq.remove(min.getKey());
        }
    }
    
}
