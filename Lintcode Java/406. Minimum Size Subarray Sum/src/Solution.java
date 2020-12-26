public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    
        int minLen = nums.length + 1;
        for (int j = 0, i = 0; j < nums.length; j++) {
            while (i <= j) {
                if (sum[j + 1] - sum[i] >= s) {
                    minLen = Math.min(minLen, j - i + 1);
                    i++;
                } else {
                    break;
                }
            }
        }
        
        return minLen == nums.length + 1 ? -1 : minLen;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumSize(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }
}
