/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;

/**
 *
 * @author denis
 */
public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath())))
        {
           oos.writeObject(catalog);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog cat = new Catalog("", "");

        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) 
        {
          cat = (Catalog) ois.readObject();
        }
        catch (IOException ioe) {
          throw new InvalidCatalogException(ioe);
        }
        catch (ClassNotFoundException cnfe) {
          System.out.println("Error loading catalog");
        }
        
        return cat;
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
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    
    
    }
    
} 