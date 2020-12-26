import java.util.*;

public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        int[] time = new int[n];
        
        Map<Integer, List<Integer>> graph = buildGraph(manager);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(headID);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    time[next] = time[cur] + informTime[cur];
                    queue.offer(next);
                }
            }
        }
        
        for (int t : time) {
            res = Math.max(res, t);
        }
        
        return res;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[] manager) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            graph.putIfAbsent(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(i);
        }
        
        graph.remove(-1);
        return graph;
    }
    
    public static void main(String[] args) {
        int n = 7, headid = 6;
        int[] manager = {1, 2, 3, 4, 5, 6, -1}, infortime = {0, 6, 5, 4, 3, 2, 1};
        System.out.println(new Solution().numOfMinutes(n, headid, manager, infortime));
    }
}
