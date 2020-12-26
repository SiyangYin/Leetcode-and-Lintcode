public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length + 1, sum = 0;
        for (int i = 0, j = 0; j < nums.length; ) {
            sum += nums[j];
            while (sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        
        return res == nums.length + 1 ? 0 : res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{7}));
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 7, 2, 7, 3}));
    }
}
