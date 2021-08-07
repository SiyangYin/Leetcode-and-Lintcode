public class Solution {
    
    TreeNode res;
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        dfs(root, null);
        root.left = root.right = null;
        return res;
    }
    
    void dfs(TreeNode cur, TreeNode parent) {
        if (cur == null) {
            return;
        }
    
        if (cur.left == null) {
            res = cur;
        }
        
        dfs(cur.left, cur);
        if (parent != null) {
            cur.left = parent.right;
            cur.right = parent;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode node = new Solution().upsideDownBinaryTree(root);
        System.out.println(node);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}