import java.util.Arrays;

public class Solution2 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int res = 0;
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            
            while (i > j && nums[i] - nums[j] > k) {
                j++;
            }
            
            if (i > j && nums[i] - nums[j] == k) {
                res++;
            }
        }
        
        return res;
    }
}
