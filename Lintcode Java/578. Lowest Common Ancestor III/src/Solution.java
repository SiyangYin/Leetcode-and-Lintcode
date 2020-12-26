public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (!exists(root, A) || !exists(root, B)) {
            return null;
        }
        
        return lca(root, A, B);
    }
    
    private TreeNode lca(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
    
        if (root == A) {
            return A;
        } else if (root == B) {
            return B;
        }
    
        TreeNode l = lca(root.left, A, B);
        TreeNode r = lca(root.right, A, B);
    
        if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return root;
        }
    }
    
    private boolean exists(TreeNode root, TreeNode A) {
        if (root == null) {
            return false;
        }
        
        if (root == A) {
            return true;
        } else {
            return exists(root.left, A) || exists(root.right, A);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode A = root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        TreeNode B = root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
    
        System.out.println(new Solution().lowestCommonAncestor3(root, A, B).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}