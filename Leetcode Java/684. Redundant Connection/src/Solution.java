import java.util.*;

public class Solution {
    
    class Edge {
        int from, to;
        Edge() {}
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    
        @Override
        public boolean equals(Object another) {
            Edge edge = (Edge) another;
            return from == edge.from && to == edge.to;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Edge, Integer> edgeIdx = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new HashSet<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.putIfAbsent(edges[i][1], new HashSet<>());
            graph.get(edges[i][1]).add(edges[i][0]);
            edgeIdx.put(new Edge(edges[i][0], edges[i][1]), i);
        }
        
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[edges.length + 1];
        
        dfs(1, 1, graph, visited, path);
        
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        for (int i = 0; i < path.size(); i++) {
            if (map.containsKey(path.get(i))) {
                start = map.get(path.get(i));
                end = i;
            }
            map.put(path.get(i), i);
        }
        
        int[] res = null;
        int idx = -1;
        for (int i = start; i < end; i++) {
            Edge edge = new Edge();
            edge.from = Math.min(path.get(i), path.get(i + 1));
            edge.to = Math.max(path.get(i), path.get(i + 1));
            
            if (idx < edgeIdx.get(edge)) {
                idx = edgeIdx.get(edge);
                res = edges[idx];
            }
        }
        
        return res;
    }
    
    private boolean dfs(int v, int w, Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> path) {
        path.add(v);
        visited[v] = true;
        if (graph.containsKey(v)) {
            for (int next : graph.get(v)) {
                if (next == w) {
                    continue;
                }
                if (visited[next]) {
                    path.add(next);
                    return true;
                }
                
                if (dfs(next, v, graph, visited, path)) {
                    return true;
                }
            }
        }
        
        path.remove(path.size() - 1);
        return false;
    }
    
    public static void main(String[] args) {
        // int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        // int[][] edges = {{1, 3}, {3, 4}, {1, 5}, {3, 5}, {2, 3}};
        int[][] edges = {{7,8},{2,6},{2,8},{1,4},{9,10},{1,7},{3,9},{6,9},{3,5},{3,10}};
        System.out.println(Arrays.toString(new Solution().findRedundantConnection(edges)));
    }
}
