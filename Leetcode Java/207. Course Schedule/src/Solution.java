import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
    
        for (int indegree : indegrees) {
            if (indegree != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        return map;
    }
    
    public static void main(String[] args) {
        int num = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new Solution().canFinish(num, prerequisites));
    }
}
