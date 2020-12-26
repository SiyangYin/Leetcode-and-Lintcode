import java.util.*;

public class Solution2 {
    /**
     * @param times: a 2D array
     * @param N:     an integer
     * @param K:     an integer
     * @return: how long will it take for all nodes to receive the signal
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        // Write your code here
        int[] dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K - 1] = 0;
        
        Map<Integer, List<int[]>> graph = buildGraph(times);
        boolean[] visited = new boolean[N];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
        minHeap.offer(new int[]{K - 1, 0});
        
        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] curV = minHeap.poll();
            int v = curV[0];
            
            if (visited[v]) {
                continue;
            }
            
            visited[v] = true;
            res = curV[1];
            N--;
            
            if (graph.containsKey(v)) {
                for (int[] next : graph.get(v)) {
                    int nextv = next[0], disFromV = next[1];
                    if (!visited[nextv] && dis[v] + disFromV < dis[nextv]) {
                        dis[nextv] = dis[v] + disFromV;
                        minHeap.offer(new int[]{nextv, dis[nextv]});
                    }
                }
            }
        }
        
        return N == 0 ? res : -1;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int s = time[0] - 1, t = time[1] - 1, dis = time[2];
            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(new int[]{t, dis});
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4, K = 2;
        System.out.println(new Solution2().networkDelayTime(times, N, K));
    }
}
