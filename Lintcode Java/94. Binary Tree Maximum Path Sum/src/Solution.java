public class Solution {
    
    private int res;
    
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(dfs(root.left), 0), right = Math.max(dfs(root.right), 0);
        res = Math.max(res, left + right + root.val);
        
        return Math.max(left, right) + root.val;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().maxPathSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}