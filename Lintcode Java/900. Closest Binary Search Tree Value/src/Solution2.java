public class Solution2 {
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int res = root.val;
        if (target < root.val && root.left != null) {
            res = closestValue(root.left, target);
        }
        if (target > root.val && root.right != null) {
            res = closestValue(root.right, target);
        }
        
        if (Math.abs(root.val - target) < Math.abs(res - target)) {
            res = root.val;
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
        
        System.out.println(new Solution2().closestValue(root, 6.124780));
    }
}
