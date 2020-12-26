import java.util.Arrays;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= nums.length - 2 || nums[i] != nums[i + 1] || nums[i] != nums[i + 2]) {
                nums[j++] = nums[i];
            }
        }
    
        System.out.println(Arrays.toString(nums));
    
        return j;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(new Solution2().removeDuplicates(nums));
    }
}
