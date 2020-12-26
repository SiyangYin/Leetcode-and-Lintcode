import java.util.Arrays;

public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length, k = costs[0].length;
    
        int[][] cost = new int[2][k];
        for (int i = 0; i < k; i++) {
            cost[0][i] = costs[0][i];
        }
        int ind = 0;
        int[] minCosts = new int[2];
        
        for (int i = 1; i < n; i++) {
            minCosts[0] = minCosts[1] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (cost[ind][j] < minCosts[0]) {
                    minCosts[1] = minCosts[0];
                    minCosts[0] = cost[ind][j];
                } else if (cost[ind][j] < minCosts[1]) {
                    minCosts[1] = cost[ind][j];
                }
            }
    
            for (int j = 0; j < k; j++) {
                if (cost[ind][j] > minCosts[0]) {
                    cost[ind ^ 1][j] = minCosts[0] + costs[i][j];
                } else {
                    cost[ind ^ 1][j] = minCosts[1] + costs[i][j];
                }
            }
            
            ind ^= 1;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, cost[ind][i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] costs = {{14, 2, 11},
                        {11, 14, 5},
                        {14, 3, 10}};
        costs = new int[][]{{1}};
        System.out.println(new Solution().minCostII(costs));
    
    }
}
