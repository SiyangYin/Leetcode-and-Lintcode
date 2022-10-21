public class Solution1 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.right != null) flatten(root.right);
        if (root.left != null) {
            flatten(root.left);
            TreeNode p = root.left;
            while (p.right != null) p = p.right;
            p.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        
        new Solution1().flatten(root);
        System.out.println(root);
    }
}

