public class Solution1 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null || isLeaf(root) && root.val == target) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (isLeaf(root) && root.val == target) {
            return null;
        }
        return root;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
    
        TreeNode res = new Solution1().removeLeafNodes(root, 2);
        System.out.println(res);
    }
}

