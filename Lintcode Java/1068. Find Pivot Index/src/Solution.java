public class Solution {
    /**
     * @param nums: an array
     * @return: the "pivot" index of this array
     */
    public int pivotIndex(int[] nums) {
        // Write your code here
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] == preSum[nums.length] - preSum[i + 1]) {
                return i;
            }
        }
        
        return -1;
    }
}
