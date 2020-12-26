public class Solution {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        
        return a.val == b.val &&
                ((isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right))
                        || (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)));
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1), b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        
        b.left = new TreeNode(3);
        b.right = new TreeNode(4);
        b.right.right = new TreeNode(2);
        
        System.out.println(new Solution().isTweakedIdentical(a, b));
        
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}