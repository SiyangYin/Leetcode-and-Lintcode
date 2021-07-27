import java.util.Arrays;

public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = nums[0] + nums[nums.length - 1];
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            res = Math.max(res, nums[i] + nums[j]);
        }
        
        return res;
    }
}
