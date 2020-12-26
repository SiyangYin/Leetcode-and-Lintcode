public class Solution {
    /**
     * @param root: the root
     * @return: the same tree where every subtree (of the given tree) not containing a 1 has been removed
     */
    public TreeNode pruneTree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
    
        new Solution().pruneTree(root);
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}