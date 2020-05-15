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
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        if (players.isEmpty())
            throw new NotFoundException("Could not find players");
        else
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
            int rs=stmt.executeUpdate("insert into players values ('" + name + "')");
            if(rs==0)
                throw new NotFoundException("Could not update, player does not exist");
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
            int rs=stmt.executeUpdate("update players set name = '"+ newName + "' where name = '" + oldName +"'");
            if(rs == 0)
                throw new NotFoundException("Could not find the player whose name is to change");
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
    @DeleteMapping
    public void deletePlayer(@RequestParam("name") String name)
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","student","STUDENT");
            Statement stmt=con.createStatement();
            int rs=stmt.executeUpdate("delete from players where name = '" + name + "'");

            if(rs == 0)
                throw new NotFoundException("Could not find the player, did not delete");
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
