import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array
     * @return: the sum of min(ai, bi) for all i from 1 to n
     */
    public int arrayPairSum(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        
        return res;
    }
}
