public class Solution {
    int res = 0;
    
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left - right);
        
        return root.val + left + right;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}