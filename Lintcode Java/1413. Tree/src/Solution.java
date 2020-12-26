import java.util.*;

public class Solution {
    /**
     * @param x: The x
     * @param y: The y
     * @param a: The a
     * @param b: The b
     * @return: The Answer
     */
    public int[] tree(int[] x, int[] y, int[] a, int[] b) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(x, y);
        
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (visited.contains(next)) {
                    continue;
                }
                parent.put(next, cur);
                queue.offer(next);
                visited.add(next);
            }
            
        }
        
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int p1 = a[i], p2 = b[i];
            if (parent.getOrDefault(p1, -1).equals(parent.getOrDefault(p2, -1))) {
                res[i] = 1;
            } else if (parent.getOrDefault(p1, -1) == p2 || parent.getOrDefault(p2, -1) == p1) {
                res[i] = 2;
            }
        }
        
        return res;
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[] x, int[] y) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            graph.computeIfAbsent(x[i], k -> new HashSet<>()).add(y[i]);
            graph.computeIfAbsent(y[i], k -> new HashSet<>()).add(x[i]);
        }
        return graph;
    }
    
    public static void main(String[] args) {
        int[] x = {1, 1, 2, 2, 3}, y = {2, 3, 4, 5, 6}, a = {1, 2, 1, 5, 5}, b = {2, 3, 4, 6, 4};
        System.out.println(Arrays.toString(new Solution().tree(x, y, a, b)));
    }
}
