public class Solution {
    
    private int res;
    
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
    
        int len = 1, downLen = 1;
        int left = dfs(root.left), right = dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            len += left;
            downLen = Math.max(downLen, 1 + left);
        }
        if (root.right != null && root.val == root.right.val) {
            len += right;
            downLen = Math.max(downLen, 1 + right);
        }
        
        res = Math.max(res, len - 1);
        
        return downLen;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}