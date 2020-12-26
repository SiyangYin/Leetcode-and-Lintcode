import java.util.Arrays;

public class Solution {
    /**
     * @param graph: the given undirected graph
     * @return:  return true if and only if it is bipartite
     */
    public boolean isBipartite(int[][] graph) {
        // Write your code here
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
    
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !dfs(i, graph, colors, 0)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int cur, int[][] graph, int[] colors, int color) {
        colors[cur] = color;
        for (int i = 0; i < graph[cur].length; i++) {
            int next = graph[cur][i];
            if (colors[next] == color) {
                return false;
            }
            
            if (colors[next] == -1 && !dfs(next, graph, colors, color ^ 1)) {
                return false;
            }
        }
        
        return true;
    }
}
