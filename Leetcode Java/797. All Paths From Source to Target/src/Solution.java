import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        
        dfs(0, graph.length - 1, graph, new ArrayList<>(), res, visited);
        return res;
    }
    
    private void dfs(int cur, int dest, int[][] graph, List<Integer> path, List<List<Integer>> res, boolean[] visited) {
        visited[cur] = true;
        path.add(cur);
        if (cur == dest) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            visited[cur] = false;
            return;
        }
    
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next, dest, graph, path, res, visited);
            }
        }
        
        path.remove(path.size() - 1);
        visited[cur] = false;
    }
}
