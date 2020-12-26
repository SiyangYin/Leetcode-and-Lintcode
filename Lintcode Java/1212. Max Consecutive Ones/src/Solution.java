public class Solution {
    /**
     * @param nums: a binary array
     * @return:  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int j = i;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                
                res = Math.max(res, j - i);
                i = j - 1;
            }
        }
        
        return res;
    }
}
