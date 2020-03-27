/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author denis
 */
public class ListCommand implements Command{

    @Override
    public void runCommand(Catalog cat) throws InvalidCatalogException {
        
        try
        {
            for(Document doc : cat.getDocuments())
            {
                System.out.println(doc.toString());
            }
        }
        catch(Exception e)
        {
            System.out.println("Error" + e.getMessage());
            throw new InvalidCatalogException(e);
        }
    }
    
}
