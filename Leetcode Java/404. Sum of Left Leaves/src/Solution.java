public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        
        return sum(root.left, true) + sum(root.right, false);
    }
    
    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        
        return sum(root.left, true) + sum(root.right, false);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
    
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
