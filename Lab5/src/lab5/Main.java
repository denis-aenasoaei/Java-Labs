/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;
import java.util.Scanner;

public class Main {
 public static void main(String args[]) {
     Scanner scanner = new Scanner(System.in);
     String catName;
     String path;
     Catalog loadedCat = new Catalog();
     String cmdName;
     boolean first = true;
     while(true)
     {
         try{
             System.out.println("Java Console> ");
             cmdName = scanner.next();
             if( cmdName.contains("load"))
                 loadedCat = LoadCommand.runCommand(scanner.next());
             if(cmdName.contains("list"))
             {
                 var lCMD = new ListCommand();
                 lCMD.runCommand(loadedCat);
             }
             if(cmdName.contains("view"))
                 ViewCommand.runCommand(loadedCat.findById(scanner.next()));
             if(cmdName.contains("html"))
                {
                    HtmlReportCommand.runCommand(loadedCat);
                    
                }
        }
         catch(Exception e)
         {
             System.out.println("Invalid arguments. Please try again");
         }
             
         
     }
 }

}
