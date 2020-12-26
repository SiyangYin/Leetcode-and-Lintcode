import java.util.*;

public class Solution2 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) {
            return -1;
        }
        
        if (S == T) {
            return 0;
        }
        
        Map<Integer, List<Integer>> mapToRouteIdx = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                mapToRouteIdx.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        Set<Integer> visited = new HashSet<>();
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int nextRouteIdx : mapToRouteIdx.get(cur)) {
                    if (visited.contains(nextRouteIdx)) {
                        continue;
                    }
                    
                    for (int nextStop : routes[nextRouteIdx]) {
                        if (nextStop == T) {
                            return res;
                        }
                        
                        queue.offer(nextStop);
                        visited.add(nextRouteIdx);
                    }
                }
                
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // int[][] route = {{2}, {2, 8}};
        int[][] route = {{1, 2, 7}, {3, 6, 7}};
        // System.out.println(new Solution().numBusesToDestination(route, 8, 2));
        System.out.println(new Solution2().numBusesToDestination(route, 1, 6));
    }
}
