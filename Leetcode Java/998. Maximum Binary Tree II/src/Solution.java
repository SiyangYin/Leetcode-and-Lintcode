public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        
        if (root.val < val) {
            node.left = root;
            return node;
        }
        
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
