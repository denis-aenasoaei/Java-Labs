/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try
        {
           BufferedWriter writer = Files.newBufferedWriter(Paths.get(catalog.getPath()));
           writer.append(catalog.getName()).append("\n").append(catalog.getPath()).append("\n");
           for(Document d : catalog.getDocuments())
           {
               writer.append(d.getId()).append("\n").append(d.getName()).append("\n").append(d.getLocation()).append("\n");
               for(Map.Entry<String, Object> tg : d.getTags().entrySet())
               {
                   writer.append(tg.getKey()).append('\n').append(tg.getValue().toString()).append('\n');
               }
           }
           writer.flush();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void view(Document doc) {
    
    File file = new File(doc.getLocation());
    Desktop desktop ;
    desktop = Desktop.getDesktop();
    try{
        desktop.open(file);
    }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
    catch(IllegalArgumentException e)
    {
        System.out.println(e.getMessage());
    }

    try{
        desktop.browse(new URI(doc.getLocation()));
    }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }   
    catch (URISyntaxException ex) {
        System.out.println(ex.getMessage());
    }
    
    }
    
} 