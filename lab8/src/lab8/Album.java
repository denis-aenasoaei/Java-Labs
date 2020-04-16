/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

/**
 *
 * @author denis
 */
public class Album {
    int id;
    String name;
    int artistId;
    int releaseYear;

    public Album() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album{name=").append(name);
        sb.append(", artistId=").append(artistId);
        sb.append(", releaseYear=").append(releaseYear);
        sb.append('}');
        return sb.toString();
    }

    
    public Album(int id, String name, int artistId, int releaseYear) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
}
