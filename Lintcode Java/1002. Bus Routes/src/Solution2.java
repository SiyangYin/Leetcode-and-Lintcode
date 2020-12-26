import java.util.*;

public class Solution2 {
    /**
     * @param routes:  a list of bus routes
     * @param S: start
     * @param T: destination
     * @return: the least number of buses we must take to reach destination
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        // Write your code here
        if (S == T) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int r : routes[i]) {
                map.putIfAbsent(r, new HashSet<>());
                map.get(r).add(i);
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(S);
        Set<Integer> visitedRoute = new HashSet<>(), visitedStop = new HashSet<>();
        visitedStop.add(S);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
    
                for (int nextRoute : map.get(cur)) {
                    if (visitedRoute.add(nextRoute)) {
                        for (int stop : routes[nextRoute]) {
                            if (stop == T) {
                                return res;
                            }
                            if (visitedStop.add(stop)) {
                                queue.offer(stop);
                            }
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(new Solution2().numBusesToDestination(routes, 1, 6));
    }
}
