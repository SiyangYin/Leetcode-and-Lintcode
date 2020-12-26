import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 1, k, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int n, int pos, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; k - cur.size() <= n - i + 1; i++) {
            cur.add(i);
            dfs(n, i + 1, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
