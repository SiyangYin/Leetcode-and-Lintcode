import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param a: The array.
     * @return: The number which has odd number of times or -1.
     */
    public int isValid(List<Integer> a) {
        // Write your code here
        if (a.size() % 2 == 0) {
            return -1;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : a) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
    
        int count = 0, val = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
                val = entry.getKey();
            }
        }
        
        return count == 1 ? val : -1;
    }
}
