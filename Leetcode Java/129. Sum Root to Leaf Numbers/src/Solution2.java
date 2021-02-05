public class Solution2 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode cur, int prev) {
        if (cur == null) {
            return 0;
        }
        
        int val = prev * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            return val;
        }
        
        return dfs(cur.left, val) + dfs(cur.right, val);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(new Solution2().sumNumbers(root));
    }
}
