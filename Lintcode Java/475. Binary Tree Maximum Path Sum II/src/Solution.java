public class Solution {
    
    private int res;
    
    /**
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        // write your code here
        res = Integer.MIN_VALUE;
        
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        sum += root.val;
        res = Math.max(res, sum);
        
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}