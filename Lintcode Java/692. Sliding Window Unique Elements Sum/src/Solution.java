import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: the given array
     * @param k:    the window size
     * @return: the sum of the count of unique elements in each window
     */
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int unique = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                unique++;
            }
        }
        
        if (k >= nums.length) {
            return unique;
        }
        
        int res = unique;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] == nums[i - k]) {
                res += unique;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) == 1) {
                    unique++;
                } else if (map.get(nums[i]) == 2) {
                    unique--;
                }
                
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                if (map.get(nums[i - k]) == 0) {
                    unique--;
                    map.remove(nums[i - k]);
                } else if (map.get(nums[i - k]) == 1) {
                    unique++;
                }
                
                res += unique;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;
        System.out.println(new Solution().slidingWindowUniqueElementsSum(nums, k));
    }
}
