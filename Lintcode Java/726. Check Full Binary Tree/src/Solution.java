public class Solution {
    /**
     * @param root: the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        } else {
            return isFullTree(root.left) && isFullTree(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
