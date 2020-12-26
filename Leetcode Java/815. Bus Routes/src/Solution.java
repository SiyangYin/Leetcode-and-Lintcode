import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(routes, map);
        Queue<Integer> queue= new ArrayDeque<>();
        queue.offer(S);
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (Integer r : map.getOrDefault(cur, new ArrayList<>())) {
                    if (visited.contains(r)) {
                        continue;
                    }
                    for (int j = 0; j < routes[r].length; j++) {
                        if (routes[r][j] == T) {
                            return level + 1;
                        }
                        visited.add(r);
                        queue.offer(routes[r][j]);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private void buildGraph(int[][] routes, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }
    }
    
    public static void main(String[] args) {
        // int[][] route = {{2}, {2, 8}};
        int[][] route = {{1, 2, 7}, {3, 6, 7}};
        // System.out.println(new Solution().numBusesToDestination(route, 8, 2));
        System.out.println(new Solution().numBusesToDestination(route, 1, 6));
    }
}
