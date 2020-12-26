import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> e1[1] != e2[1] ? Integer.compare(e1[1], e2[1]) : Integer.compare(e1[0], e2[0]));
        int[] dp = new int[envelopes.length];
        
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}
