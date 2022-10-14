public class Solution1 {
    public boolean canJump(int[] nums) {
        int l = 0, r = 0, far = -1;
        while (l <= r) {
            for (int i = l; i <= r; i++) {
                if (i + nums[i] > far) {
                    far = i + nums[i];
                    if (far >= nums.length - 1) return true;
                }
            }
            l = r + 1;
            r = far;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution1().canJump(new int[]{1, 0, 10, 1, 4}));
    }
}
