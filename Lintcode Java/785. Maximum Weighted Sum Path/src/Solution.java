public class Solution {
    /**
     * @param nums:
     * @return: maximum path sum
     */
    public int maxWeight(int[][] nums) {
        // Write your code here
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[0].length - 1; j >= 0; j--) {
                int max = Integer.MIN_VALUE;
                if (i - 1 >= 0) {
                    max = Math.max(max, nums[i - 1][j]);
                }
                if (j + 1 <= nums[0].length - 1) {
                    max = Math.max(max, nums[i][j + 1]);
                }
                
                
                nums[i][j] += max == Integer.MIN_VALUE ? 0 : max;
            }
        }
        
        return nums[nums.length - 1][0];
    }
}
