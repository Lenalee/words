/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;

/*
 * @author Hikari
 */

public class Rocnik {
    
    static FreqCounter Counter = new FreqCounter();

    public static void main(String[] args) {
        readFile("C:\\Words\\wordsEn.txt");
    }
    
    static void readFile(String fn) {
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fn);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                Counter.process_line(line);
            }
            
            Counter.calc_frekvence();
            Counter.napis();
           
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '"+ fn + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '"+ fn + "'");
        }
    }
}
