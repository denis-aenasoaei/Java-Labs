/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author denis
 */
public class ViewCommand {
    public static void runCommand(Document doc)
    {
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
