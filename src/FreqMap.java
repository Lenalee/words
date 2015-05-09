

import java.util.HashMap;

/**
 *
 * @author Hikari
 */

public class FreqMap {
    
    HashMap<String, Integer> C;
    HashMap<String, Double> B;
    Integer total;
    
    FreqMap() {
        C = new HashMap<>();
        total = 0;
        B = new HashMap<>();
    }
     
    void count_char(String s){
        Integer val = C.getOrDefault(s, 0);
        C.put(s, val+1);
        total = total + 1;
    }
    
    void calc_frekvence() {
        C.remove("'");
        C.remove("");
        for(String s: C.keySet()){
            Double val =  C.get(s).doubleValue()/total;
            B.put(s, val);
        }
        
    }
     
    Double getFreq(String s) {
        return B.get(s);
    }

    Iterable<String> getKeys() {
        return B.keySet();
    }
    
}
