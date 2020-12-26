public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录区间和，如果当前sum>0，那么可以继续和后面的数求和，否则就从0开始
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, -2, -3, 3, 1}));
    }
}
