import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode cur, List<Integer> res) {
        if (cur == null) {
            return;
        }
        
        if (cur.left != null && cur.right == null) {
            res.add(cur.left.val);
        }
        if (cur.right != null && cur.left == null) {
            res.add(cur.right.val);
        }
        
        dfs(cur.left, res);
        dfs(cur.right, res);
    }
}
