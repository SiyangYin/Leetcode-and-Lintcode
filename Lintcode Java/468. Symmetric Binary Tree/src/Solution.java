public class Solution {
    /**
     * @param root: the root of binary tree.
     * @return: true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return isSym(root.left, root.right);
    }
    
    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && isSym(left.left, right.right) && isSym(left.right, right.left);
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