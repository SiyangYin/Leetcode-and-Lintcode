import java.util.Arrays;

public class Solution3 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
        
        int[][] graph = buildGraph(flights, n);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        int[] backup = null;
        
        for (int pass = 1; pass <= K + 1; pass++) {
            backup = Arrays.copyOf(dist, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    if (backup[i] != Integer.MAX_VALUE) {
                        dist[j] = Math.min(dist[j], backup[i] + graph[i][j]);
                    }
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    
    private int[][] buildGraph(int[][] flights, int n) {
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[][] ed = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int n = 4, src = 0, dst = 3, k = 1;
        System.out.println(new Solution3().findCheapestPrice(n, ed, src, dst, k));
    }
}
