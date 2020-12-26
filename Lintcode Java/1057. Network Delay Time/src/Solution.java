import java.util.*;

public class Solution {
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
        
        while (true) {
            int curdis = Integer.MAX_VALUE, cur = -1;
            for (int i = 0; i < N; i++) {
                if (!visited[i] && dis[i] < curdis) {
                    curdis = dis[i];
                    cur = i;
                }
            }
            
            if (cur == -1) {
                break;
            }
            
            visited[cur] = true;
            if (graph.containsKey(cur)) {
                for (int[] next : graph.get(cur)) {
                    int nextPoint = next[0], costFromCur = next[1];
                    if (!visited[nextPoint]) {
                        dis[nextPoint] = Math.min(dis[nextPoint], dis[cur] + costFromCur);
                    }
                }
            }
        }
    
        System.out.println(Arrays.toString(visited));
    
        int res = 0;
        for (int d : dis) {
            res = Math.max(res, d);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
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
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}, {5, 2, 1}};
        int N = 5, K = 2;
        System.out.println(new Solution().networkDelayTime(times, N, K));
    }
}
