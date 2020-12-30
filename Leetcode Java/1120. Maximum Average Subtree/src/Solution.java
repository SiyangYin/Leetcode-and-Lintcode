public class Solution {
    
    private double res;
    
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
    
        int[] left = dfs(cur.left), right = dfs(cur.right);
        int count = left[0] + right[0] + 1, sum = left[1] + right[1] + cur.val;
        
        res = Math.max(res, (double) sum / count);
        return new int[]{count, sum};
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}