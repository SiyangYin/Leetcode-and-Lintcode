public class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] colors = new int[graph.length];
    
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && !dfs(graph, i, 0, visited, colors)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int v, int color, boolean[] visited, int[] colors) {
        visited[v] = true;
        colors[v] = color;
    
        for (int i : graph[v]) {
            if (!visited[i]) {
                if (!dfs(graph, i, color ^ 1, visited, colors)) {
                    return false;
                }
            } else if (color == colors[i]) {
                return false;
            }
        }
        
        return true;
    }
}
