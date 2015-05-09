/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Hikari
 */
public class FreqMapLenPos {
    
    HashMap<Integer, FreqMapPos> lenposMap;   

    public FreqMapLenPos() {
         lenposMap = new HashMap<>();
    }
    
    FreqMapPos getMapPos(Integer n) {
        FreqMapPos f = lenposMap.get(n);
        if (f == null) {
            f = new FreqMapPos();
            lenposMap.put(n, f);
        }
        return f;
    }
    
    FreqMap getMap(Integer pos, Integer len){
        FreqMapPos f = getMapPos(len);
        return f.getMap(pos);
    }

    Collection<FreqMapPos> getValues() {
        return lenposMap.values();
    }

}
        
       
