public class Solution {
    
    private int sum = Integer.MAX_VALUE;
    
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        dfs(cur.right);
        if (sum == Integer.MAX_VALUE) {
            sum = cur.val;
        } else {
            cur.val += sum;
            sum = cur.val;
        }
        
        dfs(cur.left);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}