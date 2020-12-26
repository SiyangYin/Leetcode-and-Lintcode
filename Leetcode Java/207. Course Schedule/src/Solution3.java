import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    // 这个答案是错误的
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (graph.containsKey(i) && !visited[i]) {
                if (dfs(i, graph, visited)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int cur, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[cur] = true;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (visited[next]) {
                    return true;
                } else {
                    if (dfs(next, graph, visited)) {
                        return true;
                    }
                }
            }
        }
        
        
        return false;
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new HashSet<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        return map;
    }
    
    public static void main(String[] args) {
        int num = 3;
        // int[][] prerequisites = {{1, 0}, {2, 1}};
        int[][] prerequisites = {{2, 0}, {2, 1}};
        // int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(new Solution3().canFinish(num, prerequisites));
    }
}
