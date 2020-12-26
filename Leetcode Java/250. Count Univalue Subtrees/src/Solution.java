public class Solution {
    
    private int res;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root);
        return res;
    }
    
    private boolean dfs(TreeNode root) {
        boolean isUni = true;
        if (root.left != null) {
            isUni &= dfs(root.left) && root.val == root.left.val;
        }
        if (root.right != null) {
            isUni &= dfs(root.right) && root.val == root.right.val;
        }
        
        if (isUni) {
            res++;
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(-89);
        root.left.right.right = new TreeNode(-38);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(-38);
        root.right.left.right = new TreeNode(-89);
        System.out.println(new Solution().countUnivalSubtrees(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}