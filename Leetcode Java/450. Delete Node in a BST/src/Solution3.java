public class Solution3 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root = merge(root.left, root.right);
        }
        
        return root;
    }
    
    TreeNode merge(TreeNode p, TreeNode q) {
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        
        if ((p.val ^ q.val ^ 1) == 0) {
            p.right = merge(p.right, q);
            return p;
        } else {
            q.left = merge(p, q.left);
            return q;
        }
    }
}
