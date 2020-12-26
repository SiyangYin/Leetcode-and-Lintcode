public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        
        if (root.right.left == null) {
            root.val = root.right.val;
            root.right = root.right.right;
            return root;
        }
        
        TreeNode cur = root.right;
        TreeNode prev = cur;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        
        root.val = cur.val;
        prev.left = cur.right;
        return root;
    }
    
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.left.left = new TreeNode(2);
        // root.left.right = new TreeNode(4);
        // root.right = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        
        TreeNode res = new Solution().deleteNode(root, 2);
        System.out.println(res);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
