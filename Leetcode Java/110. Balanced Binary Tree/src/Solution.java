public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isBalanced(root.left) && isBalanced(root.right) &&
                Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }
    
    static int a = 0;
    private int depth(TreeNode root) {
        System.out.println("hey " + ++a);
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(5);
    
        System.out.println(new Solution().isBalanced(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
