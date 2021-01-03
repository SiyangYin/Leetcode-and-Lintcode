public class Solution {
    
    private int sum;
    
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
    
        dfs(cur.right);
        cur.val += sum;
        sum = cur.val;
        dfs(cur.left);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        TreeNode r = new Solution().bstToGst(root);
        System.out.println(r);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}