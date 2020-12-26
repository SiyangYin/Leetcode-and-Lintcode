import java.util.*;

public class Mcoloring {
    static boolean graphColoring(int[][] graph, int m) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(graph, map);
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!dfs(i, map, color, m)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static boolean dfs(int cur, Map<Integer, List<Integer>> map, int[] color, int m) {
        Set<Integer> used = new HashSet<>();
        for (int i : map.get(cur)) {
            if (color[i] != -1) {
                used.add(color[i]);
            }
        }
        
        if (used.size() == m) {
            return false;
        }
        
        for (int i = 0; i < m; i++) {
            if (!used.contains(i)) {
                color[cur] = i;
                for (int next : map.get(cur)) {
                    if (color[next] == -1 && !dfs(next, map, color, m)) {
                        return false;
                    }
                }
                color[cur] = -1;
            }
        }
        
        return true;
    }
    
    static void buildGraph(int[][] graph, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    map.get(i).add(j);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] graph = {{0, 1}, {1, 0}};
        System.out.println(graphColoring(graph, 1));
    }
}
