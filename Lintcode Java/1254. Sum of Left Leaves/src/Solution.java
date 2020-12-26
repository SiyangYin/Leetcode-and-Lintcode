public class Solution {
    /**
     * @param root: t
     * @return: the sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        return sumLeft(root.left, root) + sumLeft(root.right, root);
    }
    
    private int sumLeft(TreeNode cur, TreeNode parent) {
        if (cur == null) {
            return 0;
        }
        
        if (cur.left == null && cur.right == null && cur == parent.left) {
            return cur.val;
        }
        
        return sumLeft(cur.left, cur) + sumLeft(cur.right, cur);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}