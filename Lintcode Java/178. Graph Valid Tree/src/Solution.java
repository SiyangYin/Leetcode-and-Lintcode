import java.util.*;

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return true;
        }
        
        if (n - 1 != edges.length) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
    
            for (int neighbor : graph.get(cur)) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return visited.size() == n;
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(new Solution().validTree(n, edges));
    }
}
