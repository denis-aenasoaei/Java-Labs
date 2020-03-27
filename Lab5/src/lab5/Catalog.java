/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denis
 */
public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        File file = new File(path);
        try
        {
            file.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    public Catalog() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nume= ").append(name).append("\n");
        sb.append("Path= ").append(path).append("\n");
        sb.append("Documents:\n");
        for(var document : documents)
            sb.append(document.toString() + "\n");
        return sb.toString();
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


 public void add(Document doc) {
    documents.add(doc);
 }
 public Document findById(String id) {
    for (Document doc : documents) {
        System.out.println(doc.getId());
        if (doc.getId().equals(id)) {
            return doc;
        }
    }
 return null;
 }
}
