public class Solution {
    /**
     * @param nums: an array
     * @param k:    an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        double res = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            res = Math.max(res, sum / k);
        }
        
        return res;
    }
}
