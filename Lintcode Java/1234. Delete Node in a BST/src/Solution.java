import javax.imageio.event.IIOReadProgressListener;

public class Solution {
    /**
     * @param root: The root of the BST
     * @param key: The number needed to be deleted
     * @return: The root of the BST
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.left, prev = cur;
                if (cur.right == null) {
                    root.val = cur.val;
                    root.left = cur.left;
                } else {
                    while (cur.right != null) {
                        prev = cur;
                        cur = cur.right;
                    }
    
                    root.val = cur.val;
                    prev.right = cur.left;
                }
            }
        }
        
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