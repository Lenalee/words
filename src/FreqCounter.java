/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;

/**
 *
 * @author Hikari
 */
public class FreqCounter {
    
    FreqMapPos lenMap = new FreqMapPos();
    FreqMapPos posMap = new FreqMapPos();   
    FreqMap globalMap = new FreqMap();
    FreqMapLenPos lenposMap = new FreqMapLenPos();
    
    String[] split(String k) {
        return k.split("");
    }

    void process_line(String S) {
        // метод разделяет сторку на буквы и делит их по длине
        // (внизу в цикле) как часто на какой позиции встречаются буквы
        Integer len = S.length();
        FreqMap freq = lenMap.getMap(len);

        Integer pos = 0;
        for(String s: split(S)) {
            globalMap.count_char(s);
            freq.count_char(s);
            FreqMap pos_freq = posMap.getMap(pos);
            pos_freq.count_char(s);
            pos = pos + 1;
            lenposMap.getMap(pos, len).count_char(s);          
        }
    }

    void calc_frekvence() {
        globalMap.calc_frekvence();
        
        for(FreqMap f : posMap.getValues()) {
            f.calc_frekvence();
        }
        
        for(FreqMap f : lenMap.getValues()) {
            f.calc_frekvence();
        }
        
        for(FreqMapPos f : lenposMap.getValues()) {
            for(FreqMap ff: f.getValues()) {
                ff.calc_frekvence();
            }
        }
    }
   
    
    void napis() {
        System.out.println("Global Freq:");
        for(String k : globalMap.getKeys()) {
            System.out.format("%s : %.06f\n", k, globalMap.getFreq(k));
        }
        System.out.println("Len Freq:");
        for(String k : globalMap.getKeys()) {
            System.out.format("%s :", k);
            for(Integer len : lenMap.getKeys()) {
                Double v = lenMap.getMap(len).getFreq(k);
                System.out.format(" %.06f", v == null? 0.0 : v);
            }
            System.out.println();
        }
        
        System.out.println("Pos Freq:");
        for(String k : globalMap.getKeys()) {
            System.out.format("%s :", k);
            for(Integer len : posMap.getKeys()) {
                Double v = posMap.getMap(len).getFreq(k);
                System.out.format(" %.06f", v == null? 0.0 : v);
            }
            System.out.println();
        }   
    }
}

