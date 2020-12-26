public class Solution {
    /**
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    public int sumNumbers(TreeNode root) {
        // write your code here
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        
        int sum = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}