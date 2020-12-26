import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return: a list of PIDs of processes that will be killed in the end
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            graph.putIfAbsent(ppid.get(i), new ArrayList<>());
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        
        dfs(kill, graph, res);
        return res;
    }
    
    private void dfs(int id, Map<Integer, List<Integer>> graph, List<Integer> res) {
        res.add(id);
        if (graph.containsKey(id)) {
            for (int child : graph.get(id)) {
                dfs(child, graph, res);
            }
        }
    }
}
