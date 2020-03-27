/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class HtmlReportCommand {
    public static void runCommand(Catalog cat)
    {
        File htmlFile = new File("e:/java/" + cat.getName() + ".html");
        try
        {
            htmlFile.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
           BufferedWriter writer = Files.newBufferedWriter(htmlFile.toPath());
           writer.append("<h1>").append(cat.getName()).append("</h1>").append("<br>");
           for(Document d : cat.getDocuments())
           {
               writer.append("<h3>").append(d.getId()).append("<br>").append(d.getName()).append("<br>").append(d.getLocation()).append("<br>").append("</h3>");
               for(Map.Entry<String, Object> tg : d.getTags().entrySet())
               {
                   writer.append(tg.getKey()).append(" = ").append(tg.getValue().toString()).append("<br>");
               }
           }
           writer.flush();  
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
