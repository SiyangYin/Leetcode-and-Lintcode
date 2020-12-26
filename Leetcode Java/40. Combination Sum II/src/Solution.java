import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        
        dfs(new ArrayList<>(), 0, candidates, target, 0, res);
        return res;
    }
    
    private void dfs(List<Integer> cur, int sum, int[] nums, int target, int pos, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            
            if (sum + nums[i] > target) {
                break;
            }
            
            cur.add(nums[i]);
            dfs(cur, sum + nums[i], nums, target, i + 1, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(new Solution().combinationSum2(new int[]{1, 2, 2, 2, 5}, 5));
    }
}
