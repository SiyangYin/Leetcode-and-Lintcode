import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int x : nums) {
            res += map.getOrDefault(x - k, 0);
            if (k != 0) {
                res += map.getOrDefault(x + k, 0);
            }
            
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        return res;
    }
}
