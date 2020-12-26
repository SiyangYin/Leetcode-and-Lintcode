import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1;  // [0...i]
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                if (nums[i] != nums[i - 1]) {
                    nums[++i] = nums[j];
                }
            } else {
                nums[++i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
