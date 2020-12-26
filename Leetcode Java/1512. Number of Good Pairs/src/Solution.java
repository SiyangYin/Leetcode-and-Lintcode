import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
    
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        
        return res;
    }
}
