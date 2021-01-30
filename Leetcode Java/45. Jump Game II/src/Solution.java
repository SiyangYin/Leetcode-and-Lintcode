public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0, farthest = 0, curEnd = 0;
        
        for (int i = 0; i <= curEnd; i++) {
            if (curEnd >= nums.length - 1) {
                return res;
            }
            
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {
                res++;
                curEnd = farthest;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump(new int[]{1, 2, 1, 1, 1}));
        System.out.println(new Solution().jump(new int[]{0}));
        System.out.println(new Solution().jump(new int[]{1}));
        System.out.println(new Solution().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }
}
