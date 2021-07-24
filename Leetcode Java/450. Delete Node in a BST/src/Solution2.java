public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (root.left == null && root.right == null) {
            return null;
        } else {
            if (root.left != null) {
                root = zig(root);
                root.right = deleteNode(root.right, key);
            } else {
                root = zag(root);
                root.left = deleteNode(root.left, key);
            }
        }
        
        return root;
    }
    
    private TreeNode zig(TreeNode p) {
        TreeNode q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
    
    private TreeNode zag(TreeNode p) {
        TreeNode q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        //
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(1);
        
        TreeNode res = new Solution2().deleteNode(root, 3);
        System.out.println(res);
    }
}