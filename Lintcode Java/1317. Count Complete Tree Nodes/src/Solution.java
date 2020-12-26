public class Solution {
    /**
     * @param root: root of complete binary tree
     * @return: the number of nodes
     */
    public int countNodes(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        TreeNode left = root, right = root;
        int lDepth = 0, rDepth = 0;
        while (left != null) {
            lDepth++;
            left = left.left;
        }
    
        while (right != null) {
            rDepth++;
            right = right.right;
        }
        
        if (lDepth == rDepth) {
            return (1 << lDepth) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
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