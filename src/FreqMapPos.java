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
public class FreqMapPos {
    
    HashMap<Integer, FreqMap> posMap;   

    public FreqMapPos() {
         posMap = new HashMap<>();
    }
    
    FreqMap getMap(Integer n) {
        FreqMap f = posMap.get(n);
        if (f == null) {
            f = new FreqMap();
            posMap.put(n, f);
        }
        return f;
    }

    Collection<FreqMap> getValues() {
        return posMap.values();
    }

    Iterable<Integer> getKeys() {
        return posMap.keySet();
    }
}
