import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                nums[i + 1] += nums[i];
            }
            if (k != 0) {
                nums[i] %= k;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) >= 2) {
                return true;
            }
            
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(new Solution().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 0));
        System.out.println(new Solution().checkSubarraySum(new int[]{0, 0}, 0));
        System.out.println(new Solution().checkSubarraySum(new int[]{0}, 0));
    }
}
