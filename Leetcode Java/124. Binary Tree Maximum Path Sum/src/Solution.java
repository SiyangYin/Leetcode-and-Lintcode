public class Solution {
    
    private int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, dfs(root.left)), right = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}