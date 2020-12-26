import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param graph: a 2D array
     * @return: all possible paths from node 0 to node N-1
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }
        boolean[] visited = new boolean[graph.length];
        dfs(0, graph.length - 1, new ArrayList<>(), map, visited, res);
        return res;
    }
    
    private void dfs(int s, int n, List<Integer> cur, Map<Integer, List<Integer>> map, boolean[] visited, List<List<Integer>> res) {
        visited[s] = true;
        cur.add(s);
        if (s == n) {
            res.add(new ArrayList<>(cur));
            visited[s] = false;
            cur.remove(cur.size() - 1);
            return;
        }
        
        for (int next : map.get(s)) {
            if (!visited[next]) {
                dfs(next, n, cur, map, visited, res);
            }
        }
        
        cur.remove(cur.size() - 1);
        visited[s] = false;
    }
    
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));
    }
}
