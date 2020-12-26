public class Solution {
    
    private int res;
    
    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        dfs(root);
        return res - 1;
    }
    
    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        
        int left = dfs(cur.left), right = dfs(cur.right);
        res = Math.max(res, 1 + left + right);
        return 1 + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}