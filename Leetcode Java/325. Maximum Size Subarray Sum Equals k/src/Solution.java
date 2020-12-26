import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
    
        int cur = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (!memo.containsKey(cur)) {
                memo.put(cur, i + 1);
            }
            if (memo.containsKey(cur - k)) {
                res = Math.max(res, i + 1 - memo.get(cur - k));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(new Solution().maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }
}
