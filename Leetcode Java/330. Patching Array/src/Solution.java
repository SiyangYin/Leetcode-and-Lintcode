public class Solution {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int res = 0;
        for (int i = 0; x <= n; ) {
            if (i < nums.length && nums[i] <= x) {
                x += nums[i++];
            } else {
                x += x;
                res++;
            }
        }
        
        return res;
    }
}
