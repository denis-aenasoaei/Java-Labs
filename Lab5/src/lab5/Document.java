/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author denis
 */
public class Document implements Serializable {
    private String id;
    private String name;
    private String location; 

    private Map<String, Object> tags = new HashMap<>();
    
    public Document()
    {
        
    }
    
    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        File file = new File(location);
        
        try
        {
            file.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String toString()
    {
        return "Document{ \n" + "id= " + id + "; name= " + name + "; location= " + location +"\n}";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
 
    public void addTag(String key, Object obj) {
       tags.put(key, obj);
    }
}