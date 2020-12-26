import java.util.Arrays;

public class Solution {
    /**
     * @param n: the integer
     * @return: the numbers that larger and smaller than `n`
     */
    public int[] getNumbers(int n) {
        // Write your code here
        if (n < 0) {
            return new int[0];
        }
        
        int[] dp = {0, 1};
        int less = Integer.MAX_VALUE, more = 0;
        boolean moreFound = false;
        int idx = 0;
        while (dp[idx & 1] <= n) {
            int tmp = dp[idx + 1 & 1];
            dp[idx & 1] += dp[idx + 1 & 1];
            dp[idx + 1 & 1] = tmp;
            
            if (dp[idx & 1] > n && !moreFound) {
                more = dp[idx & 1];
                moreFound = true;
            }
            if (dp[idx + 1 & 1] < n) {
                less = dp[idx +1& 1];
            }
            
            idx++;
        }
        
        if (less < n) {
            return new int[]{less, more};
        } else {
            return new int[]{more};
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getNumbers(1)));
        System.out.println(Arrays.toString(new Solution().getNumbers(2)));
        System.out.println(Arrays.toString(new Solution().getNumbers(3)));
        System.out.println(Arrays.toString(new Solution().getNumbers(4)));
        System.out.println(Arrays.toString(new Solution().getNumbers(5)));
    }
}
