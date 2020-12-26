public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root = new TreeNode(1);
        root.left = new TreeNode(1);
        // root.right = new TreeNode(4);
        // root.right.left = new TreeNode(3);
        // root.right.right = new TreeNode(6);
    
        System.out.println(new Solution().isValidBST(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
