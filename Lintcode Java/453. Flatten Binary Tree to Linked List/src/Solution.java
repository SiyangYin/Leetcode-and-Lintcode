public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        if (root.left == null) {
            return;
        }
        TreeNode node = root.left;
        while (node.right != null) {
            node = node.right;
        }
        
        node.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    
    // Tn = Tl + Tr + Ol
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        new Solution().flatten(root);
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}