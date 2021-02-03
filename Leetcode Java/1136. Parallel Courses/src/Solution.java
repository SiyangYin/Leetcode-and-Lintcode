import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        int[] indegrees = new int[N];
        List<Integer>[] graph = buildGraph(relations, N, indegrees);
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                N--;
                if (graph[cur] != null) {
                    for (int next : graph[cur]) {
                        indegrees[next]--;
                        if (indegrees[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
                
                graph[cur] = null;
            }
        }
        
        return N == 0 ? res : -1;
    }
    
    private List<Integer>[] buildGraph(int[][] relations, int N, int[] indegrees) {
        List<Integer>[] graph = (List<Integer>[]) new ArrayList[N];
        for (int[] relation : relations) {
            int from = relation[0] - 1, to = relation[1] - 1;
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(to);
            indegrees[to]++;
        }
        
        return graph;
    }
}
