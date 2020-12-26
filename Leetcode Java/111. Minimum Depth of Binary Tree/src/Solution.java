public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left =  minDepth(root.left), right =  minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }
}
