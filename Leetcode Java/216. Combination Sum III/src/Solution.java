import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int target, int k, int pos, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; i <= 9; i++) {
            if (i <= target && cur.size() < k) {
                cur.add(i);
                dfs(target - i, k, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            } else {
                return;
            }
        }
    }
}
