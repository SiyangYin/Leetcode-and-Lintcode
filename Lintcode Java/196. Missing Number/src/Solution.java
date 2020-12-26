public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        
        return res ^ nums.length;
    }
}
