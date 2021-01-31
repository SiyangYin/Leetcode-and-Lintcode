import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param array: An array.
     * @return: An integer.
     */
    public int findNumber(int[] array) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int res = 0, maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(),val = entry.getValue();
            if (val > maxCount) {
                maxCount = Math.max(maxCount, val);
                res = key;
            } else if (val == maxCount) {
                res = Math.min(res, key);
            }
        }
        
        return res;
    }
}
