public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return select(root, k);
    }
    
    private int select(TreeNode root, int k) {
        int num = count(root.left);
        if (num < k - 1) {
            return select(root.right, k - num - 1);
        } else if (num > k - 1) {
            return select(root.left, k);
        } else {
            return root.val;
        }
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + count(root.left) + count(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}