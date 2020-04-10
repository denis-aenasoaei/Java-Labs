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
public class Lab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArtistController.create("Uzi", "Panty");
        ArtistController.create("Eminem", "murica");
        
        AlbumController.create("Best", 1, 2020);
        AlbumController.create("Bester", 2, 2019);
        
        ArtistController.findByName("Eminem");
        AlbumController.findByArtist(1);
    }
    
}
