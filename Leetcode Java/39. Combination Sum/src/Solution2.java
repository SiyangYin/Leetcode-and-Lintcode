import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 0, target, candidates, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int idx, int sum, int target, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        if (idx == nums.length) {
            return;
        }
    
        for (int i = 0; sum + i * nums[idx] <= target; i++) {
            dfs(idx + 1, sum + i * nums[idx], target, nums, list, res);
            list.add(nums[idx]);
        }
    
        for (int i = 0; sum + i * nums[idx] <= target; i++) {
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
