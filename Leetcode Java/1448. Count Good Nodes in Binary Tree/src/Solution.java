public class Solution {
    
    private int res;
    
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        res = 0;
        dfs(root, Integer.MIN_VALUE);
        return res;
    }
    
    private void dfs(TreeNode cur, int max) {
        if (cur == null) {
            return;
        }
        
        if (cur.val >= max) {
            res++;
        }
        
        dfs(cur.left, Math.max(cur.val, max));
        dfs(cur.right, Math.max(cur.val, max));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}