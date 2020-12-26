import java.util.*;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
    
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);
        int[] visited = new int[numCourses];
        Arrays.fill(visited, -1);
        for (int i = 0; i < numCourses; i++) {
            if (graph.containsKey(i) && visited[i] == -1) {
                if (dfs(i, graph, visited)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int cur, Map<Integer, Set<Integer>> graph, int[] visited) {
        visited[cur] = 0;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    return true;
                } else if (visited[next] == -1) {
                    if (dfs(next, graph, visited)) {
                        return true;
                    }
                }
            }
        }
        
        visited[cur] = 1;
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
        int num = 2;
        // int[][] prerequisites = {{1, 0}, {2, 1}};
        int[][] prerequisites = {{1, 0}, {0, 1}};
        // int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(new Solution2().canFinish(num, prerequisites));
    }
}
