public class Solution {
    
    private int res;
    
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode cur, int num) {
        if (cur == null) {
            return;
        }
        
        num = num << 1 | cur.val;
        if (cur.left == null && cur.right == null) {
            res += num;
            return;
        }
        
        dfs(cur.left, num);
        dfs(cur.right, num);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}