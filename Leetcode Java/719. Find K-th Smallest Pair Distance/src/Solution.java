import java.util.Arrays;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int m = l + (r - l >> 1);
            int count = 0;
            for (int i = 0, j = 0; i < nums.length; i++) {
                while (j < i && nums[i] - nums[j] > m) {
                    j++;
                }
                
                count += i - j;
            }
            
            if (count >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}
