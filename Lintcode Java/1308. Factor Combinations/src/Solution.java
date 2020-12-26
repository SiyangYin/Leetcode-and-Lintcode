import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(n, 2, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int n, int fac, List<Integer> cur, List<List<Integer>> res) {
        if (n == 1) {
            if (cur.size() > 1) {
                res.add(new ArrayList<>(cur));
            }
            
            return;
        }
    
        cur.add(n);
        dfs(1, n, cur, res);
        cur.remove(cur.size() - 1);
        
        for (int i = fac; i * i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                dfs(n / i, i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
