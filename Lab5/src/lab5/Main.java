/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;

public class Main {
 public static void main(String args[]) {
 Main app = new Main();
 app.testCreateSave();
 app.testLoadView();
 }

 private void testCreateSave() {
 Catalog catalog = new Catalog("Java Resources", "e:/java/catalog.ser");
 Document doc = new Document("java1", "Java Course 1",
 "https:////profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
 
 Document doc2 = new Document("random", "Random file", "e:/random.txt");
 doc.addTag("type", "Slides");
 catalog.add(doc);
 catalog.add(doc2);

 try
 {
    CatalogUtil.save(catalog);
 }
 catch(IOException e)
 {
     System.out.println(e.getMessage());
     
 }
 
 }

 private void testLoadView() {
    Catalog catalog = new Catalog();
    try{
       catalog = CatalogUtil.load("e:/java/catalog.ser");
      
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
        
        var doc2 = catalog.findById("random");
        CatalogUtil.view(doc2);
    }
    catch(InvalidCatalogException e)
    {
        System.out.println(e.getMessage());
    }
 }
}
