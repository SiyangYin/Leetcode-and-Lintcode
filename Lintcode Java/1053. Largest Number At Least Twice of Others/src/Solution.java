public class Solution {
    /**
     * @param nums: a integer array
     * @return: the index of the largest element
     */
    public int dominantIndex(int[] nums) {
        // Write your code here
        int max = -1, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (i != res && max < nums[i] * 2) {
                flag = false;
            }
        }
        
        return flag ? res : -1;
    }
}
