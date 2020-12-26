public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, root.val);
    }
    
    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        
        return root.val == val && dfs(root.left, val) && dfs(root.right, val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
