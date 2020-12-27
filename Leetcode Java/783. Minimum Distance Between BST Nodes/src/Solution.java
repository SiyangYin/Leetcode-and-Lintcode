public class Solution {
    
    private int res, prev;
    
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = Integer.MIN_VALUE / 2;
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        dfs(cur.left);
        res = Math.min(res, cur.val - prev);
        prev = cur.val;
        dfs(cur.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}