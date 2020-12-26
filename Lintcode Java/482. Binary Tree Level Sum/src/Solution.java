public class Solution {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        return calculate(root, 1, level);
    }
    
    private int calculate(TreeNode root, int cur, int level) {
        if (root == null || cur > level) {
            return 0;
        }
        
        if (cur == level) {
            return root.val;
        } else {
            return calculate(root.left, cur + 1, level) + calculate(root.right, cur + 1, level);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}