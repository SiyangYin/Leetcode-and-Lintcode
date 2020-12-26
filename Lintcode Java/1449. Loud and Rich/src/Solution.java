import java.util.*;

public class Solution {
    /**
     * @param richer: the richer array
     * @param quiet:  the quiet array
     * @return: the answer
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // Write your code here.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : richer) {
            int rich = pair[0], poor = pair[1];
            graph.putIfAbsent(poor, new ArrayList<>());
            graph.get(poor).add(rich);
        }
        
        int[] res = new int[quiet.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < quiet.length; i++) {
            dfs(i, graph, quiet, res);
        }
        
        return res;
    }
    
    private int dfs(int start, Map<Integer, List<Integer>> graph, int[] quiet, int[] res) {
        if (res[start] != -1) {
            return res[start];
        }
        
        int ans = start, minQuiet = quiet[start];
        if (graph.containsKey(start)) {
            for (int next : graph.get(start)) {
                int q = dfs(next, graph, quiet, res);
                if (quiet[q] < minQuiet) {
                    minQuiet = quiet[q];
                    ans = q;
                }
            }
        }
        
        res[start] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] q = {3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(new Solution().loudAndRich(richer, q)));
    }
}
