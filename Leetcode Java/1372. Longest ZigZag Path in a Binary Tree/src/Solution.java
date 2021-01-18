public class Solution {
    
    private int res;
    
    public int longestZigZag(TreeNode root) {
        res = 1;
        dfs(root);
        return res - 1;
    }
    
    // 返回从cur向左向右走的最大zigzag路径长度
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        
        int[] left = dfs(cur.left), right = dfs(cur.right);
        res = Math.max(res, 1 + left[1]);
        res = Math.max(res, 1 + right[0]);
        
        return new int[]{1 + left[1], 1 + right[0]};
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        root.right.right.left.right = new TreeNode(5);
        System.out.println(new Solution().longestZigZag(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}