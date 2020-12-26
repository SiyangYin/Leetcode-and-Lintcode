import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<List<Integer>> graph = buildGraph(connections, n);
        int[] ord = new int[n], low = new int[n];
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, i, 0, ord, low, graph, visited, res);
            }
        }
    
        // System.out.println(Arrays.toString(ord));
        // System.out.println(Arrays.toString(low));
        return res;
    }
    
    private void dfs(int cur, int parent, int cnt, int[] ord, int[] low, List<List<Integer>> graph, boolean[] visited, List<List<Integer>> res) {
        visited[cur] = true;
        ord[cur] = cnt;
        low[cur] = cnt;
        
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, cur, cnt + 1, ord, low, graph, visited, res);
                low[cur] = Math.min(low[cur], low[next]);
                if (ord[cur] < low[next]) {
                    res.add(Arrays.asList(cur, next));
                }
            } else if (next != parent) {
                low[cur] = Math.min(low[cur], low[next]);
            }
        }
    }
    
    private List<List<Integer>> buildGraph(List<List<Integer>> connections, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (List<Integer> connection : connections) {
            int u = connection.get(0), v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // int n = 4;
        // List<List<Integer>> cons = new ArrayList<>();
        // cons.add(Arrays.asList(0, 1));
        // cons.add(Arrays.asList(1, 2));
        // cons.add(Arrays.asList(2, 0));
        // cons.add(Arrays.asList(1, 3));
    
        int n = 5;
        List<List<Integer>> cons = new ArrayList<>();
        cons.add(Arrays.asList(0, 1));
        cons.add(Arrays.asList(1, 2));
        cons.add(Arrays.asList(2, 3));
        cons.add(Arrays.asList(3, 4));
        cons.add(Arrays.asList(4, 2));
        
        System.out.println(new Solution().criticalConnections(n, cons));
    }
}

