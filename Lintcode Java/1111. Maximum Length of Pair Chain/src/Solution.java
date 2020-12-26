import java.util.Arrays;

public class Solution {
    /**
     * @param pairs: pairs of numbers
     * @return: the length longest chain which can be formed
     */
    public int findLongestChain(int[][] pairs) {
        // Write your code here
        Arrays.sort(pairs, (p1, p2) -> p1[1] != p2[1] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));
        int[] dp = new int[pairs.length];
        
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    break;
                }
            }
            
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] pairs = {{2, 3}, {3, 4},{1,2}};
        System.out.println(new Solution().findLongestChain(pairs));
    }
}
