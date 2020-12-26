import java.util.*;

public class Solution {
    /**
     * @param routes: a list of bus routes
     * @param S:      start
     * @param T:      destination
     * @return: the least number of buses we must take to reach destination
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        // Write your code here
        if (S == T) {
            return 0;
        }
        
        Map<Integer, Set<Set<Integer>>> map = new HashMap<>();
        Queue<Set<Integer>> queue = new LinkedList<>();
        Set<Set<Integer>> visited = new HashSet<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> route = new HashSet<>();
            for (int b : routes[i]) {
                route.add(b);
                map.putIfAbsent(b, new HashSet<>());
                map.get(b).add(route);
            }
            
            if (route.contains(S)) {
                if (route.contains(T)) {
                    return 1;
                }
                queue.offer(route);
                visited.add(route);
            }
        }
        
        int res = 1;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<Integer> cur = queue.poll();
                for (int bus : cur) {
                    for (Set<Integer> route : map.get(bus)) {
                        if (route.contains(T)) {
                            return res;
                        }
                        
                        if (visited.add(route)) {
                            queue.offer(route);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
