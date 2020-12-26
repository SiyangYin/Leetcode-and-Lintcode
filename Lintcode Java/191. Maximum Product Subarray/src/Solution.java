public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int res = Integer.MIN_VALUE;
        int[] maxdp = new int[nums.length], mindp = new int[nums.length];
        maxdp[0] = mindp[0] = nums[0];
        res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a  = nums[i], b = nums[i] * maxdp[i - 1], c = nums[i] * mindp[i - 1];
            maxdp[i] = Math.max(a, Math.max(b, c));
            mindp[i] = Math.min(a, Math.min(b, c));
            
            res = Math.max(res, Math.max(maxdp[i], mindp[i]));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
