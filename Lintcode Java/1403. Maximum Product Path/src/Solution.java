import javax.swing.table.TableRowSorter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    
    private int res;
    private int MOD = (int) (1e9 + 7);
    
    /**
     * @param x: The end points of edges set
     * @param y: The end points of edges set
     * @param d: The weight of points set
     * @return: Return the maximum product
     */
    public int getProduct(int[] x, int[] y, int[] d) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(x, y);
        
        res = Integer.MIN_VALUE;
        dfs(0, 1, graph, d, new boolean[graph.size()]);
        
        return res;
    }
    
    private void dfs(int cur, long prod, Map<Integer, Set<Integer>> graph, int[] d, boolean[] visited) {
        prod *= d[cur];
        prod %= MOD;
        if (prod < 0) {
            prod += MOD;
        }
        
        visited[cur] = true;
        
        boolean isLeaf = true;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                isLeaf = false;
                dfs(next, prod, graph, d, visited);
            }
        }
        
        if (isLeaf) {
            res = (int) Math.max(res, prod);
        }
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[] x, int[] y) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            graph.putIfAbsent(x[i] - 1, new HashSet<>());
            graph.putIfAbsent(y[i] - 1, new HashSet<>());
            graph.get(x[i] - 1).add(y[i] - 1);
            graph.get(y[i] - 1).add(x[i] - 1);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[] x = {1, 2, 2}, y = {2, 3, 4}, d = {1, 1, -1, 2};
        System.out.println(new Solution().getProduct(x, y, d));
    }
}
