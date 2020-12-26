import java.util.Arrays;

public class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            res = Math.min(res, nums[nums.length - 1 - i] - nums[3 - i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minDifference(new int[]{5, 3, 2, 4}));
        System.out.println(new Solution().minDifference(new int[]{1, 5, 0, 10, 14}));
    }
}
