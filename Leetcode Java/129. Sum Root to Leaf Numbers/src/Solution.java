public class Solution {
    
    private int res;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += cur;
            return;
        }
        
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}

