import java.util.*;

public class Solution3 {
    
    /**
     * @param times: a 2D array
     * @param N: an integer
     * @param K: an integer
     * @return: how long will it take for all nodes to receive the signal
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        // Write your code here
        Map<Integer, List<int[]>> graph = buildGraph(times);
        int[] dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K - 1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(K - 1);
        boolean[] state = new boolean[N];
        state[K - 1] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            state[cur] = false;
            if (graph.containsKey(cur)) {
                for (int[] next : graph.get(cur)) {
                    int nextPoint = next[0], disFromCur = next[1];
                    if (dis[nextPoint] > dis[cur] + disFromCur) {
                        dis[nextPoint] = dis[cur] + disFromCur;
                        if (!state[nextPoint]) {
                            queue.offer(nextPoint);
                            state[nextPoint] = true;
                        }
                    }
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
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
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4, K = 2;
        System.out.println(new Solution3().networkDelayTime(times, N, K));
    }
}
