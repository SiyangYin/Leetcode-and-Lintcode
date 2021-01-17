import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        
        if (sum == 0) {
            return 0;
        }
        
        int res = n;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0, preSum = 0; i < n; i++) {
            preSum = (preSum + nums[i]) % p;
            
            int key = (preSum - sum + p) % p;
            if (map.containsKey(key)) {
                int l = map.get(key);
                res = Math.min(res, i + 1 - l);
            }
            
            map.put(preSum, i + 1);
        }
        
        return res == n ? -1 : res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSubarray(new int[]{3, 1, 4, 2}, 6));
        System.out.println(new Solution().minSubarray(new int[]{6, 3, 5, 2}, 9));
        System.out.println(new Solution().minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3));
    }
}
