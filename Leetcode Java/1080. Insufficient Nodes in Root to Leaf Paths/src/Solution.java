import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null || isLeaf(root) && root.val < limit) {
            return null;
        }
        if (isLeaf(root)) {
            return root;
        }
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        if (isLeaf(root)) {
            return null;
        }
        return root;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}