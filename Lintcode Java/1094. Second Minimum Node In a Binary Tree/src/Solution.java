public class Solution {
    
    private int min, secondMin;
    
    /**
     * @param root: the root
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
    public int findSecondMinimumValue(TreeNode root) {
        // Write your code here
        min = secondMin = Integer.MAX_VALUE;
        dfs(root);
        return secondMin == Integer.MAX_VALUE ? -1 : secondMin;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.val < min) {
            secondMin = min;
            min = root.val;
        } else if (min < root.val && root.val < secondMin) {
            secondMin = root.val;
        }
        
        dfs(root.left);
        dfs(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}