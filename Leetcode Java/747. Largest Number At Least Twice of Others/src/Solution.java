public class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
    
        for (int x : nums) {
            if (x != max && max < 2 * x) {
                return -1;
            }
        }
        
        return idx;
    }
}
