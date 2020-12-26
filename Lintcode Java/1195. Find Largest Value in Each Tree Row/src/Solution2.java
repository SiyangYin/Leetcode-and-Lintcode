import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * @param root: a root of integer
     * @return: return a list of integer
     */
    public List<Integer> largestValues(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}
