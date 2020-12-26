import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] colors = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && !bfs(graph, i, 0, visited, colors)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean bfs(int[][] graph, int v, int color, boolean[] visited, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                colors[cur] = color;
                for (int neighbor : graph[cur]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        colors[neighbor] = color ^ 1;
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == colors[cur]) {
                        return false;
                    }
                }
            }
            color ^= 1;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[][] graph = {{1, 4}, {0, 2}, {1}, {4}, {0, 3}};
        System.out.println(new Solution2().isBipartite(graph));
    }
}
