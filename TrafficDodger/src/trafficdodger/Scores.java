/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Marchetti
 */
public class Scores {
 
    private ArrayList<String> strings;
    private ArrayList<Integer> ints;
    Player player;
    public Scores(){
     
        readAndSort();
       
    }
    
    public ArrayList getStringList(){
        return strings;
    }
    
    public ArrayList getIntList(){
        return ints;
    }
    
    public void readAndSort(){
        strings = new ArrayList<>();
        ints = new ArrayList<>();
        
       try (BufferedReader bringItIn = new BufferedReader(new FileReader("listOfScores.txt"))) {
            String info = "";
        
            while((info = bringItIn.readLine()) != null){
                String pieces[] = info.split(" ");
                strings.add(pieces[0]);
                ints.add(Integer.parseInt(pieces[1]));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        
        for(int i = 0; i < ints.size(); i++){
            
            for(int j = i + 1; j < ints.size(); j++){
                int temp = 0;
                String name = "";
                if(ints.get(i) < ints.get(j)){
                    temp = ints.get(j);
                    name = strings.get(j);
                    
                    ints.set(j, ints.get(i));
                    strings.set(j, strings.get(i));
                   
                    ints.set(i, temp);
                    strings.set(i, name);
                }

            }
                    
        }

    }
    
    public void writeToFile(String userName, int score){                
        try{
            BufferedWriter w = new BufferedWriter(new FileWriter("listOfScores.txt"));
            
            for(int i = 0; i < strings.size(); i++)
            {
                w.write(strings.get(i) + " " + ints.get(i));
                w.newLine();
                w.flush();
            }
            
            w.write(userName + " " + score);
            w.newLine();
            w.flush();
            w.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }  
    }
}
