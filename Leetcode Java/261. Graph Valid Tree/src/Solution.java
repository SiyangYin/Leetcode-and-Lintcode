import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
    
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(graph, visited, i, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    // 有没有环
    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int s, int parent) {
        visited[s] = true;
        for (int neighbor : graph.get(s)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor, s);
            } else if (neighbor != parent) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[5][];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{1, 2};
        edges[2] = new int[]{2, 3};
        edges[3] = new int[]{1, 3};
        edges[4] = new int[]{1, 4};
    
        System.out.println(new Solution().validTree(n, edges));
    }
}
