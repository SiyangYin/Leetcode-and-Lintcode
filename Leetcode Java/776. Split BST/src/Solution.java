public class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
    
        if (root.val <= target) {
            TreeNode[] nodes = splitBST(root.right, target);
            root.right = nodes[0];
            return new TreeNode[]{root, nodes[1]};
        } else {
            TreeNode[] nodes = splitBST(root.left, target);
            root.left = nodes[1];
            return new TreeNode[]{nodes[0], root};
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