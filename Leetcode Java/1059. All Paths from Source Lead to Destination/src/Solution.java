import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        
        return dfs(source, destination, graph, new boolean[n]);
    }
    
    private boolean dfs(int v, int dest, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (!graph.containsKey(v)) {
            if (v != dest) {
                return false;
            }
        }
        
        visited[v] = true;
        if (graph.containsKey(v)) {
            for (int next : graph.get(v)) {
                if (visited[next]) {
                    return false;
                }
                
                if (!visited[next] && !dfs(next, dest, graph, visited)) {
                    return false;
                }
            }
        }
        
        visited[v] = false;
        return true;
    }
    
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 1}};
        System.out.println(new Solution().leadsToDestination(4, edges, 0, 3));
    }
}
