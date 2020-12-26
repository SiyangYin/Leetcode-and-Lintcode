public class Solution2 {
    int maxSum = Integer.MIN_VALUE;
    TreeNode res = null;
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        sum(root);
        return res;
    }
    
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = sum(root.left), right = sum(root.right);
        int total = left + right + root.val;
        if (maxSum < total) {
            maxSum = total;
            res = root;
        }
        
        return total;
    }
}
