public class Solution {
    
    private int res, pDepth, qDepth;
    
    public int findDistance(TreeNode root, int p, int q) {
        dfs(root, 0, p, q);
        return res;
    }
    
    private boolean dfs(TreeNode root, int depth, int p, int q) {
        if (root == null) {
            return false;
        }
        
        if (root.val == p) {
            pDepth = depth;
        }
        if (root.val == q) {
            qDepth = depth;
        }
        
        boolean left = dfs(root.left, depth + 1, p, q), right = dfs(root.right, depth + 1, p, q);
        if (left && right) {
            res = pDepth + qDepth - 2 * depth;
            return true;
        }
        
        if ((root.val == p || root.val == q) && (left || right)) {
            res = Math.abs(pDepth - qDepth);
            return true;
        }
        
        return root.val == p || root.val == q || left || right;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new Solution().findDistance(root, 5, 5));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
