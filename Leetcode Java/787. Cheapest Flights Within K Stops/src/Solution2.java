import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    
    private int res = Integer.MAX_VALUE;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
    
        Map<Integer, List<int[]>> graph = buildGraph(flights);
        boolean[] visited = new boolean[n];
        dfs(src, dst, 0, 0, K + 1, graph, visited);
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void dfs(int cur, int dst, int curCost, int pathLen, int maxLen, Map<Integer, List<int[]>> graph, boolean[] visited) {
        if (cur == dst) {
            res = Math.min(res, curCost);
            return;
        }
        
        if (pathLen == maxLen) {
            return;
        }
        
        visited[cur] = true;
        if (graph.containsKey(cur)) {
            for (int[] next : graph.get(cur)) {
                int nextPoint = next[0], costFromCur = next[1];
                if (curCost + costFromCur >= res) {
                    continue;
                }
                
                dfs(nextPoint, dst, curCost + costFromCur, pathLen + 1, maxLen, graph, visited);
            }
        }
        visited[cur] = false;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] flights) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        return graph;
    }
    
    
    public static void main(String[] args) {
        int[][] ed = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int n = 4, src = 0, dst = 3, k = 1;
        System.out.println(new Solution2().findCheapestPrice(n, ed, src, dst, k));
    }
}
