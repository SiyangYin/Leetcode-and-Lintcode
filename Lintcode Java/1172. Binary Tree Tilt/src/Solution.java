public class Solution {
    
    private int res;
    
    /**
     * @param root: the root
     * @return: the tilt of the whole tree
     */
    public int findTilt(TreeNode root) {
        // Write your code here
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        
        int l = dfs(cur.left), r = dfs(cur.right);
        res += Math.abs(l - r);
        
        return cur.val + l + r;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}