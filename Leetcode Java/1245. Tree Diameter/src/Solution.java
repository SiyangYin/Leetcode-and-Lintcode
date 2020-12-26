import java.util.*;

public class Solution {
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[edges.length + 1];
        int[] dis = {0, 0};
        dfs(0, 0, dis, graph, visited);
        
        Arrays.fill(visited, false);
        dfs(dis[0], 0, dis, graph, visited);
        return dis[1];
    }
    
    private void dfs(int cur, int curDis, int[] dis, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[cur] = true;
        if (curDis > dis[1]) {
            dis[0] = cur;
            dis[1] = curDis;
        }
        
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, curDis + 1, dis, graph, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] ed = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        System.out.println(new Solution().treeDiameter(ed));
    }
}
