public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }
    
    private TreeNode dfs(TreeNode t1, TreeNode t2, TreeNode x1) {
        if (t1 == null) {
            return null;
        }
        
        if (t1 == x1) {
            return t2;
        }
    
        TreeNode left = dfs(t1.left, t2.left, x1);
        if (left != null) {
            return left;
        } else {
            return dfs(t1.right, t2.right, x1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}