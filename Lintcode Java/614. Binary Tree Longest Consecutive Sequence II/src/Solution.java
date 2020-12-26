public class Solution {
    
    private int res;
    
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        int[] left = dfs(cur.left), right = dfs(cur.right);
        int upLen = 1, downLen = 1;
        if (left != null) {
            if (cur.left.val == cur.val + 1) {
                upLen = Math.max(upLen, 1 + left[0]);
            }
            if (cur.left.val == cur.val - 1) {
                downLen = Math.max(downLen, 1 + left[1]);
            }
        }
        if (right != null) {
            if (cur.right.val == cur.val + 1) {
                upLen = Math.max(upLen, 1 + right[0]);
            }
            if (cur.right.val == cur.val - 1) {
                downLen = Math.max(downLen, 1 + right[1]);
            }
        }
        
        res = Math.max(res, upLen + downLen - 1);
        
        return new int[]{upLen, downLen};
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}