import java.util.*;

public class Solution {
    /**
     * @param n:      The number of nodes
     * @param starts: One point of the edge
     * @param ends:   Another point of the edge
     * @param lens:   The length of the edge
     * @return: Return the length of longest path on the tree.
     */
    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        // Write your code here
        Map<Integer, List<int[]>> graph = buildGraph(starts, ends, lens);
        int[] ret = bfs(0, graph, n);
        
        return bfs(ret[0], graph, n)[1];
    }
    
    private int[] bfs(int start, Map<Integer, List<int[]>> graph, int n) {
        int[] res = {0, 0};
        
        boolean[] visited = new boolean[n];
        visited[start] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] next : graph.get(cur[0])) {
                if (visited[next[0]]) {
                    continue;
                }
                
                visited[next[0]] = true;
                
                if (cur[1] + next[1] > res[1]) {
                    res[0] = next[0];
                    res[1] = cur[1] + next[1];
                }
                
                queue.offer(new int[]{next[0], cur[1] + next[1]});
            }
        }
        
        return res;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[] starts, int[] ends, int[] lens) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < starts.length; i++) {
            graph.computeIfAbsent(starts[i], k -> new ArrayList<>()).add(new int[]{ends[i], lens[i]});
            graph.computeIfAbsent(ends[i], k -> new ArrayList<>()).add(new int[]{starts[i], lens[i]});
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[] starts = {0, 0, 2, 2}, ends = {1, 2, 3, 4}, lens = {1, 2, 5, 6};
        System.out.println(new Solution().longestPath(n, starts, ends, lens));
    }
}
