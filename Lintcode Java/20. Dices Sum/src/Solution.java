import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> res = new ArrayList<>();
    
        double[][] dp = new double[n][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[0][i] = 1.0 / 6;
        }
    
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= 6 * (i + 1); j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            
                dp[i][j] /= 6.0;
            }
        }
    
        for (int i = n; i <= 6 * n; i++) {
            res.add(new AbstractMap.SimpleEntry<>(i, dp[n - 1][i]));
        }
        
        return res;
    }
}
