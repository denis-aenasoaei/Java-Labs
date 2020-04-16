/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.sql.SQLException;

/**
 *
 * @author denis
 */
public class ArtistController {
    public static void create(String name, String country)
    {
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            String sql = "Insert into artists(name, country) values ('" + name + "', '" + country + "')"; 
            stmt.execute(sql);
            db.connection.commit();
        } catch (SQLException ex) {
            System.out.println("Couldn't insert into artists");
        }
        
    }
    public static Artist findByName( String name)
    {
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            String sql = "Select * from artists where name like'%" + name+"%'";
            var rs = stmt.executeQuery(sql);
            Artist ar = new Artist();
            
            while(rs.next())
            {
                ar.setId(rs.getInt(1));
                ar.setName(rs.getString(2));
                ar.setCountry(rs.getString(3));
            }
            return ar;
            
        } catch (SQLException ex) {
            System.out.println("Error finding artist\n" + ex.getMessage());
        }
        return null;
    }
}
