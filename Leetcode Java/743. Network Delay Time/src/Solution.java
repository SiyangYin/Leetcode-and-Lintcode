import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            // edge[0]代表某条边的起点，edge[1]代表这条边的终点，edge[2]代表这条边的长度
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        // pq里存储的是一个长度为2的数组，a[0]代表当前的node编号，a[1]代表离Node K的距离
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // visited[i]表示编号为i的node是否访问过
        boolean[] visited = new boolean[N + 1];
        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        pq.offer(new int[]{K, 0});
        int max = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            if (visited[curNode]) {
                continue;
            }
            
            visited[curNode] = true;
            int curDis = cur[1];
            max = curDis;
            N--;
            if (graph.containsKey(curNode)) {
                for (int[] next : graph.get(curNode)) {
                    if (!visited[next[0]] && curDis + next[1] < minDis[next[0]]) {
                        minDis[next[0]] = curDis + next[1];
                        pq.offer(new int[]{next[0], curDis + next[1]});
                    }
                }
            }
        }
        
        return N == 0 ? max : -1;
    }
    
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}};
        
        int N = 4, K = 2;
        System.out.println(new Solution().networkDelayTime(times, N, K));
    }
}
