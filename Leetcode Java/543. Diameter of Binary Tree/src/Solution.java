public class Solution {
    
    private int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left), right = dfs(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
