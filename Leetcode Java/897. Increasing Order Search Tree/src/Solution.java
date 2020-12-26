public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = increasingBST(root.left);
        root.left = null;
        root.right = increasingBST(root.right);
        if (left == null) {
            return root;
        }
        
        TreeNode leftTail = left;
        while (leftTail.right != null) {
            leftTail = leftTail.right;
        }
        
        leftTail.right = root;
        
        return left;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        
        TreeNode root1 = new Solution().increasingBST(root);
        System.out.println(root1);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}