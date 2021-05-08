public class Solution {
    
    private TreeNode res;
    private int maxDepth;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        
        maxDepth = Math.max(maxDepth, depth);
        int left = dfs(root.left, depth + 1), right = dfs(root.right, depth + 1);
        
        if (left == right && left == maxDepth) {
            res = root;
        }
        
        return Math.max(left, right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
    
        System.out.println(new Solution().subtreeWithAllDeepest(root).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}