import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums:   the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int prev = target - nums[i];
            if (Math.abs(nums[0]) <= Math.abs(prev) && Math.abs(prev) <= Math.abs(nums[i - 1])) {
                int idx = binarySearch(nums, i - 1, Math.abs(prev));
                if (prev == nums[idx]) {
                    res.add(Arrays.asList(idx, i));
                }
                if (idx + 1 < i && prev == nums[idx + 1]) {
                    res.add(Arrays.asList(idx + 1, i));
                }
            }
        }
        
        return res;
    }
    
    private int binarySearch(int[] nums, int r, int t) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (Math.abs(nums[m]) >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().twoSumVII(new int[]{0, -1, 2, -3, 4}, 1));
    }
}
