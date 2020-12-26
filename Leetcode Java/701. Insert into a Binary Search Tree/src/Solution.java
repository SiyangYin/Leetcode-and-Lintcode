public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
    
    public void insert(TreeNode root, int target) {
        if (root == null) {
            root = new TreeNode(target);
            return;
        }
        
        if (root.val < target) {
            insert(root.right, target);
        } else if (root.val > target) {
            insert(root.left, target);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        new Solution().insert(root, -1);
        System.out.println(root.left);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}