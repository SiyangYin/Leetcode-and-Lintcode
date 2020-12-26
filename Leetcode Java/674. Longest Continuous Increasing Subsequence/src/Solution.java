public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int cur = 1, res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
            } else {
                cur = 1;
            }
            res = Math.max(res, cur);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}
