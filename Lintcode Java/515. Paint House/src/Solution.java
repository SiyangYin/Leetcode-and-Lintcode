import java.util.Arrays;

public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int[][] cost = new int[2][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            cost[index][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                cost[index ^ 1][j] = costs[i][j] +
                        Math.min(cost[index][(j + 1) % 3], cost[index][(j + 2) % 3]);
            }
            index ^= 1;
        }
        
        int res = Math.min(cost[index][0], cost[index][1]);
        res = Math.min(res, cost[index][2]);
        return res;
    }
    
    public static void main(String[] args) {
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        System.out.println(new Solution().minCost(costs));
        System.out.println(Arrays.deepToString(costs));
    }
}