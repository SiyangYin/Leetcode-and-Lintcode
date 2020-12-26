public class Solution {
    
    private TreeNode res;
    
    /**
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        if (cur.left != null) {
            dfs(cur.left);
            cur.left.right = cur;
            cur.left.left = cur.right;
            
            cur.left = cur.right = null;
        } else {
            res = cur;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}