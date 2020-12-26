import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0) {
            return true;
        }
        
        List<List<Integer>> graph = buildGraph(N, dislikes);
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < N; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, graph, colors, 0)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int cur, List<List<Integer>> graph, int[] colors, int color) {
        colors[cur] = color;
        for (int next : graph.get(cur)) {
            if (colors[next] == color) {
                return false;
            }
            
            if (colors[next] == -1 && !dfs(next, graph, colors, color ^ 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<List<Integer>> buildGraph(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] dislike : dislikes) {
            graph.get(dislike[0] - 1).add(dislike[1] - 1);
            graph.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        
        return graph;
    }
}
