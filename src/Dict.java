
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
   
    public Dict(){
        list = new ArrayList<>();
    }
    
    void add(final String s){
        list.add(s);
    }
    String[] split(String k) {
        return k.split("");
    }
    // _ matches for any letter
    Boolean matchMask(final String mask, final String word) {
        if (mask.length() != word.length()) 
            return false;
        Integer pos = 0;
        for(String s: split(mask)) {
           pos = pos + 1;
        
        }
        return true;
    }
    
    Dict reduceDict(String mask) {
        Dict newDict = new Dict();
        
        return newDict;
    }
}
