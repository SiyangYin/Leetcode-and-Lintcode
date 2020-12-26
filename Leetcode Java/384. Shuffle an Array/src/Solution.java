import java.util.Random;

public class Solution {
    
    private int[] nums, orig;
    
    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        this.orig = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = this.orig[i] = nums[i];
        }
    }
    
    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return orig;
    }
    
    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = random.nextInt(i + 1);
            swap(nums, idx, i);
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
