public class Solution {
    /**
     * @param root: the root of binary tree
     * @param v:    a integer
     * @param d:    a integer
     * @return: return a TreeNode
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // write your code here
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        dfs(root, 1, d, v);
        
        return root;
    }
    
    private void dfs(TreeNode cur, int depth, int d, int v) {
        if (cur == null) {
            return;
        }
        
        if (depth == d - 1) {
            TreeNode left = cur.left, right = cur.right;
            cur.left = new TreeNode(v);
            cur.left.left = left;
            cur.right = new TreeNode(v);
            cur.right.right = right;
            return;
        }
        
        dfs(cur.left, depth + 1, d, v);
        dfs(cur.right, depth + 1, d, v);
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
