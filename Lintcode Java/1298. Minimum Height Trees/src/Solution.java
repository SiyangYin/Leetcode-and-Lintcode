import java.util.*;

public class Solution {
    /**
     * @param n:     n nodes labeled from 0 to n - 1
     * @param edges: a undirected graph
     * @return: a list of all the MHTs root labels
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Wirte your code here
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        Map<Integer, Set<Integer>> graph = buildGraph(edges);
        int[] degrees = getDegrees(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
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
                    if (!visited[next]) {
                        
                        degrees[next]--;
                        if (degrees[next] == 1) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    private int[] getDegrees(int n, int[][] edges) {
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        
        return degrees;
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(new Solution().findMinHeightTrees(n, edges));
    }
}

