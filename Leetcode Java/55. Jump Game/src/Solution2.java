public class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
    
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= nums.length - 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution2().canJump(new int[]{1, 0, 10, 1, 4}));
    }
}
