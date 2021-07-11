import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int x;
        double prob;
        
        public Pair(int x, double prob) {
            this.x = x;
            this.prob = prob;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1];
            if (graph[x] == null) {
                graph[x] = new ArrayList<>();
            }
            graph[x].add(new Pair(y, succProb[i]));
            if (graph[y] == null) {
                graph[y] = new ArrayList<>();
            }
            graph[y].add(new Pair(x, succProb[i]));
        }
        
        double[] dist = new double[n];
        dist[start] = 1.0;
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> -Double.compare(p1.prob, p2.prob));
        maxHeap.offer(new Pair(start, 1.0));
        while (!maxHeap.isEmpty()) {
            Pair cur = maxHeap.poll();
            int x = cur.x;
            if (x == end) {
                return dist[end];
            }
            
            vis[x] = true;
            if (graph[x] != null) {
                for (Pair next : graph[x]) {
                    if (!vis[next.x] && dist[x] * next.prob > dist[next.x]) {
                        dist[next.x] = dist[x] * next.prob;
                        maxHeap.offer(new Pair(next.x, dist[next.x]));
                    }
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] suc = {0.5, 0.5, 0.2};
        int st = 0, ed = 2;
        System.out.println(new Solution().maxProbability(n, edges, suc, st, ed));
    }
}
