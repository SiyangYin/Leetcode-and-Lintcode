public class Solution6 {
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
        dfs(root, root, key, true);
        return root;
    }

    public void dfs(TreeNode prev, TreeNode root, int key, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.val == key) {
            if (root.left == null) {
                if (isLeft) {
                    prev.left = root.right;
                }
                else {
                    prev.right = root.right;
                }
            }
            else if (root.right == null) {
                if (isLeft) {
                    prev.left = root.left;
                }
                else {
                    prev.right = root.left;
                }
            }
            else {
                TreeNode p = root.right;
                while (p.left != null) {
                    p = p.left;
                }
                p.left = root.left;
                if (isLeft) {
                    prev.left = root.right;
                }
                else {
                    prev.right = root.right;
                }
            }
        }
        else if (root.val < key) {
            dfs(root, root.right, key, false);
        }
        else {
            dfs(root, root.left, key, true);
        }
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
        
        TreeNode res = new Solution6().deleteNode(root, 2);
        System.out.println(res);
    }
}

