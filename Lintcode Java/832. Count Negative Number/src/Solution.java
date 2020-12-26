public class Solution {
    /**
     * @param nums: the sorted matrix
     * @return: the number of Negative Number
     */
    public int countNumber(int[][] nums) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = binarySearch(nums[i]);
            if (idx == -1) {
                res += nums[i].length;
            } else {
                res += idx;
            }
        }
        
        return res;
    }
    
    private int binarySearch(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] >= 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        if (nums[l] >= 0) {
            return l;
        } else {
            return -1;
        }
    }
}
