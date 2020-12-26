import java.util.Arrays;

public class Solution {
    public int twoSumGreater(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                res += j - i;
                j--;
            } else {
                i++;
            }
        }
        
        return res;
    }
}
