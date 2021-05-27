public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        for (int i = 0, j = -1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (j == -1) {
                    j = i;
                } else {
                    if (i - j <= k) {
                        return false;
                    } else {
                        j = i;
                    }
                }
            }
        }
        
        return true;
    }
}
