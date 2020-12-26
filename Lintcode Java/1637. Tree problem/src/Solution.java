import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    private int res;
    private double average;
    
    /**
     * @param fa:  the father
     * @param val: the val
     * @return: the biggest node
     */
    public int treeProblem(int[] fa, int[] val) {
        // Write your code here
        Map<Integer, List<Integer>> tree = new HashMap<>();
        Map<Integer, Integer> valMap = new HashMap<>();
        tree.put(1, new ArrayList<>());
        valMap.put(1, val[0]);
        
        buildTree(fa, val, tree, valMap);
        
        dfs(1, tree, valMap);
        return res;
    }
    
    private int[] dfs(int cur, Map<Integer, List<Integer>> tree, Map<Integer, Integer> valMap) {
        int n = 1, val = valMap.get(cur);
        if (tree.containsKey(cur)) {
            for (int next : tree.get(cur)) {
                int[] res = dfs(next, tree, valMap);
                n += res[0];
                val += res[1];
            }
        }
        
        double ave = (double) val / n;
        if (ave > average) {
            average = ave;
            res = cur;
        }
        
        return new int[]{n, val};
    }
    
    private void buildTree(int[] fa, int[] val, Map<Integer, List<Integer>> tree, Map<Integer, Integer> valMap) {
        for (int i = 1; i < fa.length; i++) {
            tree.putIfAbsent(fa[i], new ArrayList<>());
            tree.get(fa[i]).add(i + 1);
            valMap.put(i + 1, val[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] fa = {-1, 1, 1, 2, 2, 2, 3, 3};
        int[] val = {100, 120, 80, 40, 50, 60, 50, 70};
        System.out.println(new Solution().treeProblem(fa, val));
    }
}
