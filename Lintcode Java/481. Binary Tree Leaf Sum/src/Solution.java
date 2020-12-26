public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: An integer
     */
    public int leafSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        return leafSum(root.left) + leafSum(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}