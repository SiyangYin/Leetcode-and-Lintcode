public class Solution {
    public int singleNumber(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur ^= nums[i];
        }
        
        return cur;
    }
}
