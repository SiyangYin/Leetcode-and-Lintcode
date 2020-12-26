public class Solution {
    
    private int count = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = lca(root, p, q);
        return count == 2 ? res : null;
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = lca(root.left, p, q), right = lca(root.right, p, q);
        
        if (root == p || root == q) {
            count++;
            return root;
        }
    
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}