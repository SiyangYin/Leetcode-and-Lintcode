import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
    
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx++] = cur;
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        return idx != numCourses ? new int[0] : res;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        return map;
    }
}
