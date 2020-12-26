import java.util.*;

public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
    
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[numCourses];
        Arrays.fill(visited, -1);
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == -1) {
                if (dfs(i, graph, visited, stack)) {
                    return new int[0];
                }
            }
        }
        
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        
        return res;
    }
    
    private boolean dfs(int cur, Map<Integer, List<Integer>> graph, int[] visited, Deque<Integer> stack) {
        visited[cur] = 0;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    return true;
                } else if (visited[next] == -1) {
                    if (dfs(next, graph, visited, stack)) {
                        return true;
                    }
                }
            }
        }
        
        stack.push(cur);
        visited[cur] = 1;
        return false;
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
        // int n = 4;
        // int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int n = 2;
        int[][] pre = {{1, 0}};
        System.out.println(Arrays.toString(new Solution2().findOrder(n, pre)));
    }
}
