import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(root, 0, sum, memo);
    }
    
    private int dfs(TreeNode root, int curSum, int target, Map<Integer, Integer> memo) {
        if (root == null) {
            return 0;
        }
        
        curSum += root.val;
        
        int res = memo.getOrDefault(curSum - target, 0);
        memo.put(curSum, memo.getOrDefault(curSum, 0) + 1);
        
        res += dfs(root.left, curSum, target, memo);
        res += dfs(root.right, curSum, target, memo);
        
        memo.put(curSum, memo.get(curSum) - 1);
        
        return res;
    }
}
