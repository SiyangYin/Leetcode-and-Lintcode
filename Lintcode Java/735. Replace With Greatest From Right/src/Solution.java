public class Solution {
    /**
     * @param nums: An array of integers.
     * @return: nothing
     */
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        // Write your code here.
        int curMax = nums[nums.length - 1];
        nums[nums.length - 1] = -1;
    
        for (int i = nums.length - 2; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = curMax;
            curMax = Math.max(curMax, tmp);
        }
    }
}
