import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return res;
        }
    
        Arrays.sort(candidates);
        
        dfs(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] candidates, int target, int startPos, int sum,
                     List<Integer> cur, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = startPos; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] <= target) {
                cur.add(candidates[i]);
                dfs(candidates, target, i, sum + candidates[i], cur, res);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }
}
