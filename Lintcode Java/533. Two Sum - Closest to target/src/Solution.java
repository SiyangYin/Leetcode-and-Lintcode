import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        
        int i = 0, j = nums.length - 1;
        int res = Integer.MAX_VALUE;
        
        while (i < j) {
            int sum = nums[i] + nums[j];
            res = Math.min(res, Math.abs(sum - target));
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return 0;
            }
        }
        
        return res;
    }
}
