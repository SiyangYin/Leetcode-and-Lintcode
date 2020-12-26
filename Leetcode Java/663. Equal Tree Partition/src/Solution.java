public class Solution {
    
    private boolean res;
    private int sum;
    
    public boolean checkEqualTree(TreeNode root) {
        sum = dfs(root, root);
        
        if (sum % 2 != 0) {
            return false;
        }
        
        res = false;
        dfs(root, root);
        return res;
    }
    
    private int dfs(TreeNode cur, TreeNode root) {
        if (cur == null) {
            return 0;
        }
        
        int left = dfs(cur.left, root), right = dfs(cur.right, root);
        if ((left + right + cur.val) * 2 == sum && cur != root) {
            res = true;
        }
        
        return left + right + cur.val;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}