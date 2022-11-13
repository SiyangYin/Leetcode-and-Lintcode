public class Solution4 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = root;
        TreeNode cur = root;
        boolean isLeft = true;
        while (cur != null && cur.val != key) {
            prev = cur;
            if (cur.val < key) {
                isLeft = false;
                cur = cur.right;
            }
            else {
                isLeft = true;
                cur = cur.left;
            }
        }
        if (cur == null) {
            return root;
        }
        if (isLeft) {
            if (cur.left == null) {
                if (prev == cur) {
                    root = cur.right;
                }
                else {
                    prev.left = cur.right;
                }
            }
            else if (cur.right == null) {
                if (prev == cur) {
                    root = cur.left;
                }
                else {
                    prev.left = cur.left;
                }
            }
            else {
                TreeNode p = cur.right;
                if (prev == cur) {
                    root = cur.right;
                }
                else {
                    prev.left = cur.right;
                }
                while (p.left != null) {
                    p = p.left;
                }
                p.left = cur.left;
            }
        }
        else {
            if (cur.left == null) {
                prev.right = cur.right;
            }
            else if (cur.right == null) {
                prev.right = cur.left;
            }
            else {
                TreeNode p = cur.right;
                while (p.left != null) {
                    p = p.left;
                }
                p.left = cur.left;
                prev.right = cur.right;
            }
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
        
        TreeNode res = new Solution4().deleteNode(root, 2);
        System.out.println(res);
    }
}

