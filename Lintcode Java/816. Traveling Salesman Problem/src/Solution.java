import java.util.Arrays;

public class Solution {
    
    private int res = Integer.MAX_VALUE;
    
    /**
     * @param n:     an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public int minCost(int n, int[][] roads) {
        // Write your code here
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for (int[] road : roads) {
            int len = graph[road[0] - 1][road[1] - 1], minLen = Math.min(len, road[2]);
            graph[road[0] - 1][road[1] - 1] = graph[road[1] - 1][road[0] - 1] = minLen;
        }
        
        dfs(0, 0, 1, graph, new boolean[n]);
        return res;
    }
    
    private void dfs(int cur, int cost, int n, int[][] graph, boolean[] visited) {
        if (n == graph.length) {
            res = Math.min(res, cost);
            return;
        }
        
        if (cost >= res) {
            return;
        }
        
        visited[cur] = true;
        for (int i = 0; i < graph[cur].length; i++) {
            if (graph[cur][i] != Integer.MAX_VALUE && !visited[i]) {
                dfs(i, cost + graph[cur][i], n + 1, graph, visited);
            }
        }
        visited[cur] = false;
    }
    
    public static void main(String[] args) {
        // int n = 3;
        // int[][] ro= {{1,2,1},{2,3,2},{1,3,3}};
        int n = 5;
        int[][] ro= {{1,2,9},{2,3,1},{3,4,9},{4,5,4},{2,4,3},{1,3,2},{5,4,9}};
        System.out.println(new Solution().minCost(n, ro));
    }
}
