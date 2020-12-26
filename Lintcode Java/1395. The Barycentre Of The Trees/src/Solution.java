import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    
    private int minCount, res;
    
    /**
     * @param x: The vertexes of the edges
     * @param y: The vertexes of the edges
     * @return: Return the index of barycentre
     */
    public int getBarycentre(int[] x, int[] y) {
        // Write your code here
        int n = x.length;
        Set<Integer> visited = new HashSet<>();
        minCount = n;
        Map<Integer, Set<Integer>> graph = buildGraph(x, y);
        res = x[0];
        dfs(x[0], graph, visited, n);
        return res;
    }
    
    private int dfs(int root, Map<Integer, Set<Integer>> graph, Set<Integer> visited, int n) {
        visited.add(root);
        int count = 1, curRes = 0;
        for (int next : graph.get(root)) {
            if (!visited.contains(next)) {
                int sons = dfs(next, graph, visited, n);
                curRes = Math.max(curRes, sons);
                count += sons;
            }
        }
        
        curRes = Math.max(curRes, n - count);
        
        if (curRes < minCount) {
            minCount = curRes;
            res = root;
        } else if (curRes == minCount) {
            res = Math.min(res, root);
        }
        
        return count;
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[] x, int[] y) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            int s = x[i], t = y[i];
            graph.putIfAbsent(s, new HashSet<>());
            graph.get(s).add(t);
            graph.putIfAbsent(t, new HashSet<>());
            graph.get(t).add(s);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[] x = {1, 2, 2}, y = {2, 3, 4};
        System.out.println(new Solution().getBarycentre(x, y));
    }
}
