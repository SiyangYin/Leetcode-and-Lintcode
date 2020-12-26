public class Solution {
    /**
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        if (root.val < minimum) {
            return trimBST(root.right, minimum, maximum);
        } else if (root.val > maximum) {
            return trimBST(root.left, minimum, maximum);
        } else {
            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);
            return root;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}