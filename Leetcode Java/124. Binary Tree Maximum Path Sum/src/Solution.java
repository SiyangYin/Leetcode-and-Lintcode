public class Solution {
    
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        largestFrom(root);
        return res;
    }
    
    private int largestFrom(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, largestFrom(root.left));
        int right = Math.max(0, largestFrom(root.right));
        
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    
        System.out.println(new Solution().maxPathSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}