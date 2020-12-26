import java.util.*;

public class Solution {
    /**
     * @param start: The start points set
     * @param end:   The end points set
     * @return: Return if the graph is cyclic
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        // Write your code here
        if (start == null || start.length == 0) {
            return false;
        }
        
        int n = 0;
        for (int i = 0; i < start.length; i++) {
            n = Math.max(n, start[i]);
            n = Math.max(n, end[i]);
        }
        
        Map<Integer, List<Integer>> graph = buildGraph(start, end);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1 && dfs(graph, i, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int cur, int[] visited) {
        visited[cur] = 0;
        List<Integer> nexts = graph.get(cur);
        if (nexts != null) {
            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    return true;
                }
                if (visited[next] == -1 && dfs(graph, next, visited)) {
                    return true;
                }
            }
        }
        
        visited[cur] = 1;
        return false;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[] start, int[] end) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < start.length; i++) {
            graph.putIfAbsent(start[i], new ArrayList<>());
            graph.get(start[i]).add(end[i]);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // int[] start = {1}, end = {2};
        int[] start = {1, 2, 3}, end = {2, 3, 1};
        System.out.println(new Solution().isCyclicGraph(start, end));
    }
}
