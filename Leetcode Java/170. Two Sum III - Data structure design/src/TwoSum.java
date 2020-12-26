import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    private Map<Integer, Integer> map;
    
    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int n : map.keySet()) {
            if (n != value - n) {
                if (map.containsKey(value - n)) {
                    return true;
                }
            } else {
                if (map.get(n) >= 2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
