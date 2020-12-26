import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
    
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), 0, 0, target, candidates, res);
        
        return res;
    }
    
    private void dfs(List<Integer> cur, int sum, int pos, int target, int[] candidates, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            
            cur.add(candidates[i]);
            dfs(cur, sum + candidates[i], i, target, candidates, res);
            cur.remove(cur.size() - 1);
        }
    }
}
