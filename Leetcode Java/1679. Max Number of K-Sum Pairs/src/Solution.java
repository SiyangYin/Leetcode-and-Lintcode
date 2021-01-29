import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(k - nums[i], 0) >= 1) {
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
                
                res++;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        return res;
    }
}
