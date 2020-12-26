public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        
        return root1.val == root2.val &&
                helper(root1.left, root2.right) &&
                helper(root1.right, root2.left);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Solution2().isSymmetric(root));
    }
}
