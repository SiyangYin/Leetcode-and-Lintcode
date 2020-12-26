public class Solution {
    
    private int res;
    
    /**
     * @param root: the root node
     * @param k: an integer
     * @return: the number of nodes in the k-th layer of the binary tree
     */
    public int kthfloorNode(TreeNode root, int k) {
        // Write your code here
        dfs(root, k, 1);
        return res;
    }
    
    private void dfs(TreeNode root, int targetDepth, int curDepth) {
        if (root == null) {
            return;
        }
        
        if (curDepth == targetDepth) {
            res++;
            return;
        }
        
        dfs(root.left, targetDepth, curDepth + 1);
        dfs(root.right, targetDepth, curDepth + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}