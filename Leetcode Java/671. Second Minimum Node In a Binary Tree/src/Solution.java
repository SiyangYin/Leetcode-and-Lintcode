public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        long[] A = {Long.MAX_VALUE, Long.MAX_VALUE};
        dfs(root, A);
        return A[1] == Long.MAX_VALUE ? -1 : (int) A[1];
    }
    
    private void dfs(TreeNode cur, long[] A) {
        if (cur == null) {
            return;
        }
        
        if (cur.val < A[0]) {
            A[1] = A[0];
            A[0] = cur.val;
        } else if (cur.val > A[0] && cur.val < A[1]) {
            A[1] = cur.val;
        }
        
        dfs(cur.left, A);
        dfs(cur.right, A);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}