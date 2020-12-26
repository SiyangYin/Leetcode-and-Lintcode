public class Solution {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Solution().isSymmetric(root));
    }
}