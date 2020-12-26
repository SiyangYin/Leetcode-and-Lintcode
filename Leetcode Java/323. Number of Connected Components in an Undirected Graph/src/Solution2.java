import java.util.*;

public class Solution2 {
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
                bfs(graph, i, visited);
                res++;
            }
        }
    
        return res;
    }
    
    private void bfs(Map<Integer, Set<Integer>> graph, int cur, boolean[] visited) {
        visited[cur] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int next : graph.get(x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
