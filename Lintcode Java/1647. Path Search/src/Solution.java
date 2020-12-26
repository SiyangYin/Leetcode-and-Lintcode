import java.util.*;

public class Solution {
    /**
     * @param n: The number of points
     * @param G: The description of graph
     * @param S: The point S
     * @param T: The point T
     * @return: output all the paths from S to T
     */
    public List<List<Integer>> getPath(int n, int[][] G, int S, int T) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(G);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(S);
        Set<Integer> visited = new HashSet<>();
        visited.add(S);
        
        dfs(S, T, cur, res, visited, graph);
        return res;
    }
    
    private void dfs(int S, int T, List<Integer> cur, List<List<Integer>> res, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
        if (S == T) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if (graph.containsKey(S)) {
            for (int neighbor : graph.get(S)) {
                if (!visited.contains(neighbor)) {
                    cur.add(neighbor);
                    visited.add(neighbor);
                    dfs(neighbor, T, cur, res, visited, graph);
                    visited.remove(neighbor);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[][] G) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : G) {
            graph.putIfAbsent(edge[0], new TreeSet<>());
            graph.putIfAbsent(edge[1], new TreeSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // int[][] G = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {3, 2}};
        
        int[][] G = {{2, 6}, {3, 6},
                {0, 3}, {2, 5}, {1, 6}, {3, 4},
                {1, 5}, {2, 3}, {0, 1}, {3, 5},
                {1, 2}, {0, 2}, {0, 6}, {1, 4}, {2, 4},
                {4, 5}, {0, 4}, {5, 6}, {1, 3}, {0, 5}};
        
        
        int S = 3, T = 2, n = 7;
        System.out.println(new Solution().getPath(n, G, S, T));
    }
}
