public class Solution {
    /**
     * @param root: root of the tree
     * @param p: the node p
     * @param q: the node q
     * @return: find the LCA of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // write your code here
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        
        TreeNode p = root;
        TreeNode q = root.left;
    
        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
