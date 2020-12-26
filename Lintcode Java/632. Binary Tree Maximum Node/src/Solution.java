public class Solution {
    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        TreeNode left = maxNode(root.left), right = maxNode(root.right);
        if (left == null && right == null) {
            return root;
        } else if (left == null) {
            return root.val > right.val ? root : right;
        } else if (right == null) {
            return root.val > left.val ? root : left;
        } else {
            if (root.val > Math.max(left.val, right.val)) {
                return root;
            } else {
                return left.val > right.val ? left : right;
            }
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