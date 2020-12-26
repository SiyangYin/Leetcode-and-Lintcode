import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int findLHS(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + 1)) {
                res = Math.max(res, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        
        return res;
    }
}
