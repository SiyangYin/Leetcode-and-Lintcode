import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    private long res, MOD = (int) (1E7 + 7);
    
    /**
     * @param start: The start of the edges set
     * @param end:   The end of the edges set
     * @return: Return the subtree count
     */
    public int getSubtreeCount(int[] start, int[] end) {
        // Write your code here
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < start.length; i++) {
            tree.putIfAbsent(start[i], new ArrayList<>());
            tree.get(start[i]).add(end[i]);
        }
        
        dfs(1, tree);
        return (int) (res % MOD);
    }
    
    private int dfs(int cur, Map<Integer, List<Integer>> tree) {
        if (!tree.containsKey(cur)) {
            res = (res + 1) % MOD;
            return 1;
        }
        
        long cnt = 1;
        for (int next : tree.get(cur)) {
            int subcnt = dfs(next, tree);
            cnt *= 1 + subcnt;
            cnt %= MOD;
        }
        
        res = (res + cnt) % MOD;
        return (int) cnt;
    }
    
    public static void main(String[] args) {
        int[] s = {1, 1}, t = {2, 3};
        System.out.println(new Solution().getSubtreeCount(s, t));
    }
}
