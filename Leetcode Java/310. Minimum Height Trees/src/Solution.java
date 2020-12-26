import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int[] degrees = getDegrees(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            res.clear();
            res.addAll(queue);
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                visited[cur] = true;
                
                for (int next : graph.get(cur)) {
                    if (visited[next]) {
                        continue;
                    }
                    
                    degrees[next]--;
                    if (degrees[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        return res;
    }
    
    private int[] getDegrees(int n, int[][] edges) {
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            degrees[x]++;
            degrees[y]++;
        }
        
        return degrees;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        // System.out.println(new Solution().findMinHeightTrees(6, edges));
        
        // int[][] edges = {{0, 1}};
        // int[][] edges = {};
        // System.out.println(new Solution().findMinHeightTrees(1, edges));
        
        
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println(new Solution().findMinHeightTrees(7, edges));
    }
}
