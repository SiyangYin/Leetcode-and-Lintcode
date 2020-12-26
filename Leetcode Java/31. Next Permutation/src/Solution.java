import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int idx = binarySearch(nums, i, nums.length - 1, nums[i - 1]);
        swap(nums, i - 1, idx);
        reverse(nums, i, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (nums[m] > target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
