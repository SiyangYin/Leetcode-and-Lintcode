import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res += entry.getKey();
            }
        }
        
        return res;
    }
}
