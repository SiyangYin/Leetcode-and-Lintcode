import java.util.*;

public class Solution2 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0) {
            return true;
        }
        
        List<List<Integer>> graph = buildGraph(N, dislikes);
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < N; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, graph, colors)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(int cur, List<List<Integer>> graph, int[] colors) {
        int color = 0;
        colors[cur] = color;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            color ^= 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                for (int next : graph.get(head)) {
                    if (colors[next] == (color ^ 1)) {
                        return false;
                    }
                    
                    if (colors[next] == -1) {
                        colors[next] = color;
                        queue.offer(next);
                    }
                }
            }
        }
        
        return true;
    }
    
    private List<List<Integer>> buildGraph(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] dislike : dislikes) {
            graph.get(dislike[0] - 1).add(dislike[1] - 1);
            graph.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        
        return graph;
    }
}
