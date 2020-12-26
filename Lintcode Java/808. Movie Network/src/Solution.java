import java.util.*;

public class Solution {
    /**
     * @param rating: the rating of the movies
     * @param G:      the realtionship of movies
     * @param S:      the begin movie
     * @param K:      top K rating
     * @return: the top k largest rating moive which contact with S
     */
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
        Map<Integer, List<Integer>> graph = buildGraph(G);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> Integer.compare(rating[i1], rating[i2]));
        
        boolean[] visited = new boolean[rating.length];
        visited[S] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                
                visited[next] = true;
                if (minHeap.size() < K) {
                    minHeap.add(next);
                } else if (rating[next] > rating[minHeap.peek()]) {
                    minHeap.poll();
                    minHeap.offer(next);
                }
                
                queue.offer(next);
            }
        }
        
        int[] res = new int[minHeap.size()];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            res[idx++] = minHeap.poll();
        }
        
        return res;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] G) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            graph.put(i, new ArrayList<>());
            List<Integer> nexts = graph.get(i);
            for (int next : G[i]) {
                nexts.add(next);
            }
        }
        
        return graph;
    }
}
