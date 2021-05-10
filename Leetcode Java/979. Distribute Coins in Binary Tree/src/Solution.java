public class Solution {
    
    private int res;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        
        int left = dfs(cur.left), right = dfs(cur.right);
        res += Math.abs(left) + Math.abs(right);
        return cur.val + left + right - 1;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}