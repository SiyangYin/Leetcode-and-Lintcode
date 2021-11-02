public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int res = 0;
        int l = 0, r = 0, far = 0;
        while (l <= r) {
            res++;
            for (int i = l; i <= r; i++) {
                far = Math.max(far, i + nums[i]);
                if (far >= nums.length - 1) {
                    return res;
                }
            }
            
            l = r + 1;
            r = far;
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
