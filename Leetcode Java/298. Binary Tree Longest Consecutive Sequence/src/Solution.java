public class Solution {
    
    private int res;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
    
        int len = 1;
        
        int left = dfs(root.left), right = dfs(root.right);
        if (root.left != null && root.left.val == root.val + 1) {
            len = Math.max(len, 1 + left);
        }
        
        if (root.right != null && root.right.val == root.val + 1) {
            len = Math.max(len, 1 + right);
        }
    
        res = Math.max(res, len);
        return len;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}