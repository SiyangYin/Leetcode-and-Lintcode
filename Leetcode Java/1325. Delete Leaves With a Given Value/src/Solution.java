public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
    
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
    
        TreeNode res = new Solution().removeLeafNodes(root, 2);
        System.out.println(res);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}