public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = depth(root.left);
        int r = depth(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) >= 2) {
            return -1;
        } else {
            return Math.max(l, r) + 1;
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