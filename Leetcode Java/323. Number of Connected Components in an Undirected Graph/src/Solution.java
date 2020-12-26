import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                res++;
            }
        }
        
        return res;
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, int cur, boolean[] visited) {
        visited[cur] = true;
        for (int i : graph.get(cur)) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] edges = new int[3][];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{1, 2};
        edges[2] = new int[]{3, 4};
    
        System.out.println(new Solution().countComponents(5, edges));
    }
}
