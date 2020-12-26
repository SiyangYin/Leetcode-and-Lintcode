import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(2, n, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int fac, int n, List<Integer> cur, List<List<Integer>> res) {
        if (n == 1 && cur.size() != 1) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = fac; i <= n; i++) {
            if (i > n / i) {
                cur.add(n);
                dfs(fac, 1, cur, res);
                cur.remove(cur.size() - 1);
                break;
            }
            
            if (n % i == 0) {
                cur.add(i);
                dfs(i, n / i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getFactors(8));
        System.out.println(new Solution().getFactors(1));
        System.out.println(new Solution().getFactors(24));
    }
}
