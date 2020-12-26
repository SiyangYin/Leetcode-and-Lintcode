import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int findShortestSubArray(int[] nums) {
        // write your code here
        Map<Integer, int[]> map = new HashMap<>();
        int res = nums.length, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
            }
    
            maxCount = Math.max(maxCount, map.get(nums[i])[0]);
        }
    
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] == maxCount) {
                res = Math.min(res, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
