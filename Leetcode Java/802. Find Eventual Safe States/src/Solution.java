import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null) {
            return res;
        }
        
        int[] color = new int[graph.length];
        
        for (int i = 0; i < graph.length; ++i) {
            if (dfs(i, color, graph)) {
                res.add(i);
            }
        }
        return res;
    }
    
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0) {
            return color[node] == 2;
        }
        
        color[node] = 1;
        for (int next: graph[node]) {
            if (color[next] == 2) {
                continue;
            }
            if (color[next] == 1 || !dfs(next, color, graph)) {
                return false;
            }
        }
        
        color[node] = 2;
        return true;
    }
    
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(new Solution().eventualSafeNodes(graph));
    }
    
    private static boolean ch(int[] A) {
        A[0] = 11;
        return false;
    }
}
