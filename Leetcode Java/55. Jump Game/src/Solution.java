public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        reachable[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            boolean reachable0 = false;
            for (int j = Math.min(i + nums[i], nums.length - 1); j >= i + 1; j--) {
                reachable0 |= reachable[j];
                if (reachable0) {
                    break;
                }
            }
            reachable[i] = reachable0;
        }
        return reachable[0];
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
