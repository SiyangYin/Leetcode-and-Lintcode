public class Solution {
    int sum = 0;
    /**
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // write your code here
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        dfs(root.right);
        root.val += sum;
        sum = root.val;
        dfs(root.left);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
    
        System.out.println(new Solution().convertBST(root));
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}