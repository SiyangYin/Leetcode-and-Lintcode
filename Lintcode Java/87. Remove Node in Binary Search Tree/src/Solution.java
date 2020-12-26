public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        if (root.val < value) {
            root.right = removeNode(root.right, value);
        } else if (root.val > value) {
            root.left = removeNode(root.left, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode prev, cur;
                prev = cur = root.left;
                cur = cur.right;
                if (cur == null) {
                    root.val = prev.val;
                    root.left = prev.left;
                } else {
                    while (cur.right != null) {
                        cur = cur.right;
                        prev = prev.right;
                    }
                    root.val = cur.val;
                    prev.right = cur.left;
                }
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        new Solution().removeNode(root, 3);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}