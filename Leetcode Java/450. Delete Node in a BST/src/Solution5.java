public class Solution5 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
                TreeNode p = root.right;
                while (p.left != null) {
                    p = p.left;
                }
                p.left = root.left;
                return root.right;
            }
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            root.left = deleteNode(root.left, key);
        }
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
        
        TreeNode res = new Solution5().deleteNode(root, 2);
        System.out.println(res);
    }
}

