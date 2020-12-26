import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
    
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -9, 5, -2, 3};
        int k = 3;
        System.out.println(new Solution().maxSubArrayLen(nums, -8));
    }
}
