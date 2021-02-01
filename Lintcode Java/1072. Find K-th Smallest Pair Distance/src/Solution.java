import java.util.Arrays;

public class Solution {
    /**
     * @param nums: a list of integers
     * @param k:    a integer
     * @return: return a integer
     */
    public int smallestDistancePair(int[] nums, int k) {
        // write your code here
        Arrays.sort(nums);
        
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int m = l + (r - l >> 1);
            if (count(nums, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private int count(int[] nums, int d) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > d) {
                j++;
            }
            
            count += i - j;
        }
        
        return count;
    }
}
