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
public class ArtistController {
    public static void create(String name, String country)
    {
        Database db = Database.getInstance();
        ArrayList<String> columns = new ArrayList<>();
        columns.add("name");
        columns.add("country");
        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        values.add(country);
        db.executeCreateArtistQuery("Artists", columns, values);
    }
    public static void findByName( String name)
    {
        Database db = Database.getInstance();
        ArrayList<String> res = new ArrayList<>();
        res = db.executeSelectQuery("Select * from artists where name like'%" + name+"%'");
        for(String r : res)
        {
            System.out.println(r);
        }
    }
}
