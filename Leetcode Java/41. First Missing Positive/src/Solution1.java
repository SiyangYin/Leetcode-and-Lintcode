public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            set(nums, i, true);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void set(int[] nums, int i, boolean start) {
        int next = nums[i];
        if (!start) {
            nums[i] = i + 1;
        }
        if (next > 0 && next <= nums.length && next != i + 1) {
            set(nums, next - 1, false);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(new Solution1().firstMissingPositive(nums));
    }
}
