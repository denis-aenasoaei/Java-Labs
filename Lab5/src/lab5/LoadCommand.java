/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author denis
 */
public class LoadCommand{

    public static Catalog runCommand(String path) throws IOException {
        Catalog cat = new Catalog("", "");
        String line;
        try 
        {
           BufferedReader reader = Files.newBufferedReader(Paths.get(path));
           cat.setName(reader.readLine());
           cat.setPath(reader.readLine());
           while((line = reader.readLine()) != null)
           {
                Document doc = new Document();
                doc.setId(line);
                if((line = reader.readLine()) != null)
                    doc.setName(line);
                if((line = reader.readLine()) != null)
                    doc.setLocation(line);
                if((line = reader.readLine()) != null)
                {
                    String value = reader.readLine();
                    doc.addTag(line, value);
                }
                cat.add(doc);
           }
           reader.close();
        }
        catch (IOException ioe) {
          throw new IOException("Could not load catalog");
        }
        
        return cat;
    }
    
}
