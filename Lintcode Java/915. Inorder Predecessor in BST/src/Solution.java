public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode pred = null;
        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            } else {
                pred = root;
                root = root.right;
            }
        }
        
        return pred;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
    
        System.out.println(new Solution().inorderPredecessor(root, root.right).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}

