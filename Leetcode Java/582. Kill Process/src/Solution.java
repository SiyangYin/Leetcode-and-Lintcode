import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            graph.putIfAbsent(ppid.get(i), new ArrayList<>());
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        
        dfs(kill, graph, res);
        return res;
    }
    
    private void dfs(int cur, Map<Integer, List<Integer>> graph, List<Integer> res) {
        res.add(cur);
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                dfs(next, graph, res);
            }
        }
    }
}
