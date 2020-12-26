public class Solution {
    
    private int res;
    
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0, 0};
        }
        
        int[] left = dfs(cur.left), right = dfs(cur.right);
        if (left[0] == -1 || right[0] == -1) {
            return new int[]{-1, 0, 0};
        }
        
        if ((cur.left == null || cur.val > left[1]) && (cur.right == null || cur.val < right[2])) {
            res = Math.max(res, 1 + left[0] + right[0]);
            int min = 0, max = 0;
            min = max = cur.val;
            if (cur.left != null) {
                min = Math.min(min, left[2]);
            }
            if (cur.right != null) {
                max = Math.max(max, right[1]);
            }
            
            return new int[]{1 + left[0] + right[0], max, min};
        }
        
        return new int[]{-1, 0, 0};
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}