import java.util.*;

public class Solution {
    
    private long res;
    
    /**
     * @param edge: edge[i][0] [1] [2]  start point,end point,value
     * @return: return the second diameter length of the tree
     */
    public long getSecondDiameter(int[][] edge) {
        // write your code here
        int n = edge.length + 1;
        Map<Integer, List<int[]>> graph = buildGraph(edge);
        int far1 = bfs(0, graph, -1, new boolean[n]);
        int far2 = bfs(far1, graph, -1, new boolean[n]);
        
        bfs(far1, graph, far2, new boolean[n]);
        bfs(far2, graph, far1, new boolean[n]);
        
        return res;
    }
    
    private int bfs(int v, Map<Integer, List<int[]>> graph, int u, boolean[] visited) {
        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{v, 0});
        visited[v] = true;
        
        int farV = v;
        long farDis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long[] cur = queue.poll();
                int nextV = (int) cur[0];
                if (graph.containsKey(nextV)) {
                    for (int[] next : graph.get(nextV)) {
                        if (next[0] != u && !visited[next[0]]) {
                            if (next[1] + cur[1] >= farDis) {
                                farDis = next[1] + cur[1];
                                farV = next[0];
                            }
                            
                            visited[next[0]] = true;
                            queue.offer(new long[]{next[0], next[1] + cur[1]});
                        }
                    }
                }
            }
        }
        
        if (u != -1) {
            res = Math.max(res, farDis);
        }
        
        return farV;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[][] e = {{0, 1, 4}, {1, 2, 7}, {2, 3, 10}};
        System.out.println(new Solution().getSecondDiameter(e));
    }
}
