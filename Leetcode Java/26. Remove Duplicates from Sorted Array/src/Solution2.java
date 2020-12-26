import java.util.Arrays;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().removeDuplicates(new int[]{1, 1, 2}));
    }
}
