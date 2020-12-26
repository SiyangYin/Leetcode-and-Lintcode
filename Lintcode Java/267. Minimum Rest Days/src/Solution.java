import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param company: Company business
     * @param gym:     Gym business
     * @return: Find the shortest rest day
     */
    public int minimumRestDays(List<Integer> company, List<Integer> gym) {
        // write your code here
        int n = company.size();
        int[][] dp = new int[3][2];
        for (int[] row : dp) {
            Arrays.fill(row, n);
        }
        
        dp[0][0] = company.get(0) == 1 ? 0 : 1;
        dp[1][0] = gym.get(0) == 1 ? 0 : 1;
        dp[2][0] = 1;
        
        // 0工作，1健身，2休息
        for (int i = 1; i < n; i++) {
            dp[0][i & 1] = dp[1][i & 1] = dp[2][i & 1] = n;
            if (company.get(i) == 1) {
                dp[0][i & 1] = dp[2][i - 1 & 1];
                if (gym.get(i - 1) == 1) {
                    dp[0][i & 1] = Math.min(dp[0][i & 1], dp[1][i - 1 & 1]);
                }
            }
            if (gym.get(i) == 1) {
                dp[1][i & 1] = dp[2][i - 1 & 1];
                if (company.get(i - 1) == 1) {
                    dp[1][i & 1] = Math.min(dp[1][i & 1], dp[0][i - 1 & 1]);
                }
            }
            
            for (int j = 0; j < 3; j++) {
                dp[2][i & 1] = Math.min(dp[2][i & 1], 1 + dp[j][i - 1 & 1]);
            }
        }
        
        int res = n;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[i][n - 1 & 1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumRestDays(Arrays.asList(1, 1, 0, 0), Arrays.asList(0, 1, 1, 0)));
    }
}
