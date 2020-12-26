public class Solution {
    /**
     * @param root: the root
     * @return: minimum sum
     */
    public int minimumSum(TreeNode root) {
        // Write your code here
        return dfs(root);
    }
    
    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        if (cur.left != null) {
            res = Math.min(res, cur.val + dfs(cur.left));
        }
        if (cur.right != null) {
            res = Math.min(res, cur.val + dfs(cur.right));
        }
        
        return res == Integer.MAX_VALUE ? cur.val : res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}