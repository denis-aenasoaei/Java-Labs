package lab11;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")

public class PlayerController {
    @GetMapping
    public List<Player> getPlayers()
    {
        ArrayList<Player> players = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select name from players");
            while(rs.next()){
                players.add(new Player(rs.getString(1)));
            }
            for(var p :players)
            {
                System.out.println(p.name);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return players;
    }
    @PostMapping
    public void addPlayer(@RequestParam("name") String name)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            boolean rs=stmt.execute("insert into players values ('" + name + "')");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    @PutMapping
    public void changeName(@RequestParam("oldName") String oldName, @RequestParam("newName") String newName)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            boolean rs=stmt.execute("update players set name = '"+ newName + "' where name = '" + oldName +"'");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    @DeleteMapping
    public void deletePlayer(@RequestParam("name") String name)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            boolean rs=stmt.execute("delete from players where name = '" + name + "'");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

}
