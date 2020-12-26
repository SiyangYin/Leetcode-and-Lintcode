import java.util.Arrays;

public class Solution {
    
    public void sortColors(int[] nums) {
        int zero = -1;  // [0...zero]==0
        int two = nums.length;  // [two...nums.length-1]==2
        int index = 0;
        while (index < two) {
            if (nums[index] == 0) {
                swap(nums, ++zero, index++);
            } else if (nums[index] == 2) {
                swap(nums, --two, index);
            } else {
                index++;
            }
//            System.out.println(index + " " + zero);
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        new Solution().sortColors(new int[]{0, 0, 0, 2, 1, 1, 0});
    }
}
