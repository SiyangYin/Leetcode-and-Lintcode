public class Solution {
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        return buildTree(A, 0, A.length - 1);
    }
    
    private TreeNode buildTree(int[] A, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int m = l + (r - l >> 1);
        TreeNode root = new TreeNode(A[m]);
        root.left = buildTree(A, l, m - 1);
        root.right = buildTree(A, m + 1, r);
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