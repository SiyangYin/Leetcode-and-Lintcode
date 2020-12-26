public class Solution {
    /**
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (isEqual(T1, T2)) {
            return true;
        } else if (T1 == null) {
            return false;
        }
        
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    private boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        } else if (T1 == null || T2 == null) {
            return false;
        }
        
        return T1.val == T2.val && isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}