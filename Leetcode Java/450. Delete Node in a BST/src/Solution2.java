public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        dummy.right = root;
        TreeNode prev = dummy, cur = root;
        
        while (cur != null && cur.val != key) {
            prev = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        
        if (cur == null) {
            return root;
        }
        
        if (prev.val > key) {  // cur是prev左孩子
            if (cur.left == null) {
                prev.left = cur.right;
            } else if (cur.right == null) {
                prev.left = cur.left;
            } else {
                deleteGreatestInLeft(cur);
            }
        } else {
            if (cur.left == null) {
                prev.right = cur.right;
            } else if (cur.right == null) {
                prev.right = cur.left;
            } else {
                deleteGreatestInLeft(cur);
            }
        }
        
        return dummy.right;
    }
    
    private void deleteGreatestInLeft(TreeNode cur) {
        if (cur.left.right == null) {
            cur.val = cur.left.val;
            cur.left = cur.left.left;
        } else {
            TreeNode second = cur.left, first = cur.left;
            while (first.right != null) {
                second = first;
                first = first.right;
            }
            
            cur.val = first.val;
            second.right = first.left;
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
        
        TreeNode res = new Solution2().deleteNode(root, 2);
        System.out.println(res);
    }
}