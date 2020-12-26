import java.util.*;

public class Solution2 {
    /**
     * @param n:       a integer
     * @param flights: a 2D array
     * @param src:     a integer
     * @param dst:     a integer
     * @param K:       a integer
     * @return: return a integer
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // write your code here
        if (flights == null || flights.length == 0 || flights[0].length == 0) {
            return 0;
        }
        
        Map<Integer, List<int[]>> graph = buildGraph(flights);
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        int[] count = new int[n];
        
        boolean[] state = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            state[cur] = false;
            
            if (graph.containsKey(cur)) {
                for (int[] next : graph.get(cur)) {
                    int nextPoint = next[0], disFromCur = next[1];
                    
                    if (dis[nextPoint] > dis[cur] + disFromCur) {
                        dis[nextPoint] = dis[cur] + disFromCur;
                        count[nextPoint] = count[cur] + 1;
                        if (!state[nextPoint] && count[nextPoint] <= K) {
                            queue.offer(nextPoint);
                            state[nextPoint] = true;
                        }
                    }
                }
            }
        }
        
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] g) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] tuple : g) {
            graph.putIfAbsent(tuple[0], new ArrayList<>());
            graph.get(tuple[0]).add(new int[]{tuple[1], tuple[2]});
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int n = 3, src = 0, dst = 2, K = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(new Solution2().findCheapestPrice(n, flights, src, dst, K));
    }
}
