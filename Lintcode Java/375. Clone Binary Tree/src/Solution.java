public class Solution {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        TreeNode copy = new TreeNode(root.val);
        copy.left = cloneTree(root.left);
        copy.right = cloneTree(root.right);
        
        return copy;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}