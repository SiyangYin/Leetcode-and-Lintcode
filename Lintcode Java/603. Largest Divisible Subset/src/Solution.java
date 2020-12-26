import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);
        int maxLen = 0, longestLastIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                longestLastIndex = i;
            }
        }
        
        while (longestLastIndex != -1) {
            res.add(0, nums[longestLastIndex]);
            longestLastIndex = prev[longestLastIndex];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
