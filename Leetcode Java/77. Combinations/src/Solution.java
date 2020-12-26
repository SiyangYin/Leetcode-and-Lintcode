import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 1, k, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int n, int pos, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            dfs(n, i + 1, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
