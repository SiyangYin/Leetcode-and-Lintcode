import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int pos = 0, l = 0, r = nums.length - 1;
        while ((pos = partition(nums, l, r)) != nums.length - k) {
            if (pos < nums.length - k) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        
        int[] res = new int[k];
        Arrays.sort(nums, nums.length - k, nums.length);
        for (int i = nums.length - k; i < nums.length; i++) {
            res[i - nums.length + k] = nums[2 * nums.length - k - 1 - i];
        }
        
        return res;
    }
    
    private int partition(int[] nums, int l, int r) {
        int m = l + (r - l >> 1);
        int tmp = nums[l];
        nums[l] = nums[m];
        nums[m] = tmp;
        
        int pivot = nums[l];
        while (l < r) {
            while (l < r && pivot <= nums[r]) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && pivot >= nums[l]) {
                l++;
            }
            nums[r] = nums[l];
        }
        
        nums[l] = pivot;
        return l;
    }
}
