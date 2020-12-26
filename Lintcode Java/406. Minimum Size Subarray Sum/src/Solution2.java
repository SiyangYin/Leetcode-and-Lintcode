public class Solution2 {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int sum = 0;
        int minLen = nums.length + 1;
    
        for (int j = 0, i = 0; j < nums.length; j++) {
            sum += nums[j];
            while (i <= j) {
                if (sum >= s) {
                    minLen = Math.min(minLen, j - i + 1);
                    sum -= nums[i];
                    i++;
                } else {
                    break;
                }
            }
        }
        
        return minLen == nums.length + 1 ? -1 : minLen;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().minimumSize(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }
}
