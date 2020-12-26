public class Solution {
    /**
     * @param root: the tree
     * @param sum: the sum
     * @return:  if the tree has a root-to-leaf path
     */
    public boolean pathSum(TreeNode root, int sum) {
        // Write your code here.
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        
        return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}