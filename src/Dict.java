
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hikari
 */
public class Dict {
    ArrayList<String> list;
   
    public class Dict {
    
    FreqMapPos pos;
    
    ArrayList<String> list;
   
    public Dict(){
        list = new ArrayList<>();
        pos = new FreqMapPos();
        
    }
    
    void add(final String s){
        list.add(s);
    }
    String[] split(String k) {
        return k.split("");
    }
    // _ matches for any letter
    static Boolean matchMask(final String mask, final String word) {
        if (mask.length() != word.length()) {
            return false;
        }  
        
        Integer pos = 0;
        String[] maskk = mask.split("");
        
        for(String s: word.split("")) {
            if(maskk[pos].equals("_") ||  s.equals(maskk[pos])) {
                pos = pos +1;
              } else {
                return false;
            }   
        }
        return true;
    }
     
    
    Dict reduceDict(String mask) {
        Dict newDict = new Dict();
        for(String s : list){
            if(matchMask(mask, s)) {
                newDict.add(s);
            }
        }
        newDict.frekvence();
        return newDict;
    }
    
    void frekvence() {
        for(String word : list) {
            int i = 0;   
            for(String cha : word.split(word)){
                FreqMap pos_freq = pos.getMap(i);
                pos_freq.count_char(cha);
                i = i + 1;
            }
        }
        for(FreqMap f : pos.getValues()) {
            f.calc_frekvence();
        }
    }
    Pary maxFreq(){
        double max = 0;
        Integer maxPos = 0;
        String maxch = "";
        for(Integer i : pos.getKeys()){
            FreqMap f = pos.posMap.get(i);
            for(String s: f.getKeys()){
                double freq = f.getFreq(s);
                if(freq > max){
                   max = freq;
                   maxch = s;
                   maxPos = i;
                }
                
            }
        
        }
        return new Pary(maxPos,maxch);
    }
}

   
