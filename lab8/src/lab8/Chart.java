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
public class Chart {
    int id;
    String name;
    ArrayList<Album> albums;

    public Chart() {
    }
    
    public void addAlbum(Album a)
    {
        albums.add(a);
    }
    public Chart(int id, String name, ArrayList<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public Chart(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
    
}
