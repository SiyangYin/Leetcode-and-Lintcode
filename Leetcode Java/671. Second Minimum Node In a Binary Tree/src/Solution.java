public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        long[] A = {root.val, Long.MAX_VALUE};
        dfs(root, A);
        return A[1] == Long.MAX_VALUE ? -1 : (int) A[1];
    }
    
    private void dfs(TreeNode cur, long[] A) {
        if (cur == null) {
            return;
        }
        
        if (cur.val > A[0]) {
            A[1] = Math.min(cur.val, A[1]);
            return;
        }
        
        if (cur.val == A[0]) {
            dfs(cur.left, A);
            dfs(cur.right, A);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}