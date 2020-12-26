public class Solution {
    
    private int res;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }
    
    // 返回从root向下的最长递增、递减路径的长度
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] lens = {1, 1};
        int[] left = dfs(root.left), right = dfs(root.right);
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                lens[0] = Math.max(lens[0], 1 + left[0]);
            }
            if (root.left.val == root.val - 1) {
                lens[1] = Math.max(lens[1], 1 + left[1]);
            }
        }
        
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                lens[0] = Math.max(lens[0], 1 + right[0]);
            }
            if (root.right.val == root.val - 1) {
                lens[1] = Math.max(lens[1], 1 + right[1]);
            }
        }
        
        res = Math.max(res, lens[0] + lens[1] - 1);
        
        return lens;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}