import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int findLHS(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            map.putIfAbsent(nums[r], r);
            if (nums[r] == nums[l]) {
                continue;
            }
            
            if (nums[r] == nums[l] + 1) {
                res = Math.max(res, r - l + 1);
            } else {
                if (nums[r] == nums[r - 1] + 1) {
                    l = map.get(nums[r - 1]);
                } else {
                    l = map.get(nums[r]);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
