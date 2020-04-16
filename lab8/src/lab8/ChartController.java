package lab8;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChartController {
    public static void create(String name, ArrayList<Album> albums)
    {
        try {
            Database db = Database.getInstance();
            var chartStmt = db.connection.createStatement();
            var rs = chartStmt.executeQuery("Select max(id) from charts");
            int maxId=0;
            while(rs.next())
            {
                maxId = rs.getInt(1);
            }
            for(int i=0;i<albums.size();i++)
            {
                var stmt = db.connection.createStatement();
                stmt.execute("Insert into chart_entry(album_id, position, chart_id) values (" + albums.get(i).getId() 
                        + ","+ i + "," + (maxId + 1) +")");
            }
            chartStmt = db.connection.createStatement();
            chartStmt.execute("Insert into charts (name) values ('" + name + "')");
            db.connection.commit();
            
        } catch (SQLException ex) {
            System.out.println("Error entering chart\n" + ex.getMessage());
        }
    }
    
    public static Chart getById(int id)
    {
        Chart chart = new Chart();
        try {
            Database db = Database.getInstance();
            var stmt = db.connection.createStatement();
            var rs = stmt.executeQuery("Select id, name from charts where id = " + id);
            while(rs.next())
            {
                chart.setId(rs.getInt(1));
                chart.setName(rs.getString(2));
            }
            stmt = db.connection.createStatement();
            rs = stmt.executeQuery("Select a.id as id, a.name as name, a.artist_id as artist_id, a.release_year as release_year"
                    + " from albums a join chart_entry c on a.id = c.album_id where c.chart_id = " + chart.getId());
            while(rs.next())
            {
                chart.addAlbum(new Album(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }
            
            return chart;
        } catch (SQLException ex) {
            System.out.println("Error getting chart \n" + ex.getMessage());
        }
        return null;
    }
}
