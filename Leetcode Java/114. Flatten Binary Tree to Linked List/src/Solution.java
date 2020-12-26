public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        TreeNode rightTail = dfs(root.right);
        TreeNode leftTail = dfs(root.left);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return rightTail == null ? leftTail : rightTail;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        
        new Solution().flatten(root);
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}