public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, prod = 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (j <= i && prod >= k) {
                prod /= nums[j];
                j++;
            }
            
            res += i - j + 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
