import java.util.Arrays;

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = sum;
            if (i != res.length - 1) {
                sum += nums[i + k] - nums[i];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().winSum(new int[]{1, 2, 7, 8, 5}, 3)));
    }
}
