public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] dp = new int[2];
        
        int[] left = dfs(root.left), right = dfs(root.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        
        return dp;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}