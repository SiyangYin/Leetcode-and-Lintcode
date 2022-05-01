import java.util.Arrays;

public class Solution {
    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n = fees.length;
        int[][] f = new int[maxTime + 1][n];
        for (int[] row : f) {
            Arrays.fill(row, Integer.MAX_VALUE >> 1);
        }
        
        for (int i = 0; i <= maxTime; i++) {
            f[i][0] = fees[0];
        }
        
        for (int t = 1; t <= maxTime; t++) {
            for (int[] edge : edges) {
                if (edge[2] > t) {
                    continue;
                }
                int c1 = edge[0], c2 = edge[1], time = edge[2];
                f[t][c1] = Math.min(f[t][c1], f[t - time][c2] + fees[c1]);
                f[t][c2] = Math.min(f[t][c2], f[t - time][c1] + fees[c2]);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= maxTime; i++) {
            res = Math.min(res, f[i][n - 1]);
        }
        return res == Integer.MAX_VALUE >> 1 ? -1 : res;
    }
    
    public static void main(String[] args) {
        int max = 30;
        int[][] e = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] fees = {5, 1, 2, 20, 20, 3};
        System.out.println(new Solution().minCost(max, e, fees));
    }
}
