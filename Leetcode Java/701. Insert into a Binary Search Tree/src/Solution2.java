public class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                }
                cur = cur.left;
            } else if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                }
                cur = cur.right;
            } else {
                return root;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        new Solution2().insertIntoBST(root, -1);
        System.out.println(root.left.val);
    }
}
