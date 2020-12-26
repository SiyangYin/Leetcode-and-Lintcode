public class Solution3 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int lHight = height(root.left);
        int rHight = height(root.right);
        if (Math.abs(lHight - rHight) > 1 || lHight == -1 || rHight == -1) {
            return -1;
        }
        
        return Math.max(lHight, rHight) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(5);
        
        System.out.println(new Solution3().isBalanced(root));
    }
}
