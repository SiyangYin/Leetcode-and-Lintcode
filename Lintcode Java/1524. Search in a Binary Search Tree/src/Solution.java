public class Solution {
    /**
     * @param root: the tree
     * @param val: the val which should be find
     * @return: the node
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // Write your code here.
        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}