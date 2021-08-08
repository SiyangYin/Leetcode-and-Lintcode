public class Solution {
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return Math.min(res[1], res[2]);
    }
    
    int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0, 0x3f3f3f3f};
        }
        
        int[] left = dfs(cur.left), right = dfs(cur.right);
        
        int[] res = new int[3];
        res[0] = min(left[1], left[2]) + min(right[1], right[2]);
        res[1] = min(left[2] + min(right[1], right[2]), right[2] + min(left[1], left[2]));
        res[2] = 1 + min(left[0], left[1], left[2]) + min(right[0], right[1], right[2]);
        return res;
    }
    
    int min(int... vals) {
        int res = Integer.MAX_VALUE;
        for (int val : vals) {
            res = Math.min(res, val);
        }
        
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}