import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}