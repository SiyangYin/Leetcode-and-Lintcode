public class Solution {
    /**
     * @param root: the root node
     * @param L: an integer
     * @param R: an integer
     * @return: the sum
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        // write your code here.
        if (root == null) {
            return 0;
        }
        
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}