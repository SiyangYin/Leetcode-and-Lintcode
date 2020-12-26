import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param graph: a 2D integers array
     * @return: return a list of integers
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, colors)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean dfs(int cur, int[][] graph, int[] colors) {
        if (colors[cur] != -1) {
            return colors[cur] == 1;
        }
        
        colors[cur] = 0;
        for (int next : graph[cur]) {
            if (colors[next] == 0) {
                return false;
            }
            if (colors[next] == -1 && !dfs(next, graph, colors)) {
                return false;
            }
        }
        
        colors[cur] = 1;
        return true;
    }
    
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(new Solution().eventualSafeNodes(graph));
    }
}
