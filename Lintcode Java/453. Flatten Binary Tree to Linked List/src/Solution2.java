public class Solution2 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        flattenAndGetlast(root);
    }
    
    private TreeNode flattenAndGetlast(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = flattenAndGetlast(root.left);
        TreeNode rightLast = flattenAndGetlast(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast == null) {
            return leftLast == null ? root : leftLast;
        } else {
            return rightLast;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.left.right.right = new TreeNode(3);
        // root.right = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        
        new Solution2().flatten(root);
        System.out.println();
    }
}
