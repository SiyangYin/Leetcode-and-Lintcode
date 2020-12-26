import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
        
        int[][] graph = buildGraph(flights, n);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, src, 0});
        
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int cost = cur[0], place = cur[1], pathLen = cur[2];
            if (place == dst) {
                return cost;
            }
            
            if (pathLen < K + 1) {
                for (int next = 0; next < n; next++) {
                    if (graph[place][next] != Integer.MAX_VALUE) {
                        minHeap.offer(new int[]{cost + graph[place][next], next, pathLen + 1});
                    }
                }
            }
        }
        
        return -1;
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
        System.out.println(new Solution().findCheapestPrice(n, ed, src, dst, k));
    }
}
