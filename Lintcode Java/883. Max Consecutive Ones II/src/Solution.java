public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int res = 0, zeroCount = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            
            while (j <= i && zeroCount > 1) {
                if (nums[j] == 0) {
                    zeroCount--;
                }
                j++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
    }
}
