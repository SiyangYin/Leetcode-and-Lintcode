import java.util.*;

public class Solution {
    /**
     * @param N:  sum of the set
     * @param dislikes: dislikes peoples
     * @return:  if it is possible to split everyone into two groups in this way
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // Write your code here.
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] dislike : dislikes) {
            graph.putIfAbsent(dislike[0] - 1, new ArrayList<>());
            graph.get(dislike[0] - 1).add(dislike[1] - 1);
            graph.putIfAbsent(dislike[1] - 1, new ArrayList<>());
            graph.get(dislike[1] - 1).add(dislike[0] - 1);
        }
    
        for (int i = 0; i < N; i++) {
            if (colors[i] == -1 && !dfs(i, graph, colors, 0)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int cur, Map<Integer, List<Integer>> graph, int[] colors, int color) {
        colors[cur] = color;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (colors[next] == color) {
                    return false;
                }
                if (colors[next] == -1 && !dfs(next, graph, colors, color ^ 1)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
