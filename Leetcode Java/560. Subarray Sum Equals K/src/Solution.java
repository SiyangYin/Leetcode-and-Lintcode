import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i] - k)) {
                res += map.get(preSum[i] - k);
            }
            
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        
        return res;
    }
}
