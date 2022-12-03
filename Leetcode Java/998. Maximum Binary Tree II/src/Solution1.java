public class Solution1 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        TreeNode p = root;
        while (p.right != null && p.right.val > val) {
            p = p.right;
        }
        if (p.right == null) {
            p.right = new TreeNode(val);
        }
        else {
            TreeNode node = new TreeNode(val);
            node.left = p.right;
            p.right = node;
        }
        return root;
    }
}

