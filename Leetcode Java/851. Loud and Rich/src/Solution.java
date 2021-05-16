import java.util.*;

public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : richer) {
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] res = new int[quiet.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < quiet.length; i++) {
            dfs(i, res, graph, quiet);
        }
        
        return res;
    }
    
    private void dfs(int cur, int[] res, Map<Integer, List<Integer>> graph, int[] quiet) {
        if (res[cur] != -1) {
            return;
        }
        
        res[cur] = cur;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                dfs(next, res, graph, quiet);
                if (quiet[res[cur]] > quiet[res[next]]) {
                    res[cur] = res[next];
                }
            }
        }
    }
}
