public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode succ = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        
        return succ;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
    
        System.out.println(new Solution().inorderSuccessor(root, root.right.left).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}
