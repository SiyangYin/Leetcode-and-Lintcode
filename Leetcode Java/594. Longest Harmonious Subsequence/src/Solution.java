import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (map.containsKey(key + 1)) {
                res = Math.max(res, val + map.get(key + 1));
            }
        }
        
        return res;
    }
}
