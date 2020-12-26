public class Solution {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }
        
        return a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}