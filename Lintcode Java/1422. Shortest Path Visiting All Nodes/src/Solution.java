import java.util.*;

public class Solution {
    
    class Pair {
        int x, state;
        
        public Pair(int x, int state) {
            this.x = x;
            this.state = state;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && state == pair.state;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, state);
        }
    }
    
    /**
     * @param graph: the graph
     * @return: the shortest path for all nodes
     */
    public int shortestPathLength(int[][] graph) {
        // Write your code here.
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            Pair start = new Pair(i, 1 << i);
            queue.offer(start);
            visited.add(start);
        }
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (int next : graph[cur.x]) {
                    Pair pair = new Pair(next, cur.state | (1 << next));
                    if (pair.state == (1 << n) - 1) {
                        return res;
                    }
                    
                    if (visited.contains(pair)) {
                        continue;
                    }
                    
                    queue.offer(pair);
                    visited.add(pair);
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(new Solution().shortestPathLength(g));
    }
}
