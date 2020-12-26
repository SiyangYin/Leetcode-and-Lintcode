public class Solution {
    
    double diff = Double.MAX_VALUE;
    int res;
    
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (Math.abs(root.val - target) < diff) {
            diff = Math.abs(root.val - target);
            res = root.val;
        }
        
        if (target < root.val && root.left != null) {
            closestValue(root.left, target);
        }
        if (target > root.val && root.right != null) {
            closestValue(root.right, target);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        
        System.out.println(new Solution().closestValue(root, 6.124780));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
