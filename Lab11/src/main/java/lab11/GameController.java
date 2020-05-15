package lab11;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

@RestController
@RequestMapping("/games")


public class GameController {
    @GetMapping
    public Game getGame(@RequestParam("id") int id){
        Game g = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select player1, player2, date, result from games where id="+ id);
            while(rs.next()){
                g.player1 = new Player(rs.getString(1));
                g.player2 = new Player(rs.getString(2));
                g.gameId = id;
                g.dateEnded = new Date(rs.getDate(3).getTime());
                g.winner = rs.getInt(4);
            }

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        if (g == null)
            throw new NotFoundException("Could not find game with id " + id);
        else
            return g;

    }

    @PostMapping
    public void saveGame(@RequestParam("p1") String pl1, @RequestParam("p2") String pl2,
                    @RequestParam("date") Date d, @RequestParam("id") int id , @RequestParam("winner") int win)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            boolean rs=stmt.execute("insert into games values (" + id + ", '" + pl1 +"', '" + pl2 +
                    "', TO_DATE(" + d.toString() +", 'DD-MM-YYYY'), " + win + ")");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
