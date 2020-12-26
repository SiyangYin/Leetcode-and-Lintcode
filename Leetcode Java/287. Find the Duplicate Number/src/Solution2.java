public class Solution2 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
