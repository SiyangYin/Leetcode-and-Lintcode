import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        k %= nums.length;
        flip(nums, 0, nums.length - 1);
        flip(nums, 0, k - 1);
        flip(nums, k, nums.length - 1);
        return nums;
    }
    
    private void flip(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new Solution().rotate(nums, k)));
    }
}
