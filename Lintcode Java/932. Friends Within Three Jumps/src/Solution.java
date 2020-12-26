import java.util.*;

public class Solution {
    /**
     * @param a: The a tuple
     * @param b: The b tuple
     * @param c: the c tuple
     * @param d: the d tuple
     * @return: The answer
     */
    public int[] withinThreeJumps(int[] a, int[] b, int[] c, int[] d) {
        // Write your code here
        int n = c.length;
        int[] res = new int[n];
        
        Map<Integer, List<Integer>> graph = buildGraph(a, b);
    
        for (int i = 0; i < n; i++) {
            int maxDepth = 1;
            while (!dfs(c[i], d[i], graph, 0, maxDepth) && maxDepth < 4) {
                maxDepth++;
            }
            
            res[i] = maxDepth < 4 ? 1 : 0;
        }
        
        return res;
    }
    
    private boolean dfs(int cur, int dest, Map<Integer, List<Integer>> graph, int depth, int maxDepth) {
        if (depth > maxDepth) {
            return false;
        }
        
        if (cur == dest) {
            return true;
        }
        
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (dfs(next, dest, graph, depth + 1, maxDepth)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[] a, int[] b) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            graph.putIfAbsent(a[i], new ArrayList<>());
            graph.get(a[i]).add(b[i]);
            graph.putIfAbsent(b[i], new ArrayList<>());
            graph.get(b[i]).add(a[i]);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3, 4, 5};
        int[] c = {1, 1};
        int[] d = {4, 5};
        System.out.println(Arrays.toString(new Solution().withinThreeJumps(a, b, c, d)));
    }
}
