import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the minimum length of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsKII(int[] nums, int k) {
        // write your code here
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 0);
        
        int sum = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                res = Math.min(res, i + 1 - preSum.get(sum - k));
            }
            preSum.put(sum, i + 1);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public static void main(String[] args) {
        // int[] nums = {1, 1, 1, 2};
        int[] nums = {2, 1, -1, 4, 2, -3};
        int k = 33;
        System.out.println(new Solution().subarraySumEqualsKII(nums, k));
    }
}
