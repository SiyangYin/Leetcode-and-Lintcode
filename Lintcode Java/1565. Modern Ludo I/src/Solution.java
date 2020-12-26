import java.util.*;

public class Solution {
    /**
     * @param length:      the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        if (length <= 7) {
            return 1;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] connection : connections) {
            map.putIfAbsent(connection[0], new HashSet<>());
            map.get(connection[0]).add(connection[1]);
        }
        
        int[] dp = new int[length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 2; i <= 7; i++) {
            dp[i] = 1;
        }
        
        for (int i = 2; i <= length; i++) {
            if (map.containsKey(i)) {
                for (int target : map.get(i)) {
                    dp[target] = Math.min(dp[target], dp[i]);
                }
            }
            for (int j = 1; j <= 6; j++) {
                if (i + j <= length) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        
        return dp[length];
    }
    
    public static void main(String[] args) {
        int[][] connections = {
                {36, 77},
                {5, 54},
                {5, 42},
                {31, 37},
                {10, 36}, {15, 66}, {58, 68}};
        System.out.println(new Solution().modernLudo(86, connections));
    }
}
