import java.util.*;

public class Solution {
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
        
        for (int pass = 0; pass <= K; pass++) {
            int[] backup = Arrays.copyOf(dis, dis.length);
            for (int i = 0; i < n; i++) {
                if (graph.containsKey(i)) {
                    for (int[] next : graph.get(i)) {
                        int nextPoint = next[0], disFromI = next[1];
                        if (backup[i] != Integer.MAX_VALUE) {
                            dis[nextPoint] = Math.min(dis[nextPoint], backup[i] + disFromI);
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
        int n = 3, src = 0, dst = 2, K = 0;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(new Solution().findCheapestPrice(n, flights, src, dst, K));
    }
}
