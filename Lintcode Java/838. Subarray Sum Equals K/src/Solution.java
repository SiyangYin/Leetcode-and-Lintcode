import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        int res = 0;
        for (int i = 0; i < sum.length; i++) {
            if (map.containsKey(sum[i] - k)) {
                res += map.get(sum[i] - k);
            }
            
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subarraySumEqualsK(new int[]{1, 1, 1}, 2));
    }
}
