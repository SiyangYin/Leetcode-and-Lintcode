public class Solution {
    
    private int res;
    
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, new int[]{root.val, root.val});
        return res;
    }
    
    private void dfs(TreeNode cur, int[] nums) {
        if (cur == null) {
            return;
        }
        
        res = Math.max(res, Math.abs(cur.val - nums[0]));
        res = Math.max(res, Math.abs(cur.val - nums[1]));
        
        int[] tmp = {nums[0], nums[1]};
        nums[0] = Math.max(nums[0], cur.val);
        nums[1] = Math.min(nums[1], cur.val);
        
        dfs(cur.left, nums);
        dfs(cur.right, nums);
        
        nums[0] = tmp[0];
        nums[1] = tmp[1];
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}