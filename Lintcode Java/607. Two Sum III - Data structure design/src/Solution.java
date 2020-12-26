import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int i : map.keySet()) {
            if (value - i == i && map.get(i) >= 2) {
                return true;
            } else if (value - i != i && map.containsKey(value - i)) {
                return true;
            }
            
        }
        
        return false;
    }
}
