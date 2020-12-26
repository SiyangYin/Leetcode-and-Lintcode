public class Solution {
    
    private int res;
    
    /**
     * @param root: a Binary Search Tree (BST) with the root node
     * @return: the minimum difference
     */
    public int minDiffInBST(TreeNode root) {
        // Write your code here.
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        int[] left = null, right = null;
        int[] ret = {cur.val, cur.val};
        if (cur.left != null) {
            left = dfs(cur.left);
            ret[0] = left[0];
            res = Math.min(res, cur.val - left[1]);
        }
        if (cur.right != null) {
            right = dfs(cur.right);
            ret[1] = right[1];
            res = Math.min(res, right[0] - cur.val);
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(new Solution().minDiffInBST(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}